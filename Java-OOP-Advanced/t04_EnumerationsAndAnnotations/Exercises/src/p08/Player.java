package p08;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Player {
    private TreeSet<Card> hand;
    private String name;

    public Player(String name) {
        this.hand = new TreeSet<>();
        this.name=name;
    }

    public void addToHand(Card card){
        this.hand.add(card);
    }

    public Set<Card> getHand() {
        return this.hand;
    }

    public String getName() {
        return this.name;
    }

    public Card getHighest(){
        return this.hand.last();
    }

    @Override
    public String toString() {
        return this.name + " wins with " + this.getHighest()+".";
    }
}
