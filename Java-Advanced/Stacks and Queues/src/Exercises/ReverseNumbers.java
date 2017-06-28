package Exercises;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        ArrayDeque<Integer> deq=new ArrayDeque<>();
        for (String s : input) {
            deq.push(Integer.valueOf(s));
        }


        while(!deq.isEmpty()) {
            System.out.print(deq.pop()+" ");
        }

    }
}
