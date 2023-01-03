package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import util.Point;

public class ReloadButton {
    private static final double Width = 25.0;
    private static final double Height = 25.0;
    private static final String ButtonImgFilename = "./sprites/refreshing.png";

    private Point position;
    private Image image;

    public ReloadButton(double x, double y) {
        this.position = new Point(x, y);

        try {
            FileInputStream stream = new FileInputStream(ButtonImgFilename);
            this.image = new Image(stream);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error opening image file: " + fnfe.getMessage());
        }
    }

    public boolean isOver(Point p) {
        return p.getX() >= this.position.getX() && p.getY() >= this.position.getY()
                && p.getX() <= this.position.getX() + Width && p.getY() <= this.position.getY() + Height;
    }

    public void draw(GraphicsContext ctx) {
        ctx.drawImage(this.image, this.position.getX(), this.position.getY(), Width, Height);
    }
}
