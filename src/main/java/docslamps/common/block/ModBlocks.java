package docslamps.common.block;

import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block FLAT_LAMP_BLACK;
    public static final Block FLAT_LAMP_BLUE;
    public static final Block FLAT_LAMP_BROWN;
    public static final Block FLAT_LAMP_CYAN;
    public static final Block FLAT_LAMP_GRAY;
    public static final Block FLAT_LAMP_GREEN;
    public static final Block FLAT_LAMP_LIGHT_BLUE;
    public static final Block FLAT_LAMP_LIME;
    public static final Block FLAT_LAMP_MAGENTA;
    public static final Block FLAT_LAMP_ORANGE;
    public static final Block FLAT_LAMP_PINK;
    public static final Block FLAT_LAMP_PURPLE;
    public static final Block FLAT_LAMP_RED;
    public static final Block FLAT_LAMP_SILVER;
    public static final Block FLAT_LAMP_WHITE;
    public static final Block FLAT_LAMP_YELLOW;

    static {
        FLAT_LAMP_BLACK = new FlatLamp("flat_lamp_black");
        FLAT_LAMP_BLUE = new FlatLamp("flat_lamp_blue");
        FLAT_LAMP_BROWN = new FlatLamp("flat_lamp_brown");
        FLAT_LAMP_CYAN = new FlatLamp("flat_lamp_cyan");
        FLAT_LAMP_GRAY = new FlatLamp("flat_lamp_gray");
        FLAT_LAMP_GREEN = new FlatLamp("flat_lamp_green");
        FLAT_LAMP_LIGHT_BLUE = new FlatLamp("flat_lamp_light_blue");
        FLAT_LAMP_LIME = new FlatLamp("flat_lamp_lime");
        FLAT_LAMP_MAGENTA = new FlatLamp("flat_lamp_magenta");
        FLAT_LAMP_ORANGE = new FlatLamp("flat_lamp_orange");
        FLAT_LAMP_PINK = new FlatLamp("flat_lamp_pink");
        FLAT_LAMP_PURPLE = new FlatLamp("flat_lamp_purple");
        FLAT_LAMP_RED = new FlatLamp("flat_lamp_red");
        FLAT_LAMP_SILVER = new FlatLamp("flat_lamp_silver");
        FLAT_LAMP_WHITE = new FlatLamp("flat_lamp_white");
        FLAT_LAMP_YELLOW = new FlatLamp("flat_lamp_yellow");
    }
}
