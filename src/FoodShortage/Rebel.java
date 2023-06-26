package FoodShortage;


public class Rebel implements Person, Birthable, Identifiable, Buyer {
    /*private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGroup() {
        return this.group;
    }

    public int getFood() {
        return this.food;
    }*/

    @Override
    public String getBirthDate() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    public void buyFood() {

    }

    @Override
    public int getFood() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }
}
