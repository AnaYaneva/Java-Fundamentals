package Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        int n=Integer.valueOf(input[0]);
        int s=Integer.valueOf(input[1]);
        long x=Long.valueOf(input[2]);

        String[] ints = scan.nextLine().split(" ");

        Deque<Long> stack=new ArrayDeque<>();

        for (int i = 0; i < n-s; i++) {
            stack.push(Long.valueOf(ints[i]));
        }

        //for (int i = 0; i < s; i++) {
       //     stack.pop();
        //}

        if (stack.isEmpty()){
            System.out.println(0);
        }
        else {
            if (stack.contains(x)) {
                System.out.println(true);
            } else {
                Long min=stack.pop();

                while(stack.isEmpty()) {
                    if (min > stack.peek()) {
                        min = stack.peek();
                    }
                        stack.pop();
                }
                System.out.println(min);
            }
        }


    }
}
