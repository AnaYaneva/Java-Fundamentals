package P06BirthdayCelebrations;

public abstract class Alive implements Birthdayable{
    private String name;
    private String Bday;

    public Alive(String name,String bday) {
        this.setName(name);
        this.setBday(bday);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBday() {
        return this.Bday;
    }

    public void setBday(String bday) {
        this.Bday = bday;
    }

    @Override
    public String toString() {
        return this.getBday();
    }
}
