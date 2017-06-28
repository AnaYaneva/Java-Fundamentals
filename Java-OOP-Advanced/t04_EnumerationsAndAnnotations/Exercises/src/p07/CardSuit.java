package p07;

@Enum(category = "Suit", description = "Provides suit constants for a Card class.")
public enum CardSuit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int power;

    CardSuit(int power) {
        this.power = power;
    }

    public int getValue() {
        return this.power;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
