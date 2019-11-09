package com.kattis.treasurehunt;

import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;

public class CaveSystem {

    private static final int STARTING_NODE = 0;
    private static final String STARTING_POINT = "0";
    // 1≤n≤10000
    private int numberOfCaves;
    // 0≤m≤50000
    private int numberOfConnectingTunnels;
    private ArrayList<Tunnel> tunnels;
    // i = 6 mellan 0 och 8
    private int totalAvailableIdols;
    // 1=1, 2=4, 3=1
    private HashMap<String, Integer> caveToIdolCountMap;
    private HashMap<String, ArrayList<Tunnel>> caveToLeadingTunnelsMap;

    public CaveSystem(int numberOfCaves, int numberOfConnectingTunnels, int totalAvailableIdols) {
        this.numberOfCaves = numberOfCaves;
        this.numberOfConnectingTunnels = numberOfConnectingTunnels;
        this.totalAvailableIdols = totalAvailableIdols;
    }

    /**
     * 0 ≤ unitsOfAir ≤ 1000000
     */
    public int calculateNumberOfIdolsRecoverable(int unitsOfAir) {
        this.caveToLeadingTunnelsMap = setupCaveToLeadingTunnelsMap();
        // for every tunnel available first find which tunnel can be visited without exhausting supply
        int startingPoint = 0;
        int idolsCount = 0;
        // Sort Tunnels to enable faster consumption of each available tunnel
        Tunnel currentTunnel = getShortestUnvisitedTunnelFromStartingPoint();
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
            currentTunnel = getClosestUnvisitedDestination(currentTunnel);
            if (currentTunnel == null) {
                // As there is no new destination
                break;
            }
        }
        return idolsCount;

    }

    /**
     * This will give the next recommended tunnel to use
     */
    Tunnel getClosestUnvisitedDestination(Tunnel currentTunnel) {
        Tunnel nextClosestTunnel = null;
        int destinationCaveOfCurrentTunnel = currentTunnel.getDestination();
        // Get the ones that start with destination of current one
        ArrayList<Tunnel> connectingTunnels = caveToLeadingTunnelsMap
            .get(valueOf(destinationCaveOfCurrentTunnel));
        if (connectingTunnels != null) {
            Optional<Tunnel> nextConnectedTunnel = getNextUnvisitedTunnelWithIdols(currentTunnel, connectingTunnels);
            // Sanitize nextSuggestedTunnelOptional & get value
            nextClosestTunnel = nextConnectedTunnel.isPresent() ? nextConnectedTunnel.get() : null;
        }
        if (nextClosestTunnel == null) {
            // if reccommended closest destination was not connected then its possible that there is
            // a place to go from the starting point again
            nextClosestTunnel = getShortestTunnelFromStartingPointWithExclusion(currentTunnel);
        }
        return nextClosestTunnel;
    }

    private Optional<Tunnel> getNextUnvisitedTunnelWithIdols(Tunnel currentTunnel,
        ArrayList<Tunnel> connectingTunnels) {
        boolean foundTunnelWithIdols = false;

        return connectingTunnels.stream()
            .filter(tunnelFromSuggestions -> !tunnelFromSuggestions.equals(currentTunnel))
            .filter(tunnelFromSuggestions -> !tunnelFromSuggestions.isVisited())
            .filter(tunnelFromSuggestions -> hasIdols(tunnelFromSuggestions))
            .min(Comparator.comparing(Tunnel::getDistanceInConsumedAirUnits));
    }

    private boolean hasIdols(Tunnel tunnel) {
        int tunnelDestination = tunnel.getDestination();
        Integer count = caveToIdolCountMap.get(valueOf(tunnelDestination));
        if (count != null) {
            return (count > 0);
        }
        return false;
    }


    Tunnel getShortestUnvisitedTunnelFromStartingPoint() {
        Tunnel nextClosestTunnel = null;
        // Get the ones that start with destination of current one
        ArrayList<Tunnel> connectingTunnels = caveToLeadingTunnelsMap
            .get(STARTING_POINT);
        if (connectingTunnels != null) {
            Optional<Tunnel> nextSuggestedTunnelOptional = connectingTunnels.stream()
                .filter(tunnelFromSuggestions -> !tunnelFromSuggestions.isVisited())
                .min(Comparator.comparing(Tunnel::getDistanceInConsumedAirUnits));
            // Sanitize nextSuggestedTunnelOptional & get value
            nextClosestTunnel = nextSuggestedTunnelOptional.isPresent() ? nextSuggestedTunnelOptional.get() : null;
        }
        return nextClosestTunnel;
    }

    Tunnel getShortestTunnelFromStartingPointWithExclusion(Tunnel tunnelToBeExcluded) {
        Tunnel nextClosestTunnel = null;
        // Get the ones that start with destination of current one
        ArrayList<Tunnel> connectingTunnels = caveToLeadingTunnelsMap
            .get(STARTING_POINT);
        if (connectingTunnels != null) {
            Optional<Tunnel> nextSuggestedTunnelOptional = connectingTunnels.stream()
                .filter(tunnelFromConnectingTunnels -> !tunnelFromConnectingTunnels.equals(tunnelToBeExcluded))
                .filter(tunnelFromSuggestions -> !tunnelFromSuggestions.isVisited())
                .min(Comparator.comparing(Tunnel::getDistanceInConsumedAirUnits));
            // Sanitize nextSuggestedTunnelOptional & get value
            nextClosestTunnel = nextSuggestedTunnelOptional.isPresent() ? nextSuggestedTunnelOptional.get() : null;
        }
        return nextClosestTunnel;
    }

    /**
     * This will help us find very quickly which tunnels connect to the current tunnel and lead us to the next closest
     * cave Later we can select the next closet with idols first if possible
     */
    HashMap<String, ArrayList<Tunnel>> setupCaveToLeadingTunnelsMap() {
        caveToLeadingTunnelsMap = new HashMap<>(numberOfCaves);
        // TODO Collections.sort(tunnels, new TunnelStartingPointComparator());
        for (Tunnel tunnel : tunnels) {
            String cave = valueOf(tunnel.getStartingPointCave());
            if (caveToLeadingTunnelsMap.containsKey(cave)) {
                ArrayList<Tunnel> tunnelsFromCave = caveToLeadingTunnelsMap.get(cave);
                tunnelsFromCave.add(tunnel);
                // TODO Collections.sort(tunnels, new TunnelStartingPointComparator()); check later if matters
                caveToLeadingTunnelsMap.put(cave, tunnelsFromCave);
            } else {
                ArrayList<Tunnel> tunnelsFromCave = new ArrayList<>();
                tunnelsFromCave.add(tunnel);
                caveToLeadingTunnelsMap.put(cave, tunnelsFromCave);
            }
        }
        return caveToLeadingTunnelsMap;
    }

    private Integer getRecoverableIdolsCount(Tunnel closestTunnel) {
        String caveNumber = valueOf(closestTunnel.getDestination());
        return caveToIdolCountMap.containsKey(caveNumber) ? caveToIdolCountMap.get(caveNumber) : 0;
    }

    public void setCaveToIdolCountMap(HashMap<String, Integer> caveToIdolCountMap) {
        this.caveToIdolCountMap = caveToIdolCountMap;
    }

    public ArrayList<Tunnel> getTunnels() {
        return tunnels;
    }

    public void setTunnels(ArrayList<Tunnel> tunnels) {
        this.tunnels = tunnels;
    }
}
