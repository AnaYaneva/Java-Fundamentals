package E5023April2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

public class P02Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String[] input = reader.readLine().split(" ");
        int n=Integer.valueOf(input[0]);
        int m=Integer.valueOf(input[1]);

        List<List<Integer>> rows=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> cols=new ArrayList<>();
            for (int j = 0; j < m; j++) {
                cols.add(1+j+m*i);
            }
            rows.add(cols);
        }

        String commands = reader.readLine();

        while (!"Nuke it from orbit".equals(commands)){
            String[] coordinates=commands.split(" ");
            int row=Integer.valueOf(coordinates[0]);
            int col=Integer.valueOf(coordinates[1]);
            int radius=Integer.valueOf(coordinates[2]);

            int targetsUp=Math.max(row-radius,0);
            int targetsLeft=Math.max(col-radius,0);
            int targetsDown=Math.min(row+radius,n-1);
            int targetsRight=Math.min(col+radius,m-1);

            for (int i = targetsUp; i <=targetsDown ; i++) {
                List<Integer> cols=rows.get(i);

                if (i==row) {
                    for (int j = targetsRight; j >= targetsLeft; j--) {
                        cols.remove(j);
                        cols.add(0);
                    }
                }else {
                    if (col >= 0 && col < m) {
                        cols.remove(col);
                        cols.add(0);
                    }
                }
            }

            commands = reader.readLine();
        }


        for (List<Integer> cols : rows) {
            for (int j = cols.size()-1; j >=0; j--) {
                if (cols.get(j)==0){
                    cols.remove(cols.get(j));
                }
            }
        }
        for (int i = rows.size()-1; i >= 0; i--) {
            List<Integer> cols=rows.get(i);
            if (cols.isEmpty()){
                rows.remove(i);
            }
        }


        for (List<Integer> cols : rows) {
            for (Integer col : cols) {
               System.out.print(col+ " ");
            }
            System.out.println();
        }

    }
}
