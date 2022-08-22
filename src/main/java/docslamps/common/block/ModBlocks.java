package docslamps.common.block;

import java.util.List;

public class ModBlocks {
    public static List<FlatLamp> FlatLamps;

    static {
        FlatLamps = FlatLamp.allColorVariants();
    }
}
