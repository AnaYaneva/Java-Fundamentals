package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReversingStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] input = scan.nextLine().toCharArray();

        ArrayDeque<Character> rev=new ArrayDeque<>();

        for (char c : input) {
            rev.push(c);
        }

        while (!rev.isEmpty()){
            System.out.print(rev.pop());
        }

    }
}
