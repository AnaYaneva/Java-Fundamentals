package p04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rank=reader.readLine().toUpperCase();
        String suit=reader.readLine().toUpperCase();

        int power= CardRank.valueOf(rank).getPower()+
                  CardSuit.valueOf(suit).getValue();

        System.out.println(String.format("Card name: %s of %s;" +
                " Card power: %d", CardRank.valueOf(rank),
                CardSuit.valueOf(suit),power));

    }
}
