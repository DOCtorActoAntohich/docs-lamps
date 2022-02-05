package docslamps;

import docslamps.common.block.FlatLamp;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.apache.logging.log4j.Logger;

@Mod(modid = DocsLamps.MODID, name = DocsLamps.NAME, version = DocsLamps.VERSION)
public class DocsLamps
{
    public static final String MODID = "docslamps";
    public static final String NAME = "DOC's Lamps";
    public static final String VERSION = "1.0";

    private static Logger logger;

    public static final CreativeTabs modCreativeTab = new CreativeTabs(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.GLOWSTONE_DUST);
        }
    };


    public static FlatLamp flatLampInstance;
    public static ItemBlock flatLampItem;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        flatLampInstance = new FlatLamp();
        ForgeRegistries.BLOCKS.register(flatLampInstance);

        flatLampItem = new ItemBlock(flatLampInstance);
        flatLampItem.setRegistryName(flatLampInstance.getRegistryName());
        ForgeRegistries.ITEMS.register(flatLampItem);

        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(
                new ResourceLocation(MODID, FlatLamp.REGISTRY_NAME),
                "normal"
        );
        final int DEFAULT_ITEM_SUBTYPE = 0;
        ModelLoader.setCustomModelResourceLocation(flatLampItem, DEFAULT_ITEM_SUBTYPE, modelResourceLocation);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}
