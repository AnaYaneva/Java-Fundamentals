package Exercises;

import java.util.Scanner;
import java.util.StringJoiner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[]input=scan.nextLine().split(" ");
        int r=Integer.parseInt(input[0]);
        int c=Integer.parseInt(input[1]);

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        String[][]matrix=new String[r][c];

        for (int row = 0; row <r ; row++) {
            for (int col = 0; col < c; col++) {
                matrix[row][col]=String.format("%s%s%s",alphabet[row],alphabet[row+col],alphabet[row]);
            }
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string+" ");
            }
            System.out.println();
        }



    }
}
