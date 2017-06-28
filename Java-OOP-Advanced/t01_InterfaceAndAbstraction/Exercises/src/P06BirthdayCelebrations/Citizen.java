package P06BirthdayCelebrations;

public class Citizen extends Alive implements Checkable{
    private int age;
    private String ID;

    public Citizen(String name, int age, String ID, String bDay) {
        super(name,bDay);
        this.setAge(age);
        this.setID(ID);
    }


    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

}
