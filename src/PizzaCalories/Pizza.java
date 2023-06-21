package PizzaCalories;

import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, List<Topping> toppings) {

    }

    private void setName(String name) {
        if (name.length() >= 1 && name.length() <= 15) {
            this.name = name;
        } else {
            throw  new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int count) {
        if (count >= 0 && count <= 10) {
            this.toppings = toppings;
        } else {
            throw  new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {

    }

    public double fetOverallCallories() {

    }
}
