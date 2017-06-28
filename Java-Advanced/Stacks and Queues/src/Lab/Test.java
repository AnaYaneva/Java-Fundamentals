package Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);

        //String[] input = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> deq=new ArrayDeque<>();

        for (int i = 10; i < 15; i++) {
            deq.add(i);

        }
        System.out.println(deq);
        System.out.println(deq.peek());
        System.out.println(deq.poll());
        System.out.println(deq.pollLast());
        System.out.println(deq.peek());
        System.out.println(deq);
        for (int i = 14; i < 17; i++) {
            deq.offer(i);

        }
        System.out.println(deq);

        for (int i = 1; i < 10; i++) {
            deq.push(i);

        }

        System.out.println(deq);
        System.out.println(deq.pop());
        System.out.println(deq);
        System.out.println(deq.peek());
        System.out.println(deq);
    }
}
