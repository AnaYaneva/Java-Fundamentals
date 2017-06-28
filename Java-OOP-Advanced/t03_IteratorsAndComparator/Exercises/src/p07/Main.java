package p07;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.valueOf(reader.readLine());

        TreeSet<Person> tree=new TreeSet<>();
        HashSet<Person> hash=new HashSet<>();

        while(n-->0){
            String[] tokens=reader.readLine().trim().split("\\s+");
            String name=tokens[0];
            int age=Integer.valueOf(tokens[1]);

            Person r=new Person(name, age);
            tree.add(r);
            hash.add(r);
        }

        System.out.println(tree.size());
        System.out.println(hash.size());
    }

}
