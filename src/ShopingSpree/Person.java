package ShopingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String namme;
    private double money;
    private List<Product> products = new ArrayList<>();

    public Person(String namme, double money) {

    }

    private void setNamme(String namme) {
        this.namme = namme;
    }

    private void setMoney(double money) {
        this.money = money;
    }

    public void buyProduct(Product) {

    }

    public String getName() {
        return namme;
    }
}
