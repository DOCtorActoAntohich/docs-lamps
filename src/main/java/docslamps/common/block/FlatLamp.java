package docslamps.common.block;

import docslamps.util.Collision;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
public class FlatLamp extends RotatableLamp {

    public static final AxisAlignedBB AABB_FACING_UP;
    public static final AxisAlignedBB AABB_FACING_DOWN;
    public static final AxisAlignedBB AABB_FACING_NORTH;
    public static final AxisAlignedBB AABB_FACING_SOUTH;
    public static final AxisAlignedBB AABB_FACING_WEST;
    public static final AxisAlignedBB AABB_FACING_EAST;

    static {
        // Values in pixels.
        final int start = 4;
        final int horSize = 8;
        final int verSize = 1;

        AABB_FACING_UP = Collision.pixel16xAABB(
                start, 0, start,
                horSize, verSize, horSize
        );
        AABB_FACING_DOWN = Collision.pixel16xAABB(
                start, Collision.N_PIXELS - verSize, start,
                horSize, verSize, horSize
        );
        AABB_FACING_NORTH = Collision.pixel16xAABB(
                start, start, Collision.N_PIXELS - verSize,
                horSize, horSize, verSize
        );
        AABB_FACING_SOUTH = Collision.pixel16xAABB(
                start, start, 0,
                horSize, horSize, verSize
        );
        AABB_FACING_WEST = Collision.pixel16xAABB(
                Collision.N_PIXELS - verSize, start, start,
                verSize, horSize, horSize
        );
        AABB_FACING_EAST = Collision.pixel16xAABB(
                0, start, start,
                verSize, horSize, horSize
        );
    }

    public FlatLamp(String name) {
        super(name, Material.IRON);

        this.setLightLevel(1.0f);
        this.setHardness(0.3f);
        this.setResistance(0.5f);
    }

    @Override
    @ParametersAreNonnullByDefault
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(FACING)) {
            case UP:
                return AABB_FACING_UP;
            case DOWN:
                return AABB_FACING_DOWN;
            case NORTH:
                return AABB_FACING_NORTH;
            case SOUTH:
                return AABB_FACING_SOUTH;
            case WEST:
                return AABB_FACING_WEST;
            case EAST:
                return AABB_FACING_EAST;
            default:
                return Collision.FULL_BLOCK_AABB;
        }
    }
}
