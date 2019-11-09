package com.kattis.treasurehunt;

import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;

public class NearestTunnelFinder {

    private static final String STARTING_POINT_CAVE = "0";
    private HashMap<String, ArrayList<Tunnel>> caveToLeadingTunnelsMap;
    private HashMap<String, Integer> caveToIdolCountMap;
    private ArrayList<Tunnel> tunnels;
    private int numberOfCaves;

    public NearestTunnelFinder(ArrayList<Tunnel> tunnels, HashMap<String, Integer> caveToIdolCountMap,
        int numberOfCaves) {
        this.tunnels = tunnels;
        this.numberOfCaves = numberOfCaves;
        this.caveToIdolCountMap = caveToIdolCountMap;
    }

    public void initialize() {
        setupCaveToLeadingTunnelsMap();
    }

    /**
     * This will give the next recommended tunnel to use
     */
    public Tunnel getClosestUnvisitedDestination(Tunnel currentTunnel) {
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

    public Tunnel getShortestUnvisitedTunnelFromStartingPoint() {
        Tunnel nextClosestTunnel = null;
        // Get the ones that start with destination of current one
        ArrayList<Tunnel> connectingTunnels = caveToLeadingTunnelsMap
            .get(STARTING_POINT_CAVE);
        if (connectingTunnels != null) {
            Optional<Tunnel> nextSuggestedTunnelOptional = connectingTunnels.stream()
                .filter(tunnelFromSuggestions -> !tunnelFromSuggestions.isVisited())
                .min(Comparator.comparing(Tunnel::getDistanceInConsumedAirUnits));
            // Sanitize nextSuggestedTunnelOptional & get value
            nextClosestTunnel = nextSuggestedTunnelOptional.isPresent() ? nextSuggestedTunnelOptional.get() : null;
        }
        return nextClosestTunnel;
    }

    public Tunnel getShortestTunnelFromStartingPointWithExclusion(Tunnel tunnelToBeExcluded) {
        Tunnel nextClosestTunnel = null;
        // Get the ones that start with destination of current one
        ArrayList<Tunnel> connectingTunnels = caveToLeadingTunnelsMap
            .get(STARTING_POINT_CAVE);
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

    public ArrayList<Tunnel> getTunnels() {
        return tunnels;
    }
}
