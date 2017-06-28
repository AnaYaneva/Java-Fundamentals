package P05BorderControl;

public class Citizen extends Entities{
    private String name;
    private int age;

    public Citizen(String ID) {
        super(ID);
    }

    public Citizen(String name, int age, String ID) {
        super(ID);
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
