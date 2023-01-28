package animation;

import game.Card;

import animation.Animation;

public class FlipAnimation implements Animation {
    private Card card;

    private boolean animEnded;
    private double initialAngle;
    private double targetAngle;
    private double elapsedTime;
    private double totalTime;

    public enum FlipType {
        SHOW, HIDE
    };

    public FlipAnimation(Card card, FlipType type, double time) {
        this.card = card;
        this.animEnded = false;
        this.totalTime = time;
        this.initialAngle = card.getAngle() - card.getAngle() % Math.PI; // take the flipped or no-flipped angles
        this.targetAngle = type == FlipType.HIDE ? Math.PI : 0;
    }

    public void update(double elapsed) {
        this.elapsedTime += elapsed;
        double factor = this.elapsedTime / this.totalTime;

        if (factor >= 1.0) {
            animEnded = true;
            card.setAngle(this.targetAngle);
        } else {
            card.setAngle(this.initialAngle + (this.targetAngle - this.initialAngle) * factor);
        }
    }

    public boolean ended() {
        return this.animEnded;
    }
}

/*GitHub@IsaRosseto*/
