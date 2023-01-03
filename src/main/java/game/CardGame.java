package game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import stack.CardGeneratorEmptyException;
import stack.CardStack;
import stack.StackManager;

import game.Card;
import game.CardType;
import game.ReloadButton;
import animation.Animation;
import animation.AnimationPool;
import animation.FlipAnimation;
import animation.MoveAnimation;

import util.Point;

public class CardGame {
    public static final int Width = 760;
    public static final int Height = 480;
    private static final Color BgColor = new Color(0.43, 0.18, 0.23, 1.0);

    private Canvas canvas;
    private AnimationPool animationPool;
    private StackManager stackManager;
    private ReloadButton reloadButton;

    public CardGame(Canvas canvas) {
        this.canvas = canvas;
        this.reset();
    }

    private void reset() {

        this.animationPool = new AnimationPool();
        this.stackManager = new StackManager(this.animationPool);
        this.reloadButton = new ReloadButton(10, 10);

        try {

            this.stackManager.addSimpleStack(new Point(80, 120), 1);
            this.stackManager.addSimpleStack(new Point(160, 120), 2);
            this.stackManager.addSimpleStack(new Point(240, 120), 3);
            this.stackManager.addSimpleStack(new Point(320, 120), 4);
            this.stackManager.addSimpleStack(new Point(400, 120), 5);
            this.stackManager.addSimpleStack(new Point(480, 120), 6);
            this.stackManager.addSimpleStack(new Point(560, 120), 7);

        } catch (CardGeneratorEmptyException cgee) {
            System.out.println(cgee.getMessage());
        }

        this.stackManager.addDepositStack(new Point(680, 80));
        this.stackManager.addDepositStack(new Point(680, 190));
        this.stackManager.addDepositStack(new Point(680, 300));
        this.stackManager.addDepositStack(new Point(680, 410));

        this.stackManager.addRestStack(new Point(80, 400));
    }

    public void loop(double elapsed) {
        this.update(elapsed);
        this.render(elapsed);
    }

    public void update(double elapsed) {
        this.animationPool.update(elapsed);
    }

    public void mousePress(double x, double y) {
        this.stackManager.pick(x, y);
    }

    public void mouseReleased(double x, double y) {
        this.stackManager.drop(x, y);
    }

    public void mouseMoved(double x, double y) {
        this.stackManager.move(x, y);
    }

    public void mouseClicked(double x, double y) {
        if (reloadButton.isOver(new Point(x, y)))
            this.reset();
    }

    public void render(double elapsed) {
        GraphicsContext ctx = canvas.getGraphicsContext2D();

        ctx.setFill(BgColor);
        ctx.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        this.reloadButton.draw(ctx);
        this.stackManager.draw(ctx);
    }
}
