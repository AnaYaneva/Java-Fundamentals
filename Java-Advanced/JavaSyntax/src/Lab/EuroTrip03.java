package Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class EuroTrip03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double quantity=scan.nextDouble();
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceInBGN = new BigDecimal(quantity*1.20);

        BigDecimal marksNeeded = exchangeRate.multiply(priceInBGN);

        System.out.printf("%.2f marks", marksNeeded);
    }
}