package comparators;

import model.Location;

import java.util.Comparator;

public class LocationAscendingComparator implements Comparator<Location> {
    @Override
    public int compare(Location o1, Location o2) {
        return o1.getTotalWeight() - o2.getTotalWeight();
    }
}
