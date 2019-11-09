package com.kattis.treasurehunt;

import static java.lang.Integer.parseInt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TreasureDiveSolver {

    private static final String WHITESPACE = "\\s";

    private MaximumIdolsFinder[] maximumIdolsFinder;
    private NearestTunnelFinder[] nearestTunnelFinder;
    private int[] availableUnitsOfAir;
    private int testCases;

    public void initializeFromFile(String filePath) throws FileNotFoundException {
        System.setIn(new FileInputStream(
            filePath));
        initializeFromSystemIn();
    }

    public void initializeFromSystemIn() {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        maximumIdolsFinder = new MaximumIdolsFinder[numberOfTestCases];
        nearestTunnelFinder = new NearestTunnelFinder[numberOfTestCases];
        availableUnitsOfAir = new int[numberOfTestCases];

        sc.nextLine();
        while (sc.hasNext()) {
            if (numberOfTestCases == 0) {
                break;
            }
            String cavesAndTunnels = sc.nextLine();
            String[] split = cavesAndTunnels.split(WHITESPACE);
            int numberOfCaves = parseInt(split[0]);
            int numberOfTunnels = parseInt(split[1]);
            ArrayList<Tunnel> tunnelsList = setupTunnelDetails(sc, numberOfTunnels);

            int numberOfIdols = parseInt(sc.nextLine());

            maximumIdolsFinder[testCases] = new MaximumIdolsFinder(numberOfIdols);

            String idolsToCaveMapping = sc.nextLine();
            HashMap<String, Integer> caveToIdolCountMap = setupCaveToIdolCountMapFromInput(idolsToCaveMapping);
            maximumIdolsFinder[testCases].setCaveToIdolCountMap(caveToIdolCountMap);
            nearestTunnelFinder[testCases] = new NearestTunnelFinder(tunnelsList, caveToIdolCountMap,
                numberOfCaves);
            maximumIdolsFinder[testCases].setNearestTunnelFinder(nearestTunnelFinder[testCases]);

            String unitsOfAir = sc.nextLine();
            availableUnitsOfAir[testCases] = Integer.parseInt(unitsOfAir);

            // Initialize nearestTunnelFinder
            nearestTunnelFinder[testCases].initialize();
            numberOfTestCases--;
            testCases++;
        }
    }

    private ArrayList<Tunnel> setupTunnelDetails(Scanner sc, int numberOfTunnels) {
        ArrayList<Tunnel> tunnelArray = new ArrayList<>(numberOfTunnels);
        for (int i = 0; i < numberOfTunnels; i++) {
            String tunnelDetailsString = sc.nextLine();
            String[] tunnelDetailsValues = tunnelDetailsString.split(WHITESPACE);
            tunnelArray.add(new Tunnel(parseInt(tunnelDetailsValues[0]),
                parseInt(tunnelDetailsValues[1]), parseInt(tunnelDetailsValues[2])));
        }
        return tunnelArray;
    }

    public HashMap<String, Integer> setupCaveToIdolCountMapFromInput(String idolsToCaveMapping) {
        String[] idolToCaveMappingArray = idolsToCaveMapping.split(WHITESPACE);
        HashMap<String, Integer> caveToIdolCountMap = new HashMap<>();
        for (int i = 0; i < idolToCaveMappingArray.length; i++) {
            String caveNumber = idolToCaveMappingArray[i];
            if (caveToIdolCountMap.containsKey(caveNumber)) {
                Integer idolCount = caveToIdolCountMap.get(caveNumber);
                caveToIdolCountMap.put(caveNumber, ++idolCount);
            } else {
                caveToIdolCountMap.put(caveNumber, 1);
            }
        }
        return caveToIdolCountMap;
    }

    public void printNumberOfIdolsRecoverableFromCaveSystem(PrintStream out) {
        for (int i = 0; i < testCases; i++) {
            out.println(maximumIdolsFinder[i].calculateNumberOfIdolsRecoverable(availableUnitsOfAir[i]));
        }
    }

    public MaximumIdolsFinder getMaximumIdolsFinder() {
        return maximumIdolsFinder[0];
    }

    public NearestTunnelFinder getNearestTunnelFinder() {
        return nearestTunnelFinder[0];
    }

    public int getAvailableUnitsOfAir() {
        return availableUnitsOfAir[0];
    }
}
