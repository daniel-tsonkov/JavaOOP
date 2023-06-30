package Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] token = scanner.next().split("\\s+");
        double carFuelQuantity = Double.parseDouble(token[1]);
        double carFuelConsumption = Double.parseDouble(token[2]);

        Vehicle car = new Car(carFuelQuantity, carFuelConsumption);

        token = scanner.next().split("\\s+");
        Vehicle.Vehicle truck = createVehicle(token);

        Map<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            token = scanner.nextLine().split("\\s+");
            String commandName = token[0];
            String vehicleType = token[1];

            switch (commandName) {
                case "Drive":
                    double distance = Double.parseDouble(token[2]);
                    String driveMessage = vehicles.get(vehicleType).drive(distance);
                    System.out.println(driveMessage);
                    break;
                case "Refuel":
                    double fuelAmount = Double.parseDouble(token[2]);
                    if (vehicleType.equals("Car")) {
                        car.refuel(fuelAmount);
                    } else {
                        truck.refuel(fuelAmount);
                    }
                    break;
            }
        }
    }

    private static Vehicle createVehicle(String[] token) {
        String vehicleType = token[0];
        double fuelQuantity = Double.parseDouble(token[1]);
        double fuelConsumption = Double.parseDouble(token[2]);
        Vehicle vehicle = null;

        switch (vehicleType) {
            case "Car":
                vehicle = new Car(fuelQuantity, fuelConsumption);
            break;
            case "Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption);
            break;
        }
        return vehicle;
    }
}
