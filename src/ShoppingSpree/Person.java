package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public void buyProduct(Product product) {
        /*if (product.getCost() > this.money) {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        }*/
        if (this.money >= product.getCost()) {
            System.out.printf("%s bought %s%n", this.name, product.getName());
            this.products.add(product);
            this.money -= product.getCost();
        } else {
            String message = this.name + " can't afford " + product.getName();
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return name;
    }
}
