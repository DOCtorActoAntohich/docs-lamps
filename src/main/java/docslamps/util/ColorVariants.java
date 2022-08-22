package docslamps.util;

import net.minecraft.item.EnumDyeColor;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ColorVariants {
    public static final List<String> Values;

    static {
        Values = getColorVariants();
    }

    public static List<String> getColorVariants() {
        return Arrays.stream(EnumDyeColor.values())
                .map(color -> color.getName().toLowerCase(Locale.ROOT))
                .sorted()
                .collect(Collectors.toList());
    }

    public static String nameWithColor(String name, String color) {
        return name + "_" + color;
    }
}
