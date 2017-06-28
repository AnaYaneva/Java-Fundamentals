import java.util.Scanner;

public class Library {

    private static void printMatrix(int[][] numbers) {
        for (int[] number : numbers) {
            for (int i : number) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scan, int[][] numbers) {
        for (int row = 0; row < numbers.length; row++) {
            String[] reminder = scan.nextLine().split(" ");
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col] = Integer.parseInt(reminder[col]);
            }
        }
    }

    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

}
