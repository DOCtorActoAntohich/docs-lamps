package docslamps.common.creativetab;

import docslamps.ModInfo;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@MethodsReturnNonnullByDefault
public class DocsLampsCreativeTab extends CreativeTabs {

    private static final DocsLampsCreativeTab instance;
    static {
        instance = new DocsLampsCreativeTab();
    }

    private DocsLampsCreativeTab() {
        super(ModInfo.MODID);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.GLOWSTONE_DUST);
    }

    public static DocsLampsCreativeTab getInstance() {
        return instance;
    }
}
