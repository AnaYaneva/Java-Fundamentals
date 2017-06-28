package p06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.valueOf(reader.readLine());

        TreeSet<Person> byName=new TreeSet<>(new ByNamesLengthComparator());
        TreeSet<Person> byAge=new TreeSet<>(new ByAgeComparator());

        while(n-->0){
            String[] tokens=reader.readLine().trim().split("\\s+");
            String name=tokens[0];
            int age=Integer.valueOf(tokens[1]);

            Person r=new Person(name, age);
            byAge.add(r);
            byName.add(r);
        }

        for (Person person : byName) {
            System.out.println(person);
        }
        for (Person person : byAge) {
            System.out.println(person);
        }
    }

}
