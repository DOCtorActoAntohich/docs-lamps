package docslamps.common.block;

import docslamps.DocsLamps;
import docslamps.common.creativetab.DocsLampsCreativeTab;
import docslamps.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public abstract class BlockBase extends Block {
    public BlockBase(String name, Material material) {
        super(material);

        this.setRegistryName(name);
        this.setTranslationKey(name);
        this.setCreativeTab(DocsLampsCreativeTab.getInstance());
        ModBlocks.BLOCKS.add(this);

        ItemBlock item = new ItemBlock(this);
        item.setRegistryName(name);
        ModItems.ITEMS.add(item);
    }

    public void registerModels() {
        DocsLamps.commonProxy.registerItemRenderer(
                Item.getItemFromBlock(this), 0, "inventory"
        );
    }
}
