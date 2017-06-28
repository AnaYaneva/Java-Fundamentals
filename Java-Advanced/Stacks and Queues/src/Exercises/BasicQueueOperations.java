package Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int n=Integer.valueOf(input[0]);
        int s=Integer.valueOf(input[1]);
        long x=Long.valueOf(input[2]);

        String[] ints = scan.nextLine().split(" ");

        Deque<Long> stack=new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.add(Long.valueOf(ints[i]));
        }

        for (int i = 0; i < s; i++) {
            stack.poll();
        }

        if (stack.isEmpty()){
            System.out.println(0);
        }

        else {
            if (stack.contains(x)) {
                System.out.println(true);
            } else {
                Long min=stack.poll();

                while(!stack.isEmpty()) {
                    if (min > stack.peek()) {
                        min = stack.peek();
                    }
                    stack.poll();
                }
                System.out.println(min);
            }
        }

    }
}
