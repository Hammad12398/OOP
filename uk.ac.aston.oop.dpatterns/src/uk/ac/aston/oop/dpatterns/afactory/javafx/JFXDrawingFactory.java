package uk.ac.aston.oop.dpatterns.afactory.javafx;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uk.ac.aston.oop.dpatterns.afactory.Circle;
import uk.ac.aston.oop.dpatterns.afactory.Drawing;
import uk.ac.aston.oop.dpatterns.afactory.DrawingFactory;

public class JFXDrawingFactory implements DrawingFactory {

    private final Stage stage;
    private Group container;

    public JFXDrawingFactory(Stage stage) {
        this.stage = stage;
    }

    @Override
    public Drawing createDrawing(int width, int height) {
        if (container == null) {
            container = new Group();
            try {
                createScene(width, height);
            } catch (Exception e) {
                e.printStackTrace(); 
            }
        }
        return new JFXDrawing(container, width, height);
    }

    @Override
    public Circle createCircle(int cx, int cy, int radius) {
        return new JFXCircle(cx, cy, radius);
    }

    private void createScene(int width, int height) throws Exception {
        Scene scene = new Scene(container, width, height);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
