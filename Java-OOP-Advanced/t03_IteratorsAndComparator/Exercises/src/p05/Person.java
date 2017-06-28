package p05;

public class Person implements Comparable<Person>{

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    @Override
    public int compareTo(Person p) {
        if (this.getName().compareTo(p.getName()) == 0) {
            if (this.getAge() == p.getAge()) {
                return this.getTown().compareTo(p.getTown());
            } else {
                return Integer.compare(this.getAge(), p.getAge());
            }
        } else {
            return this.getName().compareTo(p.getName());
        }
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private String getTown() {
        return this.town;
    }

    private void setTown(String town) {
        this.town = town;
    }
}
