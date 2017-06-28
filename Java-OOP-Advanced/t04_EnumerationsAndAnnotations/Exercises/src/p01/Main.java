package p01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       if ("Card Suits".equalsIgnoreCase(reader.readLine())){
           System.out.println("Card Suits:");
            CardSuit[] cards=CardSuit.values();

           for (CardSuit card : cards) {
               System.out.println(card);
           }

       }
    }
}
