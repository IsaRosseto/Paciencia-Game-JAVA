package animation;

public interface Animation {
    public static final double MoveTime = 0.3;
    public static final double FlipTime = 0.4;

    public void update(double elapsed);

    public boolean ended();
}
