package com.kattis.treasurehunt;

import static java.lang.String.valueOf;

import java.util.Map;

public class MaximumIdolsFinder {

    private static final int STARTING_NODE = 0;
    // i = 6 mellan 0 och 8
    private int totalAvailableIdols;
    // 1=1, 2=4, 3=1
    private Map<String, Integer> caveToIdolCountMap;
    private NearestTunnelFinder nearestTunnelFinder;

    public MaximumIdolsFinder(int totalAvailableIdols) {
        this.totalAvailableIdols = totalAvailableIdols;
    }

    /**
     * 0 ≤ unitsOfAir ≤ 1000000
     */
    public int calculateNumberOfIdolsRecoverable(int reserveUnitsOfAir) {
        // for every tunnel available first find which tunnel can be visited without exhausting supply
        int startingPoint = STARTING_NODE;
        int idolsCount = 0;
        Tunnel currentTunnel = nearestTunnelFinder.getShortestUnvisitedTunnelFromStartingPoint();
        Tunnel previousTunnel = null;
        while (totalAvailableIdols != 0 || idolsCount != 8) {
            currentTunnel.setVisited(true);
            int caveAtStartOfCurrentTunnel = currentTunnel.getStartingPointCave();
            if (isDiverAt(startingPoint, caveAtStartOfCurrentTunnel)) {
                if (reserveUnitsOfAir <= 0) {
                    break;
                }

                if (isAffordable(reserveUnitsOfAir, currentTunnel.getDistanceInConsumedAirUnits())) {
                    Integer recoverableIdolsCountFromCurrentTunnel = getRecoverableIdolsCount(currentTunnel);
                    idolsCount = takeIdolsWhenfound(idolsCount, recoverableIdolsCountFromCurrentTunnel);
                    reserveUnitsOfAir = reduceAmountOfAirConsumed(reserveUnitsOfAir, currentTunnel);
                } else {
                    break;
                }
            } else {
                if (currentTunnel != null) {
                    if (isDiverAt(caveAtStartOfCurrentTunnel, previousTunnel.getDestination())) {
                        if (reserveUnitsOfAir <= 0) {
                            break;
                        }

                        if (isAffordable(reserveUnitsOfAir, currentTunnel.getDistanceInConsumedAirUnits())) {
                            Integer recoverableIdolsCountFromCurrentTunnel = getRecoverableIdolsCount(currentTunnel);
                            idolsCount = takeIdolsWhenfound(idolsCount, recoverableIdolsCountFromCurrentTunnel);
                            reserveUnitsOfAir = reduceAmountOfAirConsumed(reserveUnitsOfAir, currentTunnel);
                        } else {
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

    private boolean isDiverAt(int startingPoint, int startingPointCave) {
        return startingPointCave == startingPoint;
    }

    private boolean isAffordable(int reserveUnitsOfAir, int distanceInConsumedAirUnits) {
        int distanceToAndFromATunnel = 2 * distanceInConsumedAirUnits;
        return reserveUnitsOfAir >= distanceToAndFromATunnel;
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

    public void setCaveToIdolCountMap(Map<String, Integer> caveToIdolCountMap) {
        this.caveToIdolCountMap = caveToIdolCountMap;
    }

    public void setNearestTunnelFinder(NearestTunnelFinder nearestTunnelFinder) {
        this.nearestTunnelFinder = nearestTunnelFinder;
    }
}
