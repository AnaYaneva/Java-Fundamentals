package Exercises;

import java.util.Scanner;

public class FromBaseSevenToDecimal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String number=scan.next();
        System.out.print(Integer.toString(Integer.parseInt(number, 7), 10));

    }
}
