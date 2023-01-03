package stack;

import java.util.List;
import java.util.Stack;
import javafx.scene.canvas.GraphicsContext;

import game.Card;
import stack.Hand;
import util.Point;

public abstract class CardStack {
    public static final double DefaultCardsMargin = 20.0f;
    public static final double MaxStackHeight = 280.0;

    protected Stack<Card> cards;

    public CardStack() {
        cards = new Stack<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public Card peek() {
        return this.cards.peek();
    }

    public Card pop() {
        return this.cards.pop();
    }

    public void drop(Hand hand) {
        for (Card card : hand.getCards())
            this.add(card);
    }

    public void remove(Hand hand) {
        List<Card> handCards = hand.getCards();

        for (Card card : handCards)
            this.cards.remove(card);
    }

    public int size() {
        return this.cards.size();
    }

    public Hand pick(Point p) {
        return new Hand();
    }

    public boolean isValidTop(Hand hand) {
        return false;
    }

    public abstract Point getTopPosition();

    public abstract boolean isOver(Point p);

    public abstract void draw(GraphicsContext ctx);
}
