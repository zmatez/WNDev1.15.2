package com.matez.wildnature.world.generation.geology.vein;

/**
 * https://lh3.googleusercontent.com/proxy/zQGPrcc_GeIxeC1JyKKJCFvDEH9PE3zz_rafu0INpPFRpLnYTeF6EO8feS9W-X_UpJLfD_IbaSxKPdk08pryjOX27iYM8P2pHN_jIwS0MD3RWwhI3Aiir5UGkw
 */
public class VeinType {

    public enum shape {
        straight,
        sigmoidal,
        irregular,
        faultvein,
    }

    public enum connect {
        isolated,
        single,
        branched,
        network,
    }

    public enum structure {
        uniform,
        banded,
        haloed,
        intravenous,
    }

}
