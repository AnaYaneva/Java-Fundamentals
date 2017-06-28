package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n=Integer.valueOf(scan.nextLine());

        ArrayDeque<Long> nums=new ArrayDeque<>();
        ArrayDeque<Long> max=new ArrayDeque<>();
        max.push(Long.MIN_VALUE);
        int command=0 ;
        String[] input =new String[2];

        for (int i = 0; i < n; i++) {
            try {
                input = scan.nextLine().split("\\s+");
                 command = Integer.valueOf(input[0]);
            }
            catch (Exception e){
                command = Integer.valueOf(scan.nextLine());
            }
            switch (command) {
                case 1:
                    long number=Long.valueOf(input[1]);
                    nums.push(number);
                    if (number>max.peek()){

                        max.push(number);
                    }
                    break;
                case 2:
                    if (nums.pop()==max.peek()) {
                        max.pop();
                    }
                    break;
                case 3:
                    System.out.println(max.peek());
                    break;
            }
        }

    }
}
