package Lab;

import java.util.ArrayList;
import java.util.Scanner;

public class GroupNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input=scan.nextLine().split(", ");
        ArrayList<ArrayList<Integer>> jagged=new ArrayList<>();

        jagged.add(0,new ArrayList<>());
        jagged.add(1,new ArrayList<>());
        jagged.add(2,new ArrayList<>());

        for (String s : input) {
            int currentNum=Integer.parseInt(s);
            jagged.get(Math.abs(currentNum%3)).add(currentNum);
        }

        for (ArrayList<Integer> integers : jagged) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }


    }
}
