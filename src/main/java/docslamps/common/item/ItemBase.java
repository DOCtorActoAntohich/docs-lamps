package docslamps.common.item;

import docslamps.DocsLamps;
import docslamps.common.creativetab.DocsLampsCreativeTab;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase(String name) {
        this.setRegistryName(name);
        this.setTranslationKey(name);
        this.setCreativeTab(DocsLampsCreativeTab.getInstance());

        ModItems.ITEMS.add(this);
    }

    public void registerModels() {
        DocsLamps.commonProxy.registerItemRenderer(
                this, 0, "inventory"
        );
    }
}
