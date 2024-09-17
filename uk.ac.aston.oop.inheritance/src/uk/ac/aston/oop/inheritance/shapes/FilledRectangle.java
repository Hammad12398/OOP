package uk.ac.aston.oop.inheritance.shapes;

import javafx.scene.paint.Color;
import uk.ac.aston.oop.inheritance.util.GraphicsContextWrapper;

/**
 * Represents a geometric FilledRectangle specified by its upper-left corner coordinates,
 * width, height, and fill color.
 *
 * @author Hammad Ali
 * @version 1.0
 */
public class FilledRectangle extends Rectangle {

    private Color fill;

    public FilledRectangle(Color fill, double ulX, double ulY, double width, double height) {
        super(ulX, ulY, width, height);
        this.fill = fill;
    }

    public Color getFill() {
        return fill;
    }

    @Override
    public void draw(GraphicsContextWrapper gc) {
        super.draw(gc); // Call the draw method of the superclass (Rectangle)
        gc.fill(fill); // Set the fill color
        gc.fillRect(getX(), getY(), getWidth(), getHeight()); // Draw the filled rectangle
    }

    @Override
    public String toString() {
        return "FilledRectangle{" +
                "ulX=" + getX() +
                ", ulY=" + getY() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", fill=" + fill +
                '}';
    }
}
