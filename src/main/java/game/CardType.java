package game;

public final class CardType {
    public enum Suit {
        Hearts, Diamonds, Clubs, Spades
    }

    public enum Color {
        Red, Black
    }

    public enum Value {
        Ace, V2, V3, V4, V5, V6, V7, V8, V9, V10, Jack, Queen, King
    }

    private Suit suit;
    private Color color;
    private Value value;

    public CardType(Suit suit, Color color, Value value) {
        this.suit = suit;
        this.color = color;
        this.value = value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Color getColor() {
        return this.color;
    }

    public Value getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof CardType))
            return false;

        CardType type = (CardType) obj;

        return this.color == type.getColor() && this.suit == type.getSuit() && this.value == type.getValue();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.suit.hashCode();
        result = prime * result + this.color.hashCode();
        result = prime * result + this.value.hashCode();
        return result;
    }

    public static final boolean isImediatlyGreater(CardType.Value v1, CardType.Value v2) {
        return v1 == Value.Ace && v2 == Value.V2 || v1 == Value.V2 && v2 == Value.V3 || v1 == Value.V3 && v2 == Value.V4
                || v1 == Value.V4 && v2 == Value.V5 || v1 == Value.V5 && v2 == Value.V6
                || v1 == Value.V6 && v2 == Value.V7 || v1 == Value.V7 && v2 == Value.V8
                || v1 == Value.V8 && v2 == Value.V9 || v1 == Value.V9 && v2 == Value.V10
                || v1 == Value.V10 && v2 == Value.Jack || v1 == Value.Jack && v2 == Value.Queen
                || v1 == Value.Queen && v2 == Value.King;
    }

    public static final CardType HRA = new CardType(Suit.Hearts, Color.Red, Value.Ace);
    public static final CardType HR2 = new CardType(Suit.Hearts, Color.Red, Value.V2);
    public static final CardType HR3 = new CardType(Suit.Hearts, Color.Red, Value.V3);
    public static final CardType HR4 = new CardType(Suit.Hearts, Color.Red, Value.V4);
    public static final CardType HR5 = new CardType(Suit.Hearts, Color.Red, Value.V5);
    public static final CardType HR6 = new CardType(Suit.Hearts, Color.Red, Value.V6);
    public static final CardType HR7 = new CardType(Suit.Hearts, Color.Red, Value.V7);
    public static final CardType HR8 = new CardType(Suit.Hearts, Color.Red, Value.V8);
    public static final CardType HR9 = new CardType(Suit.Hearts, Color.Red, Value.V9);
    public static final CardType HR10 = new CardType(Suit.Hearts, Color.Red, Value.V10);
    public static final CardType HRJ = new CardType(Suit.Hearts, Color.Red, Value.Jack);
    public static final CardType HRQ = new CardType(Suit.Hearts, Color.Red, Value.Queen);
    public static final CardType HRK = new CardType(Suit.Hearts, Color.Red, Value.King);

    public static final CardType DRA = new CardType(Suit.Diamonds, Color.Red, Value.Ace);
    public static final CardType DR2 = new CardType(Suit.Diamonds, Color.Red, Value.V2);
    public static final CardType DR3 = new CardType(Suit.Diamonds, Color.Red, Value.V3);
    public static final CardType DR4 = new CardType(Suit.Diamonds, Color.Red, Value.V4);
    public static final CardType DR5 = new CardType(Suit.Diamonds, Color.Red, Value.V5);
    public static final CardType DR6 = new CardType(Suit.Diamonds, Color.Red, Value.V6);
    public static final CardType DR7 = new CardType(Suit.Diamonds, Color.Red, Value.V7);
    public static final CardType DR8 = new CardType(Suit.Diamonds, Color.Red, Value.V8);
    public static final CardType DR9 = new CardType(Suit.Diamonds, Color.Red, Value.V9);
    public static final CardType DR10 = new CardType(Suit.Diamonds, Color.Red, Value.V10);
    public static final CardType DRJ = new CardType(Suit.Diamonds, Color.Red, Value.Jack);
    public static final CardType DRQ = new CardType(Suit.Diamonds, Color.Red, Value.Queen);
    public static final CardType DRK = new CardType(Suit.Diamonds, Color.Red, Value.King);

    public static final CardType CBA = new CardType(Suit.Clubs, Color.Black, Value.Ace);
    public static final CardType CB2 = new CardType(Suit.Clubs, Color.Black, Value.V2);
    public static final CardType CB3 = new CardType(Suit.Clubs, Color.Black, Value.V3);
    public static final CardType CB4 = new CardType(Suit.Clubs, Color.Black, Value.V4);
    public static final CardType CB5 = new CardType(Suit.Clubs, Color.Black, Value.V5);
    public static final CardType CB6 = new CardType(Suit.Clubs, Color.Black, Value.V6);
    public static final CardType CB7 = new CardType(Suit.Clubs, Color.Black, Value.V7);
    public static final CardType CB8 = new CardType(Suit.Clubs, Color.Black, Value.V8);
    public static final CardType CB9 = new CardType(Suit.Clubs, Color.Black, Value.V9);
    public static final CardType CB10 = new CardType(Suit.Clubs, Color.Black, Value.V10);
    public static final CardType CBJ = new CardType(Suit.Clubs, Color.Black, Value.Jack);
    public static final CardType CBQ = new CardType(Suit.Clubs, Color.Black, Value.Queen);
    public static final CardType CBK = new CardType(Suit.Clubs, Color.Black, Value.King);

    public static final CardType SBA = new CardType(Suit.Spades, Color.Black, Value.Ace);
    public static final CardType SB2 = new CardType(Suit.Spades, Color.Black, Value.V2);
    public static final CardType SB3 = new CardType(Suit.Spades, Color.Black, Value.V3);
    public static final CardType SB4 = new CardType(Suit.Spades, Color.Black, Value.V4);
    public static final CardType SB5 = new CardType(Suit.Spades, Color.Black, Value.V5);
    public static final CardType SB6 = new CardType(Suit.Spades, Color.Black, Value.V6);
    public static final CardType SB7 = new CardType(Suit.Spades, Color.Black, Value.V7);
    public static final CardType SB8 = new CardType(Suit.Spades, Color.Black, Value.V8);
    public static final CardType SB9 = new CardType(Suit.Spades, Color.Black, Value.V9);
    public static final CardType SB10 = new CardType(Suit.Spades, Color.Black, Value.V10);
    public static final CardType SBJ = new CardType(Suit.Spades, Color.Black, Value.Jack);
    public static final CardType SBQ = new CardType(Suit.Spades, Color.Black, Value.Queen);
    public static final CardType SBK = new CardType(Suit.Spades, Color.Black, Value.King);
}
