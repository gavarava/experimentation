package com.kattis.treasurehunt;

public class Tunnel implements Comparable<Tunnel> {

    private boolean visited;
    // 0 <= a
    private int startingPointCave;
    // b < n
    private int destinationCave;
    private int distanceInConsumedAirUnits;

    public Tunnel(int startingPointCave, int destinationCave, int distanceInConsumedAirUnits) {
        this.startingPointCave = startingPointCave;
        this.destinationCave = destinationCave;
        this.distanceInConsumedAirUnits = distanceInConsumedAirUnits;
    }

    public int getStartingPointCave() {
        return startingPointCave;
    }

    public int getDestination() {
        return destinationCave;
    }

    public int getDistanceInConsumedAirUnits() {
        return distanceInConsumedAirUnits;
    }

    @Override
    public int compareTo(Tunnel tunnel) {
        return Integer.valueOf(distanceInConsumedAirUnits).compareTo(tunnel.distanceInConsumedAirUnits);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Tunnel)) {
            return false;
        }
        Tunnel tunnel = (Tunnel) object;
        return tunnel.getStartingPointCave() == startingPointCave && tunnel.getDestination() == destinationCave
            && tunnel.getDistanceInConsumedAirUnits() == distanceInConsumedAirUnits;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public int hashCode() {
        return startingPointCave + destinationCave + distanceInConsumedAirUnits;
    }

    @Override
    public String toString() {
        return "Tunnel [startingPointCave = " + startingPointCave + ", destinationCave = " + destinationCave
            + ", distanceInConsumedAirUnits = " + distanceInConsumedAirUnits + ", visited = " + visited + "]";
    }
}
