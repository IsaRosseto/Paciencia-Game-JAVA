package stack;

import animation.Animation;
import animation.AnimationPool;
import game.Card;
import game.CardType;
import stack.Hand;
import javafx.scene.canvas.GraphicsContext;
import stack.CardStack;
import animation.MoveAnimation;
import animation.FlipAnimation;
import animation.FlipAnimation.FlipType;
import util.Point;

public class SimpleStack extends CardStack {

    private AnimationPool animationPool;
    private Point position;
    private double cardsMargin;
    private Card placeholderCard;
    private int topIndex;

    public SimpleStack(AnimationPool animationPool, Point position) {
        super();
        this.animationPool = animationPool;
        this.position = position;
        this.cardsMargin = CardStack.DefaultCardsMargin;
        this.placeholderCard = new Card(CardType.HRA);
        this.placeholderCard.setPosition(this.position);
        this.topIndex = 0;
    }

    @Override
    public void add(Card card) {
        super.add(card);
        this.topIndex = this.cards.size() - 1;

        Point topPosition = this.getTopPosition();
        animationPool.add(new MoveAnimation(card, topPosition, Animation.MoveTime));

        this.updateCardsPositions();
    }

    @Override
    public Card pop() {
        Card card = super.pop();
        this.topIndex = this.cards.size() - 1;

        if (this.cards.size() > 0 && !this.peek().isFlipped()) {
            animationPool.add(new FlipAnimation(this.peek(), FlipType.SHOW, Animation.FlipTime));
            this.peek().flip();
        }

        return card;
    }

    @Override
    public Hand pick(Point p) {
        Hand hand = new Hand();
        int k = this.cards.size() - 1;
        int index = this.cards.size();
        while (k >= 0 && this.cards.get(k).isFlipped()) {
            if (this.cards.get(k).isOver(p)) {
                index = k;
                break;
            }
            k--;
        }

        for (int i = index; i < this.cards.size(); i++)
            hand.add(this.cards.get(i));

        this.topIndex = this.cards.size() - hand.size();
        return hand;
    }

    @Override
    public void remove(Hand hand) {
        super.remove(hand);

        if (this.cards.size() > 0 && !this.peek().isFlipped()) {
            animationPool.add(new FlipAnimation(this.peek(), FlipType.SHOW, Animation.FlipTime));
            this.peek().flip();
        }

        this.topIndex = this.cards.size() - 1;
    }

    @Override
    public void drop(Hand hand) {
        super.drop(hand);

        this.topIndex = this.cards.size() - 1;
        this.updateCardsPositions();
    }

    public void flipFirst() {
        if (this.cards.size() > 0) {
            this.cards.peek().flip();
            this.cards.peek().setAngle(0);
        }
    }

    @Override
    public Point getTopPosition() {
        return this.position.add(new Point(0, this.cardsMargin * (this.topIndex)));
    }

    @Override
    public void draw(GraphicsContext ctx) {
        for (Card card : cards)
            card.draw(ctx);
    }

    @Override
    public boolean isOver(Point p) {
        boolean over = false;

        if (this.cards.size() > 0) {
            for (Card card : this.cards)
                if (card.isOver(p))
                    over = true;
        } else
            over = this.placeholderCard.isOver(p);

        return over;
    }

    @Override
    public boolean isValidTop(Hand hand) {
        boolean isValid = false;

        Card card = hand.bottom();
        if (this.cards.size() > 0) {
            Card top = this.peek();
            if (top.getColor() != card.getColor() && CardType.isImediatlyGreater(card.getValue(), top.getValue()))
                isValid = true;
        } else if (card.getValue() == CardType.Value.King)
            isValid = true;

        return isValid;
    }

    private void updateCardsPositions() {
        int numOfCards = this.cards.size();
        double stackHeight = this.cardsMargin * numOfCards + Card.Height;

        if (stackHeight > CardStack.MaxStackHeight) {

            this.cardsMargin = (MaxStackHeight - Card.Height) / numOfCards;

            Point cardPosition = this.position;
            for (Card card : this.cards) {
                animationPool.add(new MoveAnimation(card, cardPosition, Animation.MoveTime));
                cardPosition = cardPosition.add(new Point(0, this.cardsMargin));
            }
        }
    }
}
