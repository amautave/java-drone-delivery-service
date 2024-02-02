package logic;

import model.Drone;
import model.Trip;

public class Common {

    public static Trip getCurrentTripOfDrone(Drone drone) {
        return drone.getTrips().getLast();
    }

    public static boolean doesTripHasCapacity(Trip trip, int weight, int droneMaxWeight) {
        var sumOfWeights = trip.getSumOfWeights();

        return (sumOfWeights + weight) <= droneMaxWeight;
    }

    public static boolean isTripFull(Trip trip, int droneMaxWeight) {
        return trip.getSumOfWeights() >= droneMaxWeight;
    }
}
