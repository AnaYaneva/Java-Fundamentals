package p07;

public class Card implements Comparable<Card> {

    private CardRank rank;
    private CardSuit suit;
    private int power;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
        this.power=getPower();
    }

    private int getPower() {
       return this.rank.getPower()+this.suit.getValue();
    }

    @Override
    public String toString() {
        return String.format("%s of %s",
                this.rank.name(),
                this.suit.name());
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getPower(),o.getPower());
    }
}
