package Vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car = new Car(10, 1);
        Truck truck = new Truck(10, 1);

        System.out.println(car.drive(5));
        System.out.println(car.drive(50));
    }
}
