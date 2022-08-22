package docslamps.util;

import docslamps.common.block.ModBlocks;
import docslamps.common.block.RotatableLamp;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class OreDictRegistration {
    public static void registerOreDictItems() {
        registerItemCollection(ModBlocks.FlatLamps);
    }

    private static <T extends RotatableLamp> void registerItemCollection(List<T> entities) {
        for (T entity : entities) {
            OreDictionary.registerOre(entity.oreDictName(), entity);
        }
    }
}
