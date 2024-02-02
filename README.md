# Drone Delivery Service

A squad of drones is tasked with delivering packages for a major online reseller in a world
where time and distance do not matter. Each drone can carry a specific weight and can make
multiple deliveries before returning to the home base to pick up additional loads; however, the goal
is to make the fewest number of trips as each time the drone returns to its home base, it is
extremely costly to refuel and reload the drone.

The purpose of the written software is to accept input which will include the name of each
drone and the maximum weight it can carry, along with a series of locations and the total weight
needed to be delivered to that specific location. The software should highlight the most efficient
deliveries for each drone to make on each trip.

Assume that time and distance to each drop-off location do not matter, and that the size of
each package is also irrelevant. It is also assumed that the cost to refuel and restock each
drone is constant and does not vary between drones. The maximum number of drones in a
squad is 100, and there is no maximum number of deliveries which are required.

## Given Input
```
Line 1: [Drone #1 Name], [#1 Maximum Weight], [Drone #2 Name], [#2 Maximum Weight], etc.
Line 2: [Location #1 Name], [Location #1 Package Weight]
Line 3: [Location #2 Name], [Location #2 Package Weight]
Line 4: [Location #3 Name], [Location #3 Package Weight]
Etc.
```

## Expected Output
```
[Drone #1 Name]
Trip #1
[Location #2 Name], [Location #3 Name]
Trip #2
[Location #1 Name]
[Drone #2 Name]
Trip #1
[Location #4 Name], [Location #7 Name]
Trip #2
[Location #5 Name], [Location #6 Name]
```

## Solution

### Walk Through

Considering that time, distance, and size of the package don't matter. The idea of the solution is to take advantage
of the drone that has the highest weight capacity. Because it can deliver more packages with the least number of trips
and the least cost of refuel.

Given, this the basis of the algorithm is as follows:
- Order drones in descending order based on the weight capacity
- Iterate over locations and iterate over drones and assign to the __first drone__ with enough capacity in its current trip
- If a drone does not have enough capacity, discard and consider the following drone
- If any drone has capacity, add a new trip to the first one that has the greatest capacity
- If a trip is filled, a new trip for that drone is created to start adding locations (packages)

### Technical Dependencies and Libraries

For this solution, the following tools were used:

- IntelliJ IDEA 2023.3.2 (Ultimate Edition)
  - Build #IU-233.13135.103, built on December 20, 2023
- openjdk-21 (Oracle OpenJDK version 21)

### Output

***Note***: The output also includes weights for better readability.
