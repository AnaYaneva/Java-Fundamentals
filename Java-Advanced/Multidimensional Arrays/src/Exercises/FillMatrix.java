package Exercises;

import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[]input=scan.nextLine().split(", ");
        int n=Integer.parseInt(input[0]);
        String pattern=input[1];

        int[][] matrix=new int[n][n];

        if (pattern.equals("A")) {
            fillMatrixA(n, matrix);
        }

        else if(pattern.equals("B")) {
            fillMatrixB(n, matrix);
        }

        for (int[] ints : matrix) {
            for (int ints1 : ints) {
                System.out.print(ints1+" ");
            }
            System.out.println();
        }



    }

    private static void fillMatrixB(int n, int[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (col%2==0) {
                    matrix[row][col] = row + col * n + 1;
                }
                else{
                    matrix[row][col] =- row +n+col * n ;
                }
            }
        }
    }

    private static void fillMatrixA(int n, int[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col]=row+col*n+1;
            }
        }
    }
}
