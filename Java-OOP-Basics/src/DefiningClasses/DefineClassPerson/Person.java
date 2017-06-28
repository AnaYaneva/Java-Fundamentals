package DefineClassPerson;

public class Person {
    private static final int DEFAULT_AGE=-1;
    private static final String DEFAULT_NAME="No name";

    public String name;
    public int age;

    public Person() {
        this.age = DEFAULT_AGE;
        this.name = DEFAULT_NAME;
    }

    public Person(String name) {
        this.age = DEFAULT_AGE;
        this.name = name;
    }
    public Person(int age) {
        this.age = age;
        this.name = DEFAULT_NAME;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
