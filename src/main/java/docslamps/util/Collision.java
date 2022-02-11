package docslamps.util;

import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.util.vector.Vector3f;

public class Collision {
    // A size of pixel in Minecraft (according to base texture pack).
    public static final float PIXEL_16X = 1.0f / 16;
    public static final int N_PIXELS = 16;
    public static final float BLOCK_SIZE = 1;

    public static final AxisAlignedBB FULL_BLOCK_AABB;

    static {
        FULL_BLOCK_AABB = new AxisAlignedBB(
                0, 0, 0,
                BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE
        );
    }

    public static Vector3f pixel16xVector(int x, int y, int z) {
        return new Vector3f(x * PIXEL_16X, y * PIXEL_16X, z * PIXEL_16X);
    }

    public static AxisAlignedBB pixel16xAABB(int x_pos, int y_pos, int z_pos, int x_size, int y_size, int z_size) {
        Vector3f min = pixel16xVector(x_pos, y_pos, z_pos);
        Vector3f size = pixel16xVector(x_size, y_size, z_size);
        Vector3f max = new Vector3f(min);
        max.translate(size.x, size.y, size.z);
        return new AxisAlignedBB(min.x, min.y, min.z, max.x, max.y, max.z);
    }
}
