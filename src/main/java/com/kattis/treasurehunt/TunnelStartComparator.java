package com.kattis.treasurehunt;

import java.util.Comparator;

public class TunnelStartComparator implements Comparator<Tunnel> {

    @Override
    public int compare(Tunnel tunnel1, Tunnel tunnel2) {
        return Integer.valueOf(tunnel1.getStartingPointCave())
            .compareTo(Integer.valueOf(tunnel2.getStartingPointCave()));
    }
}
