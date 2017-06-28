package Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch=input.charAt(i);
            if (ch=='('){
                stack.push(i);
            }
            else if (ch==')'){
                int startIdex=stack.pop();
                String contents=input.substring(startIdex,i+1);
                System.out.println(contents);
            }
        }




    }
}
