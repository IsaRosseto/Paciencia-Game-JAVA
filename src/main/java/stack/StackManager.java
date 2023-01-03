package stack;

import stack.CardStack;
import stack.DepositStack;
import stack.SimpleStack;
import stack.RestStack;
import stack.CardGenerator;
import animation.Animation;
import animation.AnimationPool;
import animation.MoveAnimation;
import animation.HandMoveAnimation;
import util.Point;

import game.Card;
import stack.Hand;

import java.util.List;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

public class StackManager {
    private List<CardStack> stacks;
    private CardGenerator cardGenerator;
    private AnimationPool animationPool;

    private CardStack pickedStack;
    private Hand pickedCards;
    private Point lastCardPosition;
    private Point lastPickPosition;

    public StackManager(AnimationPool animationPool) {
        this.stacks = new ArrayList<>();
        this.animationPool = animationPool;
        this.cardGenerator = new CardGenerator();
        this.pickedCards = null;
    }

    public void addSimpleStack(Point position, int n) throws CardGeneratorEmptyException {
        SimpleStack stack = new SimpleStack(this.animationPool, position);
        this.cardGenerator.generate(stack, n);
        stack.flipFirst();
        this.stacks.add(stack);
    }

    public void addDepositStack(Point position) {
        stacks.add(new DepositStack(this.animationPool, position));
    }

    public void addRestStack(Point position) {
        RestStack stack = new RestStack(this.animationPool, position);
        this.cardGenerator.rest(stack);
        this.stacks.add(stack);
    }

    public void pick(double x, double y) {
        for (CardStack stack : this.stacks) {
            if (stack.size() > 0 && stack.isOver(new Point(x, y))) {
                this.pickedStack = stack;
                this.pickedCards = stack.pick(new Point(x, y));
                this.lastCardPosition = this.pickedCards.getPosition();
                this.lastPickPosition = new Point(x, y);
            }
        }
    }

    public void drop(double x, double y) {
        if (this.pickedCards != null) {

            boolean dropped = false;
            for (CardStack stack : this.stacks) {
                if (this.pickedStack != stack && stack.isOver(new Point(x, y)) && stack.isValidTop(this.pickedCards)) {
                    this.pickedStack.remove(this.pickedCards);
                    stack.drop(this.pickedCards);
                    dropped = true;
                    break;
                }
            }

            if (!dropped)
                this.animationPool.add(
                        new HandMoveAnimation(this.pickedCards, this.pickedStack.getTopPosition(), Animation.MoveTime));

            this.pickedCards = null;
            this.lastCardPosition = null;
            this.lastPickPosition = null;
        }
    }

    public void move(double x, double y) {
        if (this.pickedCards != null) {
            Point newPosition = this.lastCardPosition.add(new Point(x, y)).minus(this.lastPickPosition);
            this.pickedCards.setPosition(newPosition);
        }
    }

    public void draw(GraphicsContext ctx) {
        for (CardStack stack : this.stacks)
            stack.draw(ctx);

        if (this.pickedCards != null)
            this.pickedCards.draw(ctx);
    }
}
