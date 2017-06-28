package Exercises;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input=scan.nextLine().split(" ");
        int rows=Integer.parseInt(input[0]);
        int cols=Integer.parseInt(input[1]);

        String[][] strings=new String[rows][cols];

        fillMatrix(scan, strings);

        String in=scan.nextLine();

        while(!in.equals("END")){
            try {
                String[] command = in.split(" ");

                String swap = command[0];
                if (!swap.equals("swap")||command.length != 5) {
                    System.out.println("Invalid input!");
                }
                else {
                    int x1 = Integer.parseInt(command[1]);
                    int y1 = Integer.parseInt(command[2]);
                    int x2 = Integer.parseInt(command[3]);
                    int y2 = Integer.parseInt(command[4]);


                    String temp = strings[x1][y1];
                    strings[x1][y1] = strings[x2][y2];
                    strings[x2][y2] = temp;

                    printMatrix(strings);
                }
            }
            catch (ArrayIndexOutOfBoundsException ex){
                System.out.println("Invalid input!");

            }

                in = scan.nextLine();
        }

    }

    private static void printMatrix(String[][] strings) {
        for (String[] string : strings) {
            for (String i : string) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scan, String[][] numbers) {
        for (int row = 0; row<numbers.length ; row++) {
            String[]reminder=scan.nextLine().split(" ");
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col]=reminder[col];
            }
        }
    }
}
