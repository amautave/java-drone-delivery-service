package model;

import java.util.ArrayList;
import java.util.List;

public class Drone {
    private final int index;
    private final String name;
    private final int maxWeight;
    private final List<Trip> trips;

    public Drone(int index, String name, int maxWeight) {
        this.index = index;
        this.name = name;
        this.maxWeight = maxWeight;
        this.trips = new ArrayList<>();
        this.trips.add(new Trip());
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public List<Trip> getTrips() {
        return this.trips;
    }

    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }

    public void clearTrips() {
        this.trips.clear();
        this.trips.add(new Trip());
    }

    @Override
    public String toString() {
        return "[" + this.name + " - " + this.maxWeight + "]";
    }
}
