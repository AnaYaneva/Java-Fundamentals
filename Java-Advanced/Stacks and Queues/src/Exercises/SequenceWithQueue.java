package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SequenceWithQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //String[] input = scan.nextLine().split(" ");
        long n=Integer.valueOf(scan.nextLine());

        ArrayDeque<Long> nums=new ArrayDeque<>();

        for (int i = 0; i < 50; i++) {
            System.out.print(n + " ");
            nums.add(n+1);
            nums.add(2*n+1);
            nums.add(n+2);
            n=nums.poll();
        }

    }
}
