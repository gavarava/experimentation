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
        Tunnel currentTunnel = nearestTunnelFinder.getShortestUnvisitedTunnelFromStartingPoint();
        Tunnel previousTunnel = null;
        while (totalAvailableIdols != 0 || idolsCount != 8) {
            currentTunnel.setVisited(true);
            if (currentTunnel.getStartingPointCave() == startingPoint) {
                unitsOfAir = reduceAmountOfAirConsumed(unitsOfAir, currentTunnel);
                Integer recoverableIdolsCountFromCurrentTunnel = getRecoverableIdolsCount(currentTunnel);
                if (unitsOfAir < 0) {
                    break;
                } else if (unitsOfAir > 0) {
                    idolsCount = takeIdolsWhenfound(idolsCount, recoverableIdolsCountFromCurrentTunnel);
                } else if (unitsOfAir == 0) {
                    idolsCount = takeIdolsWhenfound(idolsCount, recoverableIdolsCountFromCurrentTunnel);
                    // break since unitsOfAir have been exhausted after this dive
                    break;
                }
            } else {
                if (currentTunnel != null) {
                    if (previousTunnel.getDestination() == currentTunnel.getStartingPointCave()) {
                        unitsOfAir = reduceAmountOfAirConsumed(unitsOfAir, currentTunnel);
                        Integer recoverableIdolsCountFromCurrentTunnel = getRecoverableIdolsCount(currentTunnel);
                        idolsCount = takeIdolsWhenfound(idolsCount, recoverableIdolsCountFromCurrentTunnel);
                        if (unitsOfAir < 0) {
                            break;
                        } else if (unitsOfAir > 0) {
                            continue;
                        } else if (unitsOfAir == 0) {
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

    private int reduceAmountOfAirConsumed(int unitsOfAir, Tunnel currentTunnel) {
        unitsOfAir -= 2 * currentTunnel.getDistanceInConsumedAirUnits();
        return unitsOfAir;
    }

    private int takeIdolsWhenfound(int idolsCount, Integer recoverableIdolsCountFromCurrentTunnel) {
        if (recoverableIdolsCountFromCurrentTunnel > 0) {
            idolsCount = updateCounts(idolsCount, recoverableIdolsCountFromCurrentTunnel);
        }
        return idolsCount;
    }

    private int updateCounts(int idolsCount, Integer recoverableIdolsCountFromCurrentTunnel) {
        idolsCount += recoverableIdolsCountFromCurrentTunnel;
        totalAvailableIdols -= recoverableIdolsCountFromCurrentTunnel;
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
