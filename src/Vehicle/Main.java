package Vehicle;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Vehicle car = createVehicle(tokens);

        tokens = scanner.nextLine().split("\\s+");
        Vehicle truck = createVehicle(tokens);

        tokens = scanner.nextLine().split("\\s+");
        Vehicle bus = createVehicle(tokens);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split("\\s+");
            String commandName = tokens[0];
            String vehicleType = tokens[1];

            switch (commandName) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    Vehicle vehicle = vehicles.get(vehicleType);

                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setEmpty(false);
                        ((Bus) vehicle).drive(distance, false);
                    }
                    String driveMessage = vehicle.drive(distance);
                    System.out.println(driveMessage);
                    break;
                case "Refuel":
                    double fuelAmount = Double.parseDouble(tokens[2]);
                    vehicles.get(vehicleType).refuel(fuelAmount);
                    break;
                case "DriveEmpty":
                    double driveEmptyDistance = Double.parseDouble(tokens[2]);
                    String driveEmptyMessage = ((Bus) bus).drive(driveEmptyDistance, true);
                    System.out.println(driveEmptyMessage);
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle createVehicle(String[] token) {
        String vehicleType = token[0];
        double fuelQuantity = Double.parseDouble(token[1]);
        double fuelConsumption = Double.parseDouble(token[2]);
        double tankCapacity = Double.parseDouble(token[3]);
        Vehicle vehicle = null;

        switch (vehicleType) {
            case "Car":
                vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "Bus":
                vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                break;
        }
        return vehicle;
    }
}
