package logic;

import comparators.DroneIndexComparator;
import model.Drone;
import model.Location;

import java.util.List;
import java.util.stream.Collectors;

public class Formatter {
    public static String formatTripsFromDrones(List<Drone> drones) {
        drones.sort(new DroneIndexComparator());
        return drones.stream()
                .map(drone -> drone + "\n" + drone.getTrips().stream()
                        .filter(trip -> !trip.getLocations().isEmpty())
                        .map(trip -> "Trip #" + (drone.getTrips().indexOf(trip) + 1) + "\n" +
                                trip.getLocations()
                                        .stream()
                                        .map(Location::toString)
                                        .collect(Collectors.joining(" , "))

                        )
                        .collect(Collectors.joining("\n"))
                )
                .collect(Collectors.joining("\n\n"));
    }
}
