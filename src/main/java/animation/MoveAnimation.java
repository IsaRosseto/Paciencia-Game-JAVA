package animation;

import animation.Animation;
import util.Point;
import game.Card;

public class MoveAnimation implements Animation {
    private Card card;

    private boolean animEnded;
    private Point initialPosition;
    private Point targetPosition;
    private double elapsedTime;
    private double totalTime;

    public MoveAnimation(Card card, Point target, double time) {
        this.card = card;

        this.initialPosition = this.card.getPosition();
        this.targetPosition = target;
        this.totalTime = time;
    }

    public void update(double elapsed) {
        this.elapsedTime += elapsed;
        double factor = this.elapsedTime / this.totalTime;

        if (factor >= 1) {
            this.card.setPosition(this.targetPosition);
            this.animEnded = true;
        } else {
            this.card.setPosition(
                    this.initialPosition.add(this.targetPosition.minus(this.initialPosition).times(factor)));
        }
    }

    public boolean ended() {
        return this.animEnded;
    }
}

/*GitHub@IsaRosseto*/
