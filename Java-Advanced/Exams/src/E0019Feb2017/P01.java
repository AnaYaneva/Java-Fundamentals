package E0019Feb2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class P01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String[] input = reader.readLine().trim().split("\\s+");

        int n=Integer.valueOf(input[0]);
        int m=Integer.valueOf(input[1]);

        int[][] matrix=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j]=0;
            }
        }

        String line=reader.readLine().trim();
        while(!"Here We Go".equals(line)) {
            String[]coord=line.split("\\s+");
            int r1=Integer.valueOf(coord[0]);
            int c1=Integer.valueOf(coord[1]);
            int r2=Integer.valueOf(coord[2]);
            int c2=Integer.valueOf(coord[3]);


            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    matrix[i][j]+=1;
                }
            }

            line = reader.readLine().trim();
        }

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
