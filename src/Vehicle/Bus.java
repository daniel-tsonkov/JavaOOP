package Vehicle;

public class Bus extends Vehicle {
    private boolean isEmpty;
    public final static double ADDITIONAL_FULL_BUS_CONSUMTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = true;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public String drive(double distance, boolean empty) {
        this.setEmpty(empty);
        return super.drive(distance);
    }

    public void setEmpty(boolean empty) {

        if (!isEmpty && empty) {
            this.fuelConsumption = this.fuelConsumption - ADDITIONAL_FULL_BUS_CONSUMTION;
        }

        if (isEmpty && !empty) {
            this.fuelConsumption = this.fuelConsumption + ADDITIONAL_FULL_BUS_CONSUMTION;
        }
        //this.isEmpty = empty;
    }
}
