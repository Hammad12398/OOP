package uk.ac.aston.oop.inheritance.shapes;

import uk.ac.aston.oop.inheritance.util.GraphicsContextWrapper;

/**
 * Represents a geometric Rectangle specified by its upper-left corner coordinates,
 * width, and height.
 *
 * @author Hammad Ali
 * @version 1.0
 */
public class Rectangle extends Shape {

    public Rectangle(double ulX, double ulY, double width, double height) {
        super(ulX, ulY, width, height);
    }

    @Override
    public void draw(GraphicsContextWrapper gc) {
        gc.lineWidth(5);
        gc.rect(getX(), getY(), getWidth(), getHeight());
    }
}
