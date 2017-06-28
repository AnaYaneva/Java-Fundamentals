package Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] input = scan.nextLine().toCharArray();

        ArrayDeque<Character> pal=new ArrayDeque<>();
        boolean isPalindrom=true;

        for (char c : input) {
            pal.offer(c);
        }

        for (int i = 0; i <pal.size()/2 ; i++) {
            if (pal.poll() != pal.pollLast()) {
                isPalindrom = false;
            }
        }
        System.out.println(isPalindrom);


    }
}
