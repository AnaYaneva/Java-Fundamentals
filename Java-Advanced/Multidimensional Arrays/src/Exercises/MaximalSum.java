package Exercises;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] rc=scan.nextLine().split(" ");
        int rows=Integer.parseInt(rc[0]);
        int cols=Integer.parseInt(rc[1]);

        int[][] numbers=new int[rows][cols];

        int maxSum=Integer.MIN_VALUE;

        int startRow=0;
        int startCol=0;

        for (int row = 0; row<numbers.length ; row++) {
            String[]reminder=scan.nextLine().split(" ");
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col]=Integer.parseInt(reminder[col]);
            }
        }

        for (int row = 0; row<numbers.length-2 ; row++) {
            for (int col = 0; col < numbers[row].length - 2; col++) {
                int currentSum=0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        currentSum += numbers[row + i][col + j];

                        if (currentSum > maxSum) {
                            maxSum = currentSum;
                            startRow = row;
                            startCol = col;
                        }
                    }
                }
            }
        }
        System.out.println("Sum = "+maxSum);
        System.out.println(numbers[startRow][startCol]+" "+numbers[startRow][startCol+1]+" "+numbers[startRow][startCol+2]);
        System.out.println(numbers[startRow+1][startCol]+" "+numbers[startRow+1][startCol+1]+" "+numbers[startRow+1][startCol+2]);
        System.out.println(numbers[startRow+2][startCol]+" "+numbers[startRow+2][startCol+1]+" "+numbers[startRow+2][startCol+2]);
    }
}
