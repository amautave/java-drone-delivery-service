package comparators;

import model.Drone;

import java.util.Comparator;

public class DroneIndexComparator implements Comparator<Drone> {
    @Override
    public int compare(Drone o1, Drone o2) {
        return o1.getIndex() - o2.getIndex();
    }
}
