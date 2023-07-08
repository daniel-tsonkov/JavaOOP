package Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String produceSound() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s\n" + "%s %d %s\n" + "%s", this.getClass().getSimpleName(), this.name, this.age, this.gender, this.produceSound());
    }
}
