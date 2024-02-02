package logic;

import model.Drone;
import model.Location;

import java.util.List;

public interface TripsCalculator {
    List<Drone> calculateTrips(List<Drone> drones, List<Location> locations);
}
