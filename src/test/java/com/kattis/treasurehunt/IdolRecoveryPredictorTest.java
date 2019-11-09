package com.kattis.treasurehunt;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class IdolRecoveryPredictorTest {

    @Test
    void setupTunnelDetails() {
        String caveToIdolsMapping = "1 1 3 4";
        HashMap<String, Integer> result = TreasureHunt
            .setupCaveToIdolCountMapFromInput(caveToIdolsMapping);
        System.out.println(result);
    }
}