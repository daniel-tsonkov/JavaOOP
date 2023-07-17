package vehiclesExtension;

public class Car extends VehicleImpl {
    private final double MORE_FUEL = 0.9;
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        super.setFuelConsumption(fuelConsumption + this.MORE_FUEL);
    }
}
