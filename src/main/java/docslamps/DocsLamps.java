package docslamps;

import docslamps.proxy.CommonProxy;
import docslamps.util.OreDictRegistration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class DocsLamps
{
    @SidedProxy(clientSide = ModInfo.CLIENT, serverSide = ModInfo.COMMON)
    public static CommonProxy commonProxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        OreDictRegistration.registerOreDictItems();
    }
}
