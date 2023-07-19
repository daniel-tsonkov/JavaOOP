package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;


    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (this.capacity < this.data.size()) {
            this.data.add(car);
            this.capacity--;
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }
}
