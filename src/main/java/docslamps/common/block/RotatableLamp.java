package docslamps.common.block;

import docslamps.common.creativetab.DocsLampsCreativeTab;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@MethodsReturnNonnullByDefault
public abstract class RotatableLamp extends Block {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public RotatableLamp(String name, Material material) {
        super(material);

        this.setRegistryName(name);
        this.setTranslationKey(name);
        this.setCreativeTab(DocsLampsCreativeTab.getInstance());

        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
    }

    public ItemBlock makeItemBlock() {
        ItemBlock itemBlock = new ItemBlock(this);
        itemBlock.setRegistryName(Objects.requireNonNull(getRegistryName()));
        itemBlock.setTranslationKey(getTranslationKey());
        itemBlock.setCreativeTab(getCreativeTab());
        return itemBlock;
    }

    public static <T extends RotatableLamp> List<ItemBlock> itemBlocks(List<T> blocks) {
        return blocks.stream()
                .map(RotatableLamp::makeItemBlock)
                .collect(Collectors.toList());
    }

    public abstract String oreDictName();

    @Override
    @ParametersAreNonnullByDefault
    public boolean doesSideBlockChestOpening(IBlockState blockState, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    @ParametersAreNonnullByDefault
    public boolean isOpaqueCube(IBlockState bs) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    @ParametersAreNonnullByDefault
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    @ParametersAreNonnullByDefault
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
    {
        return canPlaceBlock(worldIn, pos, side);
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        EnumFacing[] list = EnumFacing.values();
        for (EnumFacing enumfacing : list)
        {
            if (canPlaceBlock(worldIn, pos, enumfacing))
            {
                return true;
            }
        }
        return false;
    }

    // Can place Lamps on full blocks.
    @ParametersAreNonnullByDefault
    protected static boolean canPlaceBlock(World worldIn, BlockPos pos, EnumFacing direction)
    {
        BlockPos neighborPos = pos.offset(direction.getOpposite());
        IBlockState neighborState = worldIn.getBlockState(neighborPos);
        Block neighborBlock = neighborState.getBlock();
        boolean isNeighborFaceSolid =
                neighborState.getBlockFaceShape(worldIn, neighborPos, direction) == BlockFaceShape.SOLID;

        return isNeighborFaceSolid &&
                !isExceptionBlockForAttaching(neighborBlock) &&
                !isExceptBlockForAttachWithPiston(neighborBlock);
    }

    @SuppressWarnings("deprecation")
    @Override
    @ParametersAreNonnullByDefault
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return canPlaceBlock(worldIn, pos, facing) ?
                this.getDefaultState().withProperty(FACING, facing) :
                this.getDefaultState().withProperty(FACING, EnumFacing.UP);
    }

    @SuppressWarnings("deprecation")
    @Override
    @ParametersAreNonnullByDefault
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (this.checkForDrop(worldIn, pos, state) && !canPlaceBlock(worldIn, pos, state.getValue(FACING)))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }


    @ParametersAreNonnullByDefault
    private boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this.canPlaceBlockAt(worldIn, pos))
        {
            return true;
        }
        this.dropBlockAsItem(worldIn, pos, state, 0);
        worldIn.setBlockToAir(pos);
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing facing;
        switch (meta)
        {
            case 1:
                facing = EnumFacing.UP;
                break;
            case 2:
                facing = EnumFacing.NORTH;
                break;
            case 3:
                facing = EnumFacing.SOUTH;
                break;
            case 4:
                facing = EnumFacing.WEST;
                break;
            case 5:
                facing = EnumFacing.EAST;
                break;
            case 0:
            default:
                facing = EnumFacing.DOWN;
                break;

        }
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getMetaFromState(IBlockState state)
    {
        switch (state.getValue(FACING))
        {
            case UP:
                return 1;
            case NORTH:
                return 2;
            case SOUTH:
                return 3;
            case WEST:
                return 4;
            case EAST:
                return 5;
            case DOWN:
            default:
                return 0;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    @ParametersAreNonnullByDefault
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    @ParametersAreNonnullByDefault
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING);
    }

    @SuppressWarnings("deprecation")
    @Override
    @ParametersAreNonnullByDefault
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
}
