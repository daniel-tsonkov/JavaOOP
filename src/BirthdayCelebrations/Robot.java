package BirthdayCelebrations;

import MultipleImplementation.Identifiable;

public class Robot implements Identifiable {
    private final String id;
    private final String model;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }
}
