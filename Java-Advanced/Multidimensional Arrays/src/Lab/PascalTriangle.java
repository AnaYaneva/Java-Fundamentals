package Lab;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows=Integer.parseInt(scan.nextLine());
        long[][]pascal=new long[rows][];

        for (int row = 0; row <rows ; row++) {
            pascal[row]=new long[row+1];

            pascal[row][0]=1;
            pascal[row][row]=1;

            for (int col =1; col <row ; col++) {
                pascal[row][col]=pascal[row-1][col-1]+pascal[row-1][col];
            }
        }

        for (long[] ints : pascal) {
            for (long anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }

    }
}
