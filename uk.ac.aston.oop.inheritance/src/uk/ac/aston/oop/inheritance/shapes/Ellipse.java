package uk.ac.aston.oop.inheritance.shapes;

import uk.ac.aston.oop.inheritance.util.GraphicsContextWrapper;

/**
 * Represents a geometric Ellipse specified by its center coordinates, horizontal radius,
 * and vertical radius.
 *
 * @author Hammad Ali
 * @version 1.0
 */
public class Ellipse extends Shape {

    /**
     * Creates a new instance of Ellipse.
     *
     * @param upperLeftX X coordinate of the upper left corner.
     * @param upperLeftY Y coordinate of the upper left corner.
     * @param width      Horizontal radius of the ellipse.
     * @param height     Vertical radius of the ellipse.
     */
    public Ellipse(double upperLeftX, double upperLeftY, double width, double height) {
        super(upperLeftX, upperLeftY, width, height);
    }

    /**
     * Draws the ellipse using the specified graphics context.
     *
     * @param gc Graphics context wrapper used for drawing.
     */
    @Override
    public void draw(GraphicsContextWrapper gc) {
        gc.oval(getX(), getY(), getWidth(), getHeight());
    }
}
