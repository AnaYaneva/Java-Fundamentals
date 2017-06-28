package Lab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ReadSortPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int len=Integer.parseInt(scan.nextLine());
        String [] names=new String[len];

        for (int i = 0; i < names.length; i++) {
            names[i]=scan.nextLine();
        }

        Arrays.sort(names);

        for (String name : names) {
            System.out.println(name);
        }


    }
}
