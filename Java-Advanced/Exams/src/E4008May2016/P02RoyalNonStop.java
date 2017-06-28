package E4008May2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
//import java.util.Scanner;

public class P02RoyalNonStop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String[] dimensions = reader.readLine().split(" ");
        int n=Integer.valueOf(dimensions[0]);
        int m=Integer.valueOf(dimensions[1]);

        String[] prices = reader.readLine().split(" ");
        BigDecimal  prL=new BigDecimal(prices[0]);
        BigDecimal prR=new BigDecimal(prices[1]);

        BigDecimal [][] shop=new BigDecimal[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i%2==0) {
                    BigDecimal cell=new BigDecimal((double)((i+1)*(j+1)));
                    shop[i][j] =prL.multiply(cell);
                }else{
                    BigDecimal cell=new BigDecimal((double)((i+1)*(j+1)));
                    shop[i][j] =prR.multiply(cell);
                }
            }
        }
        BigDecimal nulla=new BigDecimal("0");
        shop[0][0]=nulla;

        //for (int i = 0; i < n; i++) {
        //    for (int j = 0; j <m ; j++) {
        //        System.out.print(shop[i][j]+" ");
        //    }
        //    System.out.println();
        //}

        int counter=0;
        BigDecimal sum=new BigDecimal("0");

       String coord = reader.readLine();

       while (!"Royal Close".equals(coord)) {
           String[] coordinates = coord.split(" ");
           int row = Integer.valueOf(coordinates[0]);
           int col = Integer.valueOf(coordinates[1]);
            counter++;

           boolean upLeft = row < col;

           if (upLeft){
               for (int i = row; i >=1 ; i--) {
                   sum=sum.add(shop[i][col]);
               }
               for (int i = col; i >=0; i--) {
                   sum=sum.add(shop[0][i]);
               }
           }else{
               for (int i = col; i >=1; i--) {
                   sum=sum.add(shop[row][i]);
               }
               for (int i = row; i >=0 ; i--) {
                   sum=sum.add(shop[i][0]);
               }
           }
           coord = reader.readLine();
       }

        System.out.printf("%.6f",sum);
        System.out.println();
        System.out.println(counter);
    }
}
