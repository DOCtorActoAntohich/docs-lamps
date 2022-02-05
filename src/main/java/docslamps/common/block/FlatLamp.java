package docslamps.common.block;

import docslamps.DocsLamps;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FlatLamp extends Block {

    public static final String TRANSLATION_KEY = "flat_lamp";
    public static final String REGISTRY_NAME = "flat_lamp";

    public FlatLamp() {
        super(Material.IRON);

        this.setCreativeTab(DocsLamps.modCreativeTab);
        this.setTranslationKey(TRANSLATION_KEY);
        this.setRegistryName(REGISTRY_NAME);
    }
}
