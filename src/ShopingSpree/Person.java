package ShopingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products = new ArrayList<>();

    public Person(String namme, double money) {
        setNamme(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setNamme(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if (money > 0) {
            this.money = money;
        } else {
            System.out.println("Money cannot be negative");
        }
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.products.add(product);
            this.money -= product.getCost();
        } else {
            String message = getName() + " can't afford " + product.getName();
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return name;
    }
}
