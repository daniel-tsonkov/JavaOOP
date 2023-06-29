package Vehicle;

public abstract class BaseVehicle implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public BaseVehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {

    }

    public void refuel(double liters); {

    }
}
