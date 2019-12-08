package com.aoc2019;

import com.InputFetcher;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution by boriskurikhin (github)
 */
public class CrossedWiresOther {

    //returns direction coords given {L,R,U,D}
    public static int[] getDir (char c) {
        switch (c) {
            case 'U': return new int[] {0,1};
            case 'D': return new int[] {0,-1};
            case 'L': return new int[] {-1,0};
            case 'R': return new int[] {1,0};
        }
        return null;
    }

    public static void main(String[] args) {

        InputFetcher inputFetcher = new InputFetcher("aoc2019-d3", "\n");
        String[] input = inputFetcher.getInputDataAsArrayOfStrings();
        String[] wireOnePoints = input[0].split(",");
        String[] wireTwoPoints = input[1].split(",");
        Map<String, Integer> wire = new HashMap<>();

        int closestDistance = Integer.MAX_VALUE;
        int shortestWire = Integer.MAX_VALUE;

        int x = 0, y = 0, d = 0;

        for (String wireOnePoint : wireOnePoints) {
            int[] dir = getDir(wireOnePoint.charAt(0));
            int len = Integer.parseInt(wireOnePoint.substring(1));
            for (int j = 0; j < len; j++) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                wire.put(newX + "_" + newY, ++d);
                x = newX;
                y = newY;
            }
        }
       // input = r.readLine().split(",");
        x = y = d = 0;
        for (String wireTwoPoint : wireTwoPoints) {
            int[] dir = getDir(wireTwoPoint.charAt(0));
            int len = Integer.parseInt(wireTwoPoint.substring(1));
            for (int j = 0; j < len; j++) {

                int newX = x + dir[0];
                int newY = y + dir[1];
                d++;

                if (wire.containsKey(newX + "_" + newY)) {
                    closestDistance = Math
                        .min(closestDistance, Math.abs(newX) + Math.abs(newY)); /* Part 1 */
                    shortestWire = Math.min(shortestWire, wire.get(newX + "_" + newY) + d);
                }
                x = newX;
                y = newY;
            }
        }
        System.out.println("closestDistance = " + closestDistance); /* Part 1 */
        System.out.println("shortestWire = " + shortestWire);
    }
}
