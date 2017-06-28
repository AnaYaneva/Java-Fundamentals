package Exercises;

import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double base=scan.nextDouble();
        double height=scan.nextDouble();

        double area=base*height;

        System.out.printf("%.2f%n",area);


    }
}
