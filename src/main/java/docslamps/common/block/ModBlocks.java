package docslamps.common.block;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block FLAT_LAMP;

    static {
        FLAT_LAMP = new FlatLamp("flat_lamp");
    }
}
