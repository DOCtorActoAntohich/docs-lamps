package docslamps.common.item;

import docslamps.common.block.FlatLamp;
import docslamps.common.block.ModBlocks;
import net.minecraft.item.ItemBlock;

import java.util.List;

public class ModItems {
    public static List<ItemBlock> FlatLamps;

    static {
        FlatLamps = FlatLamp.itemBlocks(ModBlocks.FlatLamps);
    }
}
