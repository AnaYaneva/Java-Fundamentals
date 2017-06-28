package p07;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode()*this.getAge();
    }

    @Override
    public boolean equals(Object obj) {
       if (obj==null)return false;
        if (!(obj instanceof Person))return false;

        Person person= (Person) obj;

        return this.getName().equals(person.getName())&&
                this.getAge()==person.getAge();
    }

    @Override
    public String toString() {
        return name + ' '+ age;
    }


    @Override
    public int compareTo(Person o) {
        if (this.getName().equals(o.getName())){
            return Integer.compare(this.getAge(),o.getAge());
        }else{
            return this.getName().compareTo(o.getName());
        }
    }
}
