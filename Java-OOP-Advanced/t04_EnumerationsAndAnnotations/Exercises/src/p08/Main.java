package p08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deck deck=new Deck();
        Player one=new Player(reader.readLine());
        Player two=new Player(reader.readLine());

        for (int i = 0; i < 5 ; i++) {
            String [] tokens=reader.readLine().split("\\s+");
            String rank = tokens[0];
            String suit = tokens[2];
            try {
                Card c = new Card(CardRank.valueOf(rank), CardSuit.valueOf(suit));
                deck.withdraw(c);
                one.addToHand(c);
            }catch(IllegalArgumentException ex){
                System.out.println("No such card exists.");
            }catch(IllegalStateException ex){
                System.out.println(ex.getMessage());
            }
        }

        for (int i = 0; i < 5 ; i++) {
            String [] tokens=reader.readLine().split("\\s+");
            String rank = tokens[0];
            String suit = tokens[2];
            try {
                Card c = new Card(CardRank.valueOf(rank), CardSuit.valueOf(suit));
                deck.withdraw(c);
                two.addToHand(c);
            }catch(IllegalArgumentException ex){
                System.out.println("No such card exists.");;
            }
        }

        Card playerOne=one.getHighest();
        Card playerTwo=two.getHighest();

        Player winner=playerOne.compareTo(playerTwo)>0?one:two;

        System.out.println(winner);
    }
}
