package ExercisesSetsAndMaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

//You are given an n number of chemical compounds. You need to keep track of all chemical elements used in the compounds and at the end print all unique ones in ascending order

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n=Integer.valueOf(scan.next());

        TreeSet<String> elements=new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] line=scan.nextLine().split("\\s+");

            for (String s : line) {
                elements.add(s);
            }
        }

        for (String element : elements) {
            System.out.printf("%s ",element);
        }
    }
}
