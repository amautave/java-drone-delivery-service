package model;

public class Location {
    private final String name;
    private final int totalWeight;

    public Location(String name, int totalWeight) {
        this.name = name;
        this.totalWeight = totalWeight;
    }

    public String getName() {
        return name;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "[" + this.name + " - " + this.totalWeight + "]";
    }
}
