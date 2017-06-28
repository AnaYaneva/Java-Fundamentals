package P07FoodStorage;

public class Rebel implements Humanable, Buyer {
    private String name;
    private int age;
    private String group;


    public Rebel(String name, int age, String group) {
        this.setName( name);
        this.setAge( age);
        this.setGroup( group);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int BuyFood() {
        return 5;
    }
}
