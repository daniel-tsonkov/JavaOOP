package vehiclesExtension;

public class Truck extends VehicleImpl {
    private final double MORE_FUEL = 1.6;
    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setFuelConsumption(fuelConsumption + MORE_FUEL);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
