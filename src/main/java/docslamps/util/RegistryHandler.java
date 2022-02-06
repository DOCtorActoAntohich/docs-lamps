package docslamps.util;

import docslamps.common.block.LampBase;
import docslamps.common.block.ModBlocks;
import docslamps.common.item.ItemBase;
import docslamps.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBanner;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.rmi.registry.Registry;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        for (Item item : ModItems.ITEMS) {
            registry.register(item);
        }
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        for (Block block : ModBlocks.BLOCKS) {
            registry.register(block);
        }
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ModItems.ITEMS) {
            if (item instanceof ItemBase) {
                ((ItemBase)item).registerModels();
            }
        }

        for (Block block : ModBlocks.BLOCKS) {
            if (block instanceof LampBase) {
                ((LampBase)block).registerModels();
            }
        }
    }
}
