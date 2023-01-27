package animation;

import animation.Animation;
import util.Point;
import stack.Hand;

public class HandMoveAnimation implements Animation {
    private Hand hand;

    private boolean animEnded;
    private Point initialPosition;
    private Point targetPosition;
    private double elapsedTime;
    private double totalTime;

    public HandMoveAnimation(Hand hand, Point target, double time) {
        this.hand = hand;

        this.initialPosition = this.hand.getPosition();
        this.targetPosition = target;
        this.totalTime = time;
    }

    public void update(double elapsed) {
        this.elapsedTime += elapsed;
        double factor = this.elapsedTime / this.totalTime;

        if (factor >= 1) {
            this.hand.setPosition(this.targetPosition);
            this.animEnded = true;
        } else {
            this.hand.setPosition(
                    this.initialPosition.add(this.targetPosition.minus(this.initialPosition).times(factor)));
        }
    }

    public boolean ended() {
        return this.animEnded;
    }
}

/*GitHub@IsaRosseto*/
