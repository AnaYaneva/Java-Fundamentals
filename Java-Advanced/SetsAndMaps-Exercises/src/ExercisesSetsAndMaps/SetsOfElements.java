package ExercisesSetsAndMaps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/*On the first line you are given the length of two sets n and m. On the next n + m lines there are n numbers that are in the first set and m numbers that are in the second one. Find all non-repeating element that appears in both of them, and print them at the console:
Set with length n = 4: {1, 3, 5, 7}
Set with length m = 3: {3, 4, 5}
Set that contains all repeating elements -> {3, 5}*/

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n=Integer.valueOf(scan.next());
        int m=Integer.valueOf(scan.next());

        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        TreeSet<Integer> set3=new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set1.add(Integer.valueOf(scan.next()));
        }
        for (int i = 0; i < m; i++) {
            set2.add(Integer.valueOf(scan.next()));
        }
        for (Integer num : set2) {
            if (set1.contains(num)){
             set3.add(num);
            }
        }
        for (Integer num : set3) {
            System.out.printf("%d ", num);
        }
    }
}
