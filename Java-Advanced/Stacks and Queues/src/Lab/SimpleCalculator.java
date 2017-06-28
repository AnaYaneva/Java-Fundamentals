package Lab;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        ArrayDeque<String> deq=new ArrayDeque<>();

        Collections.addAll(deq,input);

        while (deq.size()>1) {
            int num2 = Integer.valueOf(deq.pop());
            String sign=deq.pop();
            int num1 = Integer.valueOf(deq.pop());

            if (sign.equals("+")){
                deq.push(String.valueOf(num1+num2));
            }
            else if(sign.equals("-")){
                deq.push(String.valueOf(num1-num2));
            }
        }
        System.out.println(deq.peek());

    }
}
