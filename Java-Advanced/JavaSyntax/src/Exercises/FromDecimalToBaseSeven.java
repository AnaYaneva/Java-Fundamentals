package Exercises;

import java.util.Scanner;

public class FromDecimalToBaseSeven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstN = scan.nextInt();
        String seven = Integer.toString(firstN, 7);

        System.out.print(seven);

    }
}
