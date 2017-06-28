package E1022August2016;//80/100

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
//import java.util.Scanner;

public class P02NaturesProphet {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] dimensions = input.split("\\s+");

        int n = Integer.valueOf(dimensions[0]);
        int m = Integer.valueOf(dimensions[1]);

        int[][] field = new int[n][m];
        int[][] flowers = new int[n][m];

        String[] commands = scan.nextLine().split("\\s+");

        while (!"Bloom".equals(commands[0])) {

            int row = Integer.valueOf(commands[0]);
            int col = Integer.valueOf(commands[1]);

            field[row][col] = 1;
            flowers[row][col] = 1;
            commands = scan.nextLine().split("\\s+");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (flowers[i][j] == 1) {
                    for (int k = 0; k < m; k++) {
                        field[i][k] += 1;
                    }
                    for (int k = 0; k < n; k++) {
                        field[k][j] += 1;
                    }

                    field[i][j] -=2;
                }
            }
        }

       /* for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (flowers[i][j] == 1) {
                    field[i][j] = 1;
                }
            }
        }*/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d ", field[i][j]);
            }
            System.out.println();
        }


    }
}
