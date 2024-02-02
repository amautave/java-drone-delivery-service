package logic;

import comparators.DroneDescendingComparator;
import model.Drone;
import model.Location;
import model.Trip;

import java.util.List;

public class TripsLogic implements TripsCalculator {
    public List<Drone> calculateTrips(List<Drone> drones, List<Location> locations) {

        // Clear all previous trips if exist
        drones.forEach(Drone::clearTrips);

        drones.sort(new DroneDescendingComparator());

        for (Location location : locations) {
            var isLocationAddedToATrip = false;

            for (Drone drone : drones) {
                var currentTrip = Common.getCurrentTripOfDrone(drone);
                if (Common.doesTripHasCapacity(currentTrip, location.getTotalWeight(), drone.getMaxWeight())) {
                    currentTrip.addLocation(location);
                    isLocationAddedToATrip = true;

                    if (Common.isTripFull(currentTrip, drone.getMaxWeight())) {
                        drone.addTrip(new Trip());
                    }

                    break;
                }
            }

            if (!isLocationAddedToATrip) {
                var highestCapacityDrone = drones.getFirst();

                if (location.getTotalWeight() <= highestCapacityDrone.getMaxWeight()) {
                    var newTrip = new Trip();
                    newTrip.addLocation(location);
                    highestCapacityDrone.addTrip(newTrip);

                }
            }
        }

        return drones;
    }

}
