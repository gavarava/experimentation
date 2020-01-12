package com.kattis.treasurehunt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class NearestTunnelFinderIT {

    private static final String FILE_PATH = "/home/gaurav/development/learning/myprojects/experimentation/src/main/resources/";
    private NearestTunnelFinder nearestTunnelFinder;

    @Test
    void getFirstClosestTunnelToTake() throws FileNotFoundException {
        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver
            .initializeFromFile(FILE_PATH + "treasurehunt/treasurehunt_when_many_interconnected_caves_II");

        NearestTunnelFinder nearestTunnelFinder = treasureDiveSolver.getNearestTunnelFinder();
        Map<String, ArrayList<Tunnel>> caveToLeadingTunnelsMap = nearestTunnelFinder.setupCaveToLeadingTunnelsMap();

        System.out.println(caveToLeadingTunnelsMap);
        System.out.println(nearestTunnelFinder.getShortestUnvisitedTunnelFromStartingPoint());
    }

    @Test
    void getNextClosestTunnelToTake() throws FileNotFoundException {

        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver
            .initializeFromFile(FILE_PATH + "treasurehunt/treasurehunt_when_many_interconnected_caves_II");

        NearestTunnelFinder nearestTunnelFinder = treasureDiveSolver.getNearestTunnelFinder();

        List<Tunnel> tunnels = nearestTunnelFinder.getTunnels();
        System.out.println(tunnels.get(0));
        System.out.println(nearestTunnelFinder.getClosestUnvisitedDestination(tunnels.get(0)));
    }

    @Test
    void getShortestTunnelFromStartingPointWithExclusion() throws FileNotFoundException {

        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver
            .initializeFromFile(FILE_PATH + "treasurehunt/treasurehunt_3cave_3tunnel_4idol");

        NearestTunnelFinder nearestTunnelFinder = treasureDiveSolver.getNearestTunnelFinder();

        List<Tunnel> tunnels = nearestTunnelFinder.getTunnels();
        System.out.println("ALL POSSIBLE TUNNELS ---> \n");
        tunnels.forEach(tunnel -> System.out.println(tunnel));
        System.out.println();

        Tunnel shortestUnvisitedTunnelFromStartingPoint = nearestTunnelFinder
            .getShortestUnvisitedTunnelFromStartingPoint();
        System.out.println("shortestUnvisitedTunnelFromStartingPoint --> " + shortestUnvisitedTunnelFromStartingPoint);

        Tunnel tunnelToBeExcluded = tunnels.get(0);
        assertThat(shortestUnvisitedTunnelFromStartingPoint, is(tunnelToBeExcluded));

        tunnelToBeExcluded.setVisited(true);

        System.out.println("tunnelToBeExcluded --> " + tunnelToBeExcluded);
        Tunnel shortestTunnelFromStartingPointWithExclusion = nearestTunnelFinder
            .getShortestTunnelFromStartingPointWithExclusion(tunnelToBeExcluded);
        System.out.println(
            "shortestTunnelFromStartingPointWithExclusion --> " + shortestTunnelFromStartingPointWithExclusion);

        assertThat(shortestTunnelFromStartingPointWithExclusion, is(tunnels.get(1)));
    }

    @Test
    void generateCaveToTunnelMap() throws FileNotFoundException {
        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver
            .initializeFromFile(
                FILE_PATH + "treasurehunt/treasurehunt_when_many_interconnected_caves_II");

        NearestTunnelFinder nearestTunnelFinder = treasureDiveSolver.getNearestTunnelFinder();
        Map<String, ArrayList<Tunnel>> stringArrayListHashMap = nearestTunnelFinder.setupCaveToLeadingTunnelsMap();

        System.out.println(stringArrayListHashMap);
    }

}