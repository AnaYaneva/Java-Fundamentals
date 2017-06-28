package Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class ProductofNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n=scan.nextInt();
        int m=scan.nextInt();
        BigInteger prod=new BigInteger("1");

        for (int i=n;i<=m;i++){
            BigInteger ii=new BigInteger(String.valueOf(i));
           prod=prod.multiply(ii);
        }

        System.out.printf("product[%d..%d] = %d",n,m,prod);

    }
}
