package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trip {
    private final List<Location> locations;

    public Trip() {
        this.locations = new ArrayList<>();
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void addLocation(Location location) {
        this.locations.add(location);
    }

    public int getSumOfWeights() {
        return this.locations
                .stream()
                .map(Location::getTotalWeight)
                .reduce(0, Integer::sum);
    }

    public String toString() {
        return this.locations
                .stream()
                .map(Location::toString)
                .collect(Collectors.joining(", "));
    }
}
