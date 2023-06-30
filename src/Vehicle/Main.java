package Vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] token = scanner.next().split("\\s+");
        double carFuelQuantity = Double.parseDouble(token[1]);
        double carFuelConsumption = Double.parseDouble(token[2]);

        Car car = new Car(carFuelQuantity, carFuelConsumption);

        token = scanner.next().split("\\s+");
        double truckFuelQuantity = Double.parseDouble(token[1]);
        double truckFuelConsumption = Double.parseDouble(token[2]);

        Truck truck = new Truck(truckFuelQuantity, truckFuelConsumption);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            token[] =scanner.nextLine().split("\\s+");
            String commandName = token[0];
            String vehicleType = token[1];

            switch (commandName) {
                case "Drive":
                    double distance = Double.parseDouble(token[2]);
                    if (vehicleType.equals("Car")) {
                        System.out.println(car.drive(distance));
                    } else {
                        System.out.println(truck.drive(distance));
                    }
                    break;
                case "Refuel":
                    break;
            }
        }
    }
}
