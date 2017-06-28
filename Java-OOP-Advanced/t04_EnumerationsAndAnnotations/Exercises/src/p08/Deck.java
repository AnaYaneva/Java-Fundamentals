package p08;

import java.util.Set;
import java.util.TreeSet;

public class Deck {
    private Set<Card> deck;

    public Deck() {
        this.deck=new TreeSet<>();
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                Card card = new Card(cardRank, cardSuit);
                this.deck.add(card);
            }
        }
    }

    public boolean isInDeck(Card card){
        return this.deck.contains(card);
    }

    public void withdraw(Card card){
        if (!isInDeck(card)){
            throw new IllegalStateException("Card is not in the deck.");
        }else{
            this.deck.remove(card);
        }
    }
}
