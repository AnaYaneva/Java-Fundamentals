package Exercises;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n=Integer.parseInt(scan.nextLine());

        int[][] numbers=new int[n][n];

        int sumPrimary=0;
        int sumSecondary=0;

        for (int row = 0; row<n ; row++) {
            String[]reminder=scan.nextLine().split(" ");
            for (int col = 0; col < n; col++) {
                numbers[row][col]=Integer.parseInt(reminder[col]);
            }
        }
        for (int row = 0; row<n ; row++) {
            for (int col = 0; col < n; col++) {
                if (row==col) {
                    sumPrimary += numbers[row][col];
                }
                if (col==n-1-row){
                    sumSecondary += numbers[row][col];
                }
            }
        }

int difference=Math.abs(sumPrimary-sumSecondary);
        System.out.println(difference);

    }
}
