package io;

import model.Drone;
import model.Location;

import java.util.List;

public class InputFileContent {
    String content;
    List<Drone> drones;
    List<Location> locations;

    public InputFileContent(String content, List<Drone> drones, List<Location> locations) {
        this.content = content;
        this.drones = drones;
        this.locations = locations;
    }

    public String getContent() {
        return content;
    }

    public List<Drone> getDrones() {
        return drones;
    }

    public List<Location> getLocations() {
        return locations;
    }
}
