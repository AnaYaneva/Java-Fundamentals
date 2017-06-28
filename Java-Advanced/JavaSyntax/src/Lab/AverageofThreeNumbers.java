package Lab;

import java.util.Scanner;

public class AverageofThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double first=scan.nextDouble();
        double second=scan.nextDouble();
        double third=scan.nextDouble();

        double average=(first+second+third)/3;

        System.out.format("%.2f%n", average);
    }
}
