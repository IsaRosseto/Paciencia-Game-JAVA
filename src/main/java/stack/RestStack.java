package stack;

import javafx.scene.canvas.GraphicsContext;
import animation.Animation;
import animation.AnimationPool;
import animation.FlipAnimation;
import animation.FlipAnimation.FlipType;
import animation.MoveAnimation;
import stack.CardStack;

import game.Card;
import game.CardType;
import util.Point;

public class RestStack extends CardStack {
    private static final double HorizontalOffset = 200.0;
    private static final int NumShowingCards = 4;

    private Point position;
    private AnimationPool animationPool;
    private Card placeholderCard;
    private int topIndex;

    public RestStack(AnimationPool animationPool, Point position) {
        this.position = position;
        this.animationPool = animationPool;
        this.placeholderCard = new Card(CardType.HRA);
        this.placeholderCard.setPosition(position);
        this.topIndex = -1;
    }

    @Override
    public void add(Card card) {
        super.add(card);
        this.animationPool.add(new MoveAnimation(card, this.position, Animation.MoveTime));
    }

    @Override
    public Hand pick(Point p) {
        Hand result = new Hand();

        if (this.placeholderCard.isOver(p))
            this.shiftCards();
        else if (this.topIndex >= 0 && this.getTopCard().isOver(p))
            result = pickFirstCard();

        return result;
    }

    private Card getTopCard() {
        if (this.topIndex >= 0)
            return this.cards.get(this.topIndex);

        return null;
    }

    private Hand pickFirstCard() {
        Hand result = new Hand();
        result.add(this.getTopCard());
        return result;
    }

    private void shiftCards() {
        this.topIndex++;

        if (this.topIndex >= this.cards.size()) {
            this.topIndex = -1;
            this.resetStack();
        } else {
            this.getTopCard().flip();
            this.updateCardsPosition();
        }
    }

    private void updateCardsPosition() {
        Card card = this.getTopCard();

        if (card != null)
            this.animationPool.add(new FlipAnimation(card, FlipType.SHOW, Animation.FlipTime));

        for (int i = 0; i < NumShowingCards; i++) {
            if (this.topIndex >= i) {
                this.animationPool.add(new MoveAnimation(this.cards.get(topIndex - i),
                        this.position.add(new Point(HorizontalOffset - CardStack.DefaultCardsMargin * i, 0)),
                        Animation.MoveTime));
            }
        }
    }

    private void resetStack() {
        for (Card card : this.cards) {
            this.animationPool.add(new MoveAnimation(card, this.position, Animation.MoveTime));

            if (card.isFlipped()) {
                card.flip();
                this.animationPool.add(new FlipAnimation(card, FlipType.HIDE, Animation.MoveTime));
            }
        }
    }

    @Override
    public boolean isOver(Point p) {
        if (this.placeholderCard.isOver(p))
            return true;

        if (this.topIndex >= 0 && this.cards.get(this.topIndex).isOver(p))
            return true;

        return false;
    }

    @Override
    public Point getTopPosition() {
        if (this.topIndex >= 0)
            return this.position.add(new Point(HorizontalOffset, 0));

        return (Point) this.position.clone();
    }

    @Override
    public void remove(Hand hand) {
        if (hand.size() == 1 && hand.bottom().equals(this.getTopCard())) {
            this.topIndex--;
            super.remove(hand);
            this.updateCardsPosition();
        }
    }

    @Override
    public void draw(GraphicsContext ctx) {
        for (Card card : this.cards)
            card.draw(ctx);
    }
}
