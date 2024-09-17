// Launcher class
package uk.ac.aston.oop.acint;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import uk.ac.aston.oop.acint.shapes.Circle;
import uk.ac.aston.oop.acint.shapes.Ellipse;
import uk.ac.aston.oop.acint.shapes.Rectangle;
import uk.ac.aston.oop.acint.shapes.Drawable;
import uk.ac.aston.oop.acint.shapes.Cross;
import uk.ac.aston.oop.acint.util.GraphicsContextWrapper;

public class Launcher extends Application {

    private Canvas canvas;
    private GraphicsContext graphics;
    private Drawable[] drawables;

    private int iFrame = 0;

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        canvas = new Canvas(500, 500);
        root.getChildren().add(canvas);
        graphics = canvas.getGraphicsContext2D();

        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();

        drawables = new Drawable[5];
        drawables[0] = new Rectangle(50, 50, 100, 100);
        drawables[1] = new Circle(200, 200, 50);
        drawables[2] = new Ellipse(350, 350, 80, 40);
        drawables[3] = new Cross(100, 100);
        drawables[4] = new Cross(400, 400); // Example of adding another Cross object

        draw();
        Timeline drawEverySecond = new Timeline(
                new KeyFrame(Duration.millis(1000 / 30), (event) -> {
                    draw();
                })
        );
        drawEverySecond.setCycleCount(Timeline.INDEFINITE);
        drawEverySecond.play();
    }

    private void draw() {
        graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        GraphicsContextWrapper gcw = new GraphicsContextWrapper(graphics);

        for (Drawable drawable : drawables) {
            drawable.move(gcw, 1, 1);
            drawable.draw(gcw);

            if (drawable instanceof Circle) {
                ((Circle) drawable).scale(0.5);
            }
        }

        iFrame = (iFrame + 1) % 30;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
