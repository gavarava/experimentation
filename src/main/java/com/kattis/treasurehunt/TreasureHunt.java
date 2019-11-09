package com.kattis.treasurehunt;

import static java.lang.Integer.parseInt;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TreasureHunt {

    private static final String WHITESPACE = "\\s";

    public static void main(String[] args) throws FileNotFoundException {
        initializeCaveSystem();
    }

    private static void initializeCaveSystem() {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
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

            CaveSystem caveSystem = new CaveSystem(numberOfCaves, numberOfTunnels, numberOfIdols);
            caveSystem.setTunnels(tunnelsList);

            String idolsToCaveMapping = sc.nextLine();
            HashMap<String, Integer> caveToIdolCountMap = setupCaveToIdolCountMapFromInput(idolsToCaveMapping);
            caveSystem.setCaveToIdolCountMap(caveToIdolCountMap);

            String unitsOfAir = sc.nextLine();
            System.out.println(caveSystem.calculateNumberOfIdolsRecoverable(Integer.parseInt(unitsOfAir)));
            numberOfTestCases--;
        }
    }

    static ArrayList<Tunnel> setupTunnelDetails(Scanner sc, int numberOfTunnels) {
        ArrayList<Tunnel> tunnelArray = new ArrayList<>(numberOfTunnels);
        for (int i = 0; i < numberOfTunnels; i++) {
            String tunnelDetailsString = sc.nextLine();
            String[] tunnelDetailsValues = tunnelDetailsString.split(WHITESPACE);
            tunnelArray.add(new Tunnel(parseInt(tunnelDetailsValues[0]),
                parseInt(tunnelDetailsValues[1]), parseInt(tunnelDetailsValues[2])));
        }
        return tunnelArray;
    }

    static HashMap<String, Integer> setupCaveToIdolCountMapFromInput(String idolsToCaveMapping) {
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
}
