package vehiclesExtension;

public class Bus extends VehicleImpl{
    private static final double FUEL_CONSUMPTION = 1.4;
    private static final boolean DEFAULT_IS_EMPTY = true;
    private boolean isEmpty;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = DEFAULT_IS_EMPTY;
    }

    public void setEmpty(boolean empty) {
        this.isEmpty = empty;
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        if(!this.isEmpty) {
            super.setFuelConsumption(fuelConsumption + FUEL_CONSUMPTION);
        }
    }
}
