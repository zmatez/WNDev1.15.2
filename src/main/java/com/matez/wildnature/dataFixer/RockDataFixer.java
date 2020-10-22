package com.matez.wildnature.dataFixer;

import com.mojang.datafixers.DataFix;
import com.mojang.datafixers.DataFixerUpper;
import com.mojang.datafixers.schemas.Schema;
import it.unimi.dsi.fastutil.ints.Int2ObjectSortedMap;
import it.unimi.dsi.fastutil.ints.IntSortedSet;

import java.util.List;

public class RockDataFixer extends DataFixerUpper {
    protected RockDataFixer(Int2ObjectSortedMap<Schema> schemas, List<DataFix> globalList, IntSortedSet fixerVersions) {
        super(schemas, globalList, fixerVersions);
    }
}
