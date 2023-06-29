package Vehicle;

import java.text.DecimalFormat;

public class BaseVehicle implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public BaseVehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;

        if (fuelNeeded > this.fuelQuantity) {
            return String.format("%s needs refueling", getClass().getSimpleName());
        }

        this.fuelQuantity -= fuelNeeded;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s traveled %s km", getClass().getSimpleName(), decimalFormat.format(distance));

    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
