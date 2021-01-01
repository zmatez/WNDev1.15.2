package com.matez.wildnature.util.other;

import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

public class ServerUtils {
    public static boolean isValidGround(BlockState plant, BlockState placeState, @Nullable IBlockReader world, @Nullable BlockPos pos) {
        try {
            if (plant.getBlock() instanceof BushBlock) {
                Class<?> clazz = plant.getBlock().getClass();
                Class<?> superclass = clazz;
                Method method = null;
                while (superclass != null) {
                    try {
                        method = superclass.getDeclaredMethod("func_200014_a_", BlockState.class, IBlockReader.class, BlockPos.class);
                        break;
                    } catch (Exception e) {
                        superclass = superclass.getSuperclass();
                    }

                }
                if (method != null) {
                    method.setAccessible(true);
                    return (boolean) method.invoke(placeState, world, pos);
                }
                return false;
            }
        } catch (Exception e) {

        }
        return false;
    }
}
