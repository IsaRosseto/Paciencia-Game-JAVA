package game;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import game.CardType;
import game.CardSpriteHolder;

import util.Point;
import util.Rectangle;

public class Card {
    public static final double Width = 70;
    public static final double Height = 95;
    public static final double Border = 10;

    private CardType type;
    private Point position;
    private Rectangle frontRect;
    private Rectangle backRect;
    private Image frontImage;
    private Image backImage;

    private double angle;
    private boolean flipped;

    public Card(CardType type) {
        this.type = type;

        this.position = new Point(0, 0);

        this.angle = Math.PI;
        this.flipped = false;

        this.frontImage = CardSpriteHolder.getCardsImage();
        this.backImage = CardSpriteHolder.getBackImage();
        this.frontRect = CardSpriteHolder.getCardBound(type);
        this.backRect = CardSpriteHolder.getBackBound();
    }

    public void draw(GraphicsContext ctx) {
        double xScale = Math.cos(this.angle);

        if (this.angle <= Math.PI / 2.0 || this.angle >= Math.PI * (3.0 / 2.0))
            ctx.drawImage(this.frontImage, this.frontRect.getLeft(), this.frontRect.getTop(), this.frontRect.getWidth(),
                    this.frontRect.getHeight(), this.position.getX() + (1.0 - xScale) * Width / 2 - Width / 2,
                    this.position.getY() - Height / 2, Width * xScale, Height);
        else
            ctx.drawImage(this.backImage, this.backRect.getLeft(), this.backRect.getTop(), this.backRect.getWidth(),
                    this.backRect.getHeight(), this.position.getX() + (1.0 - xScale) * Width / 2 - Width / 2,
                    this.position.getY() - Height / 2, Width * xScale, Height);
    }

    public void setAngle(double angle) {
        this.angle = angle % (2 * Math.PI);
    }

    public double getAngle() {
        return this.angle;
    }

    public void setPosition(Point position) {
        this.position = (Point) position.clone();
    }

    public Point getPosition() {
        return (Point) this.position.clone();
    }

    public CardType.Suit getSuit() {
        return this.type.getSuit();
    }

    public CardType.Color getColor() {
        return this.type.getColor();
    }

    public CardType.Value getValue() {
        return this.type.getValue();
    }

    public void flip() {
        this.flipped = !this.flipped;
    }

    public boolean isFlipped() {
        return this.flipped;
    }

    public boolean isOver(Point p) {
        Point norm = p.minus(this.position).add(new Point(Width / 2, Height / 2));

        return norm.getX() >= 0 && norm.getY() >= 0 && norm.getX() <= Width && norm.getY() <= Height;
    }
}
