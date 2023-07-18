package Vehicle;

public class Truck extends Vehicle {
    private final static double ADDITIONAL_AC_CONSUMTION = 1.6;
    private final static double REFUEL_PERCANTEG = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        //this.fuelConsumption = this.fuelConsumption + ADDITIONAL_AC_CONSUMTION;
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + ADDITIONAL_AC_CONSUMTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REFUEL_PERCANTEG);
    }
}
