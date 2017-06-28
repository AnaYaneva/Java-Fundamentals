package Exercises;

import java.util.Scanner;

public class SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] rc=scan.nextLine().split(" ");
        int rows=Integer.parseInt(rc[0]);
        int cols=Integer.parseInt(rc[1]);

        String[][] numbers=new String[rows][cols];

        for (int row = 0; row<numbers.length ; row++) {
            String[]reminder=scan.nextLine().split(" ");
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col]=reminder[col];
            }
        }

        int counter=0;

        for (int row = 0; row<numbers.length-1 ; row++) {
            for (int col = 0; col < numbers[row].length-1; col++) {
                if (numbers[row][col].equals(numbers[row+1][col])&&
                        numbers[row][col].equals(numbers[row][col+1])&&
                        numbers[row+1][col].equals(numbers[row+1][col+1])){
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
