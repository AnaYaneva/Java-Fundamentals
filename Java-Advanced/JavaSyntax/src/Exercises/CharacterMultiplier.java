package Exercises;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str1=scan.next();
        String str2=scan.next();
        int l1=str1.length();
        int l2=str2.length();
        int sum=0;
        int minL=Math.min(l1,l2);
        int maxL=Math.max(l1,l2);

        for (int i=0;i<minL;i++){
            int multiply=str1.charAt(i)*str2.charAt(i);
            sum+=multiply;
        }

        for (int i=minL;i<maxL;i++){
           int multiply = 0;
            if (str1.length()>str2.length()) {
                multiply = str1.charAt(i);
            }
            else{
                multiply = str2.charAt(i);
            }
            sum+=multiply;
        }
        System.out.println(sum);

    }
}
