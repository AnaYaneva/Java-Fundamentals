package p06;

import java.util.Comparator;

public class ByAgeComparator implements Comparator<Person> {

    public ByAgeComparator() {
    }

    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}
