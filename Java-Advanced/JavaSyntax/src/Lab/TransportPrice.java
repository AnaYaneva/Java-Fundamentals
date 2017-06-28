package Lab;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int distance=scan.nextInt();
        String dayTime=scan.next();

        double price=0;

        if (distance<20){
            switch (dayTime){
                case "day":
                    price = 0.7 + 0.79 * distance;
                    break;
                case "night":
                    price = 0.7 + 0.9 * distance;
                    break;
            }
        }
        else if (distance>=20&&distance<100){
            price = 0.09 * distance;
        }
        else {
            price = 0.06 * distance;
        }

        System.out.format("%.2f%n",price);
    }
}
