package ExercisesSetsAndMaps;

import java.util.Scanner;
import java.util.TreeMap;

//Write a program that reads some text from the console and counts the occurrences of each character in it. Print the results in alphabetical (lexicographical) order.

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] input = scan.nextLine().toCharArray();

        TreeMap<Character, Integer> count=new TreeMap<>();

        for (char s : input) {
            if (!count.containsKey(s)){
                count.put(s,1);
            }else{
                count.put(s,count.get(s)+1);
            }
        }

        for (Character ch : count.keySet()) {
            System.out.printf("%c: %d time/s%n",ch,count.get(ch));
        }

    }
}
