package p05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        List<Person> people=new ArrayList<>();

        while(true) {
            String[] tokens = reader.readLine().trim().split("\\s+");

            if ("END".equalsIgnoreCase(tokens[0]))break;

            Person p=new Person(tokens[0],Integer.valueOf(tokens[1]),tokens[2]);
            people.add(p);
        }

        int num=Integer.valueOf(reader.readLine());
        Person compareWith=people.get(num-1);


        int same=0;

        for (Person person : people) {
            if (compareWith.compareTo(person)==0){
                same++;
            }
        }

        if (same==1){
            System.out.println("No matches");
        }else{
            System.out.println(String.format("%d %d %d",
                    same, people.size()-same,people.size()));
        }
    }
}
