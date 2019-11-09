package com.kattis.treasurehunt;

import static java.lang.Integer.parseInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class CaveSystemTest {

    private static final String WHITESPACE = "\\s";

    private static final String FILE_PATH = "/home/gaurav/development/learning/myprojects/adventofcode-2018/src/main/resources/";

    private CaveSystem caveSystem;
    private int unitsOfAirForTest;


    @Test
    void getFirstClosestTunnelToTake() throws FileNotFoundException {
        caveSystem = initializeSingleCaveSystem(FILE_PATH + "treasurehunt/treasurehunt_when_many_interconnected_caves_II");
        HashMap<String, ArrayList<Tunnel>> stringArrayListHashMap = caveSystem.setupCaveToLeadingTunnelsMap();
        System.out.println(stringArrayListHashMap);
        System.out.println(caveSystem.getShortestUnvisitedTunnelFromStartingPoint());
    }

    @Test
    void getNextClosestTunnelToTake() throws FileNotFoundException {
        caveSystem = initializeSingleCaveSystem(FILE_PATH + "treasurehunt/treasurehunt_when_many_interconnected_caves_II");
        HashMap<String, ArrayList<Tunnel>> stringArrayListHashMap = caveSystem.setupCaveToLeadingTunnelsMap();
        System.out.println(stringArrayListHashMap);
        ArrayList<Tunnel> tunnels = caveSystem.getTunnels();
        System.out.println(tunnels.get(0));
        System.out.println(caveSystem.getClosestUnvisitedDestination(tunnels.get(0)));
    }

    @Test
    void generateCaveToTunnelMap() throws FileNotFoundException {
        caveSystem = initializeSingleCaveSystem(FILE_PATH + "treasurehunt/treasurehunt_when_many_interconnected_caves_II");
        HashMap<String, ArrayList<Tunnel>> stringArrayListHashMap = caveSystem.setupCaveToLeadingTunnelsMap();
        System.out.println(stringArrayListHashMap);
    }

    @Test
    void calculateNumberOfIdolsRecoverable_WHEN_MANY_INTER_CONNECTED_CAVES_II() throws FileNotFoundException {
        caveSystem = initializeSingleCaveSystem(FILE_PATH + "treasurehunt/treasurehunt_when_many_interconnected_caves_II");
        assertThat(caveSystem.calculateNumberOfIdolsRecoverable(unitsOfAirForTest), is(8));
    }


    @Test
    void calculateNumberOfIdolsRecoverable_WHEN_MANY_INTER_CONNECTED_CAVES() throws FileNotFoundException {
        caveSystem = initializeSingleCaveSystem(FILE_PATH + "treasurehunt/treasurehunt_when_many_interconnected_caves");
        assertThat(caveSystem.calculateNumberOfIdolsRecoverable(unitsOfAirForTest), is(8));
    }


    @Test
    void calculateNumberOfIdolsRecoverable() throws FileNotFoundException {
        caveSystem = initializeSingleCaveSystem(FILE_PATH + "treasurehunt/treasurehunt_onecave_onetunnel_fouridol");
        assertThat(caveSystem.calculateNumberOfIdolsRecoverable(unitsOfAirForTest), is(4));
    }

    @Test
    void calculateNumberOfIdolsRecoverable2() throws FileNotFoundException {
        caveSystem = initializeSingleCaveSystem(FILE_PATH + "treasurehunt/treasurehunt_onecave_2tunnel_4idol");
        assertThat(caveSystem.calculateNumberOfIdolsRecoverable(unitsOfAirForTest), is(4));
    }

    @Test
    void calculateNumberOfIdolsRecoverable3() throws FileNotFoundException {
        caveSystem = initializeSingleCaveSystem(FILE_PATH + "treasurehunt/treasurehunt_3cave_3tunnel_4idol");
        assertThat(caveSystem.calculateNumberOfIdolsRecoverable(unitsOfAirForTest), is(8));
    }

    @Test
    void calculateNumberOfIdolsRecoverable_KattisBasicInput() throws FileNotFoundException {
        caveSystem = initializeSingleCaveSystem(FILE_PATH + "treasurehunt/treasurehunt1");
        assertThat(caveSystem.calculateNumberOfIdolsRecoverable(unitsOfAirForTest), is(1));
    }

    private CaveSystem initializeSingleCaveSystem(String pathToInputFile) throws FileNotFoundException {
        System.setIn(new FileInputStream(
            pathToInputFile));
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
            ArrayList<Tunnel> tunnelArray = setupTunnelDetails(sc, numberOfTunnels);

            int numberOfIdols = parseInt(sc.nextLine());

            CaveSystem caveSystem = new CaveSystem(numberOfCaves, numberOfTunnels, numberOfIdols);
            caveSystem.setTunnels(tunnelArray);

            String idolsToCaveMapping = sc.nextLine();
            HashMap<String, Integer> caveToIdolCountMap = setupCaveToIdolCountMapFromInput(idolsToCaveMapping);
            caveSystem.setCaveToIdolCountMap(caveToIdolCountMap);
            this.caveSystem = caveSystem;
            this.unitsOfAirForTest = Integer.parseInt(sc.nextLine());
            // single input processing
            break;
        }
        return caveSystem;
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

    private HashMap<String, Integer> setupCaveToIdolCountMapFromInput(String idolsToCaveMapping) {
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