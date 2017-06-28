package Lab;

import java.util.Scanner;

public class CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double base=scan.nextDouble();
        double height=scan.nextDouble();

        double area=base*height/2;

        System.out.printf("Area = %.2f%n",area);


    }
}
