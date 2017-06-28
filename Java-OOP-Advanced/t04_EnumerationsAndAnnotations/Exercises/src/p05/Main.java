package p05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Card> deck=new ArrayList<>();

        for (int i = 0; i < 2 ; i++) {
            String rank = reader.readLine().toUpperCase();
            String suit = reader.readLine().toUpperCase();
            Card c = new Card(CardRank.valueOf(rank), CardSuit.valueOf(suit));
            deck.add(c);
        }

        Card winner=deck.get(0).compareTo(deck.get(1))>0?deck.get(0):deck.get(1);
        System.out.println(winner);

    }
}
