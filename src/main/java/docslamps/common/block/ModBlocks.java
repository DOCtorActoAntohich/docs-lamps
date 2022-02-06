package docslamps.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block FLAT_LAMP = new FlatLamp("flat_lamp", Material.IRON);
}
