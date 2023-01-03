package util;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Point add(Point p) {
        return new Point(this.x + p.getX(), this.y + p.getY());
    }

    public Point minus(Point p) {
        return new Point(this.x - p.getX(), this.y - p.getY());
    }

    public Point times(double x) {
        return new Point(this.x * x, this.y * x);
    }

    @Override
    public Object clone() {
        return new Point(this.x, this.y);
    }
}
