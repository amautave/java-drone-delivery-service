package io;

import model.Drone;
import model.Location;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    public static InputFileContent readInputFile(String filePath) throws IOException {
        String content = "";
        List<Drone> drones = new ArrayList<>();
        List<Location> locations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder fileContent = new StringBuilder();
            var firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    drones = readDrones(line);
                    firstLine = false;
                } else {
                    locations.add(readLocation(line));
                }
                fileContent.append(line).append("\n");
            }
            content = fileContent.toString();
        }

        return new InputFileContent(content, drones, locations);
    }

    private static List<Drone> readDrones(String line) {
        List<Drone> drones = new ArrayList<>();

        String[] droneData = line.split(", ");
        for (int i = 0; i < droneData.length; i += 2) {
            String droneName = droneData[i].replaceAll("[\\[\\]]", "");
            int droneCapacity = Integer.parseInt(droneData[i + 1].replaceAll("[\\[\\]]", ""));
            drones.add(new Drone(i, droneName, droneCapacity));
        }

        return drones;
    }


    private static Location readLocation(String line) {
        String[] locationData = line.split(", ");
        String locationName = locationData[0].replaceAll("[\\[\\]]", "");
        int totalWeight = Integer.parseInt(locationData[1].replaceAll("[\\[\\]]", ""));

        return new Location(locationName, totalWeight);
    }
}

