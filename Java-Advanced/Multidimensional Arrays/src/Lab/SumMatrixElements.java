package Lab;

import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] rc=scan.nextLine().split(", ");
        int rows=Integer.parseInt(rc[0]);
        int cols=Integer.parseInt(rc[1]);

        int[][] numbers=new int[rows][cols];

        int sum=0;

        for (int row = 0; row<numbers.length ; row++) {
            String[]reminder=scan.nextLine().split(", ");
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col]=Integer.parseInt(reminder[col]);
                sum+=numbers[row][col];
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
