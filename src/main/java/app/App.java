package app;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import game.CardGame;

public class App extends Application {
    private final String WindowTitle = "Card Game";

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        Canvas canvas = new Canvas(CardGame.Width, CardGame.Height);
        CardGame game = new CardGame(canvas);

        new AnimationTimer() {
            private long lastTime;

            @Override
            public void start() {
                lastTime = System.nanoTime();
                super.start();
            }

            @Override
            public void handle(long now) {
                long elapsedNanoSecs = now - lastTime;
                lastTime = now;
                double elapsedSeconds = elapsedNanoSecs / 1000000000.0;

                game.loop(elapsedSeconds);
            }
        }.start();

        EventHandler<MouseEvent> mousePressedHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                game.mousePress(e.getSceneX(), e.getSceneY());
            }
        };

        EventHandler<MouseEvent> mouseReleasedHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                game.mouseReleased(e.getSceneX(), e.getSceneY());
            }
        };

        EventHandler<MouseEvent> mouseMovedHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                game.mouseMoved(e.getSceneX(), e.getSceneY());
            }
        };

        EventHandler<MouseEvent> mouseClickedHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (e.getButton() == MouseButton.PRIMARY)
                    game.mouseClicked(e.getSceneX(), e.getSceneY());
            }
        };

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, mousePressedHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, mouseReleasedHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, mouseMovedHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseClickedHandler);

        stage.setScene(new Scene(new Group(canvas)));
        stage.setTitle(WindowTitle);
        stage.setResizable(false);
        stage.show();
    }
}

/*GitHub@IsaRosseto*/
