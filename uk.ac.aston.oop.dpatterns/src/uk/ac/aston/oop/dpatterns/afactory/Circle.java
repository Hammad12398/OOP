package uk.ac.aston.oop.dpatterns.afactory.javafx;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import uk.ac.aston.oop.dpatterns.afactory.Circle;

public class JFXCircle implements Circle {
    private javafx.scene.shape.Circle fxCircle;

    public JFXCircle(Group group, int centerX, int centerY, int radius) {
        fxCircle = new javafx.scene.shape.Circle(centerX, centerY, radius);
        group.getChildren().add(fxCircle);
    }

    @Override
    public void setFill(int red, int green, int blue) {
        fxCircle.setFill(Color.rgb(red, green, blue));
    }
}
