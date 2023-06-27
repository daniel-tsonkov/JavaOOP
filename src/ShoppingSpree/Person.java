package ShoppingSpree;

import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money, List<Product> products) {
        this.setName(name);
        this.setMoney(money);
        this.products = products;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {

    }
}
