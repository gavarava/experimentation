package com.kattis.treasurehunt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class TunnelStartComparatorTest {

    @Test
    void check() {
        Tunnel tunnel4 = new Tunnel(10000, 3, 5);
        Tunnel tunnel5 = new Tunnel(12, 4, 6);

        Tunnel[] availableTunnels2 = {tunnel4, tunnel5};
        List<Tunnel> list = Arrays.asList(availableTunnels2);
        System.out.println(list);
        Collections.sort(list, new TunnelStartComparator());
        System.out.println(list);
    }

}