package com.kattis.treasurehunt;

import static java.lang.String.valueOf;

import java.util.HashMap;

public class MaximumIdolsFinder {

    private static final int STARTING_NODE = 0;
    // i = 6 mellan 0 och 8
    private int totalAvailableIdols;
    // 1=1, 2=4, 3=1
    private HashMap<String, Integer> caveToIdolCountMap;
    private NearestTunnelFinder nearestTunnelFinder;

    public MaximumIdolsFinder(int totalAvailableIdols) {
        this.totalAvailableIdols = totalAvailableIdols;
    }

    /**
     * 0 ≤ unitsOfAir ≤ 1000000
     */
    public int calculateNumberOfIdolsRecoverable(int unitsOfAir) {
        // for every tunnel available first find which tunnel can be visited without exhausting supply
        int startingPoint = STARTING_NODE;
        int idolsCount = 0;
        // Sort Tunnels to enable faster consumption of each available tunnel
        Tunnel currentTunnel = nearestTunnelFinder.getShortestUnvisitedTunnelFromStartingPoint();
        Tunnel previousTunnel = null;
        while (totalAvailableIdols != 0 || idolsCount != 8) {
            // Mark this as visited
            currentTunnel.setVisited(true);
            if (currentTunnel.getStartingPointCave() == startingPoint) {
                Integer recoverableIdolsCountFromCurrentTunnel = getRecoverableIdolsCount(currentTunnel);
                unitsOfAir -= 2 * currentTunnel.getDistanceInConsumedAirUnits();
                // Entire if else section deals with getting idols from current tunnel
                if (unitsOfAir < 0) {
                    break;
                } else if (unitsOfAir > 0) {
                    recoverableIdolsCountFromCurrentTunnel = getRecoverableIdolsCount(currentTunnel);
                    // if idols found at current tunnel then set it as closestWith Idols
                    if (recoverableIdolsCountFromCurrentTunnel > 0) {
                        idolsCount += recoverableIdolsCountFromCurrentTunnel;
                        totalAvailableIdols -= recoverableIdolsCountFromCurrentTunnel;
                    }
                } else if (unitsOfAir == 0) {
                    recoverableIdolsCountFromCurrentTunnel = getRecoverableIdolsCount(currentTunnel);
                    // if idols found at current tunnel then set it as closestWith Idols
                    if (recoverableIdolsCountFromCurrentTunnel > 0) {
                        idolsCount += recoverableIdolsCountFromCurrentTunnel;
                        totalAvailableIdols -= recoverableIdolsCountFromCurrentTunnel;
                    }
                    // break since unitsOfAir have been exhausted after this dive
                    break;
                }
            } else {
                // When the caves are interconnected with each other
                if (currentTunnel != null) {
                    //tunnel = nextClosestTunnel;
                    if (previousTunnel.getDestination() == currentTunnel.getStartingPointCave()) {
                        Integer recoverableIdolsCountFromCurrentTunnel = getRecoverableIdolsCount(currentTunnel);
                        // if idols found at current tunnel then take idols
                        if (recoverableIdolsCountFromCurrentTunnel > 0) {
                            idolsCount += recoverableIdolsCountFromCurrentTunnel;
                            totalAvailableIdols -= recoverableIdolsCountFromCurrentTunnel;
                        }
                        // Reduce Amount of air used
                        unitsOfAir -= 2 * currentTunnel.getDistanceInConsumedAirUnits();
                        if (unitsOfAir < 0) {
                            break;
                        } else if (unitsOfAir > 0) {
                            continue;
                        } else if (unitsOfAir == 0) {
                            // break since unitsOfAir have been exhausted after this dive
                            break;
                        }
                    }
                }
            }
            previousTunnel = currentTunnel;
            // Decide where to move next
            currentTunnel = nearestTunnelFinder.getClosestUnvisitedDestination(currentTunnel);
            if (currentTunnel == null) {
                // As there is no new destination
                break;
            }
        }
        return idolsCount;
    }


    private Integer getRecoverableIdolsCount(Tunnel closestTunnel) {
        String caveNumber = valueOf(closestTunnel.getDestination());
        return caveToIdolCountMap.containsKey(caveNumber) ? caveToIdolCountMap.get(caveNumber) : 0;
    }

    public void setCaveToIdolCountMap(HashMap<String, Integer> caveToIdolCountMap) {
        this.caveToIdolCountMap = caveToIdolCountMap;
    }

    public void setNearestTunnelFinder(NearestTunnelFinder nearestTunnelFinder) {
        this.nearestTunnelFinder = nearestTunnelFinder;
    }
}
