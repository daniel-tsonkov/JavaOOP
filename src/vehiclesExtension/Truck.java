package vehiclesExtension;

public class Truck extends VehicleImpl {
    private final double MORE_FUEL = 1.6;
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        super.setFuelConsumption(fuelConsumption + MORE_FUEL);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
