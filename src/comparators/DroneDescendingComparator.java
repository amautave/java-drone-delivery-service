package comparators;

import model.Drone;

import java.util.Comparator;

public class DroneDescendingComparator implements Comparator<Drone> {
    @Override
    public int compare(Drone o1, Drone o2) {
        return o2.getMaxWeight() - o1.getMaxWeight();
    }
}
