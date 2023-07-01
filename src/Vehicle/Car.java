package Vehicle;

public class Car extends Vehicle {
    private final static double ADDITIONAL_AC_CONSUMTION = 0.9;
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        //this.fuelConsumption = this.fuelConsumption + ADDITIONAL_AC_CONSUMTION;
        //super(fuelQuantity, fuelConsumption + ADDITIONAL_AC_CONSUMTION);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + ADDITIONAL_AC_CONSUMTION);
    }
}
