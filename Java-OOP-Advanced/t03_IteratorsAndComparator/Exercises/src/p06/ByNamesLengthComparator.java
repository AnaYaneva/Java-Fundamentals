package p06;

import java.util.Comparator;

public class ByNamesLengthComparator implements Comparator<Person> {

    public ByNamesLengthComparator() {
    }

    @Override
    public int compare(Person p1, Person p2) {
        if (Integer.compare(p1.getName().length(),p2.getName().length())==0){
            return Character.compare(p1.getName().toLowerCase().charAt(0),
                    p2.getName().toLowerCase().charAt(0));
        }else{
            return Integer.compare(p1.getName().length(),p2.getName().length());
        }
    }
}
