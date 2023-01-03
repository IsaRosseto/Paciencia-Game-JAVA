package stack;

import java.util.List;
import java.util.ArrayList;

import stack.CardStack;

import game.Card;
import javafx.scene.canvas.GraphicsContext;
import util.Point;

public class Hand {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public Card bottom() {
        return this.cards.get(0);
    }

    public int size() {
        return this.cards.size();
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void draw(GraphicsContext ctx) {
        for (Card card : this.cards)
            card.draw(ctx);
    }

    public void setPosition(Point p) {
        Point pos = (Point) p.clone();

        for (Card card : this.cards) {
            card.setPosition(pos);
            pos = pos.add(new Point(0, CardStack.DefaultCardsMargin));
        }
    }

    public Point getPosition() {
        if (this.cards.size() > 0)
            return this.cards.get(0).getPosition();

        return new Point(0, 0);
    }
}
