package com.matez.wildnature.world.generation.geology.vein;

import net.minecraft.block.Block;

import java.util.List;

/**
 * https://lh3.googleusercontent.com/proxy/zQGPrcc_GeIxeC1JyKKJCFvDEH9PE3zz_rafu0INpPFRpLnYTeF6EO8feS9W-X_UpJLfD_IbaSxKPdk08pryjOX27iYM8P2pHN_jIwS0MD3RWwhI3Aiir5UGkw
 */
public class VeinConfig {

    public List<Block> block;
    public int maxY;
    public int minY;
    public int size;
    public VeinType.shape shape;
    public VeinType.connect connect;
    public VeinType.structure structure;

    public VeinConfig(
            List<Block> block,
            int maxY,
            int minY,
            int size,
            VeinType.shape shape,
            VeinType.connect connect,
            VeinType.structure structure
    ){
        this.block = block;
        this.maxY = maxY;
        this.minY = minY;
        this.size = size;
        this.shape = shape;
        this.connect = connect;
        this.structure = structure;
    }

}
