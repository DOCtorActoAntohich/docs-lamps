package docslamps.util;

import docslamps.DocsLamps;
import docslamps.common.block.ModBlocks;
import docslamps.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        registerItems(registry, ModItems.FlatLamps);
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        registerBlocks(registry, ModBlocks.FlatLamps);
    }

    public static <T extends Item> void registerItems(IForgeRegistry<Item> registry, List<T> items) {
        for (T item : items) {
            registry.register(item);
        }
    }

    public static <T extends Block> void registerBlocks(IForgeRegistry<Block> registry, List<T> blocks) {
        for (T block : blocks) {
            registry.register(block);
        }
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ModItems.FlatLamps) {
            DocsLamps.commonProxy.registerItemRenderer(
                    item, 0, "inventory"
            );
        }
    }
}
