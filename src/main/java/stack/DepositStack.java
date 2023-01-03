package stack;

import animation.Animation;
import animation.MoveAnimation;
import animation.AnimationPool;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import stack.CardStack;
import util.Point;
import game.Card;
import game.CardType;

public class DepositStack extends CardStack {

    private Point position;
    private AnimationPool animationPool;
    private Card placeholderCard;

    public DepositStack(AnimationPool animationPool, Point position) {
        this.animationPool = animationPool;
        this.position = position;
        this.placeholderCard = new Card(CardType.HRA);
        this.placeholderCard.setPosition(this.position);
    }

    @Override
    public void add(Card card) {
        animationPool.add(new MoveAnimation(card, this.position, Animation.MoveTime));
        super.add(card);
    }

    @Override
    public Hand pick(Point p) {
        Hand hand = new Hand();
        if (this.size() > 0 && this.cards.peek().isOver(p)) {
            hand.add(this.cards.peek());
        }

        return hand;
    }

    @Override
    public void draw(GraphicsContext ctx) {
        if (cards.size() > 1)
            cards.elementAt(cards.size() - 2).draw(ctx); // penult card
        else {
            ctx.setFill(new Color(0, 0, 0, 0.2f));
            ctx.fillRoundRect(this.position.getX() - Card.Width / 2, this.position.getY() - Card.Height / 2, Card.Width,
                    Card.Height, Card.Border, Card.Border);
        }

        if (cards.size() > 0)
            cards.peek().draw(ctx); // last card
    }

    @Override
    public boolean isOver(Point p) {
        return this.placeholderCard.isOver(p);
    }

    @Override
    public boolean isValidTop(Hand hand) {

        if (hand.size() != 1)
            return false;

        Card card = hand.bottom();

        if (this.cards.size() > 0) {
            Card top = this.cards.peek();
            if (top.getSuit() == card.getSuit() && CardType.isImediatlyGreater(top.getValue(), card.getValue()))
                return true;
        } else if (card.getValue() == CardType.Value.Ace)
            return true;

        return false;
    }

    @Override
    public Point getTopPosition() {
        return (Point) this.position.clone();
    }
}
