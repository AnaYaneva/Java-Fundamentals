package Lab;

import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] rc=scan.nextLine().split(", ");
        int rows=Integer.parseInt(rc[0]);
        int cols=Integer.parseInt(rc[1]);

        int[][] numbers=new int[rows][cols];

        int maxSum=Integer.MIN_VALUE;
        int startRow=0;
        int startCol=0;

        for (int row = 0; row<numbers.length ; row++) {
            String[]reminder=scan.nextLine().split(", ");
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col]=Integer.parseInt(reminder[col]);
            }
        }

        for (int row = 0; row<numbers.length-1 ; row++) {
            for (int col = 0; col < numbers[row].length-1; col++) {
                int currentSum=numbers[row][col]+
                               numbers[row][col+1]+
                               numbers[row+1][col]+
                               numbers[row+1][col+1];

                if (currentSum>maxSum){
                    maxSum=currentSum;
                    startRow=row;
                    startCol=col;
                }
            }
        }

        System.out.println(numbers[startRow][startCol]+" "+numbers[startRow][startCol+1]);
        System.out.println(numbers[startRow+1][startCol]+" "+numbers[startRow+1][startCol+1]);
        System.out.println(maxSum);
    }
}
