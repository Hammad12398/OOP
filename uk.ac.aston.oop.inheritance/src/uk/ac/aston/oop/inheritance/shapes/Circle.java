package uk.ac.aston.oop.inheritance.shapes;

import uk.ac.aston.oop.inheritance.util.GraphicsContextWrapper;

/**
 * Represents a geometric Circle specified by its center coordinates and radius.
 *
 * @author Hammad Ali
 * @version 1.0
 */
public class Circle extends Ellipse {

    public Circle(double centerX, double centerY, double radius) {
        super(centerX - radius, centerY - radius, radius * 2, radius * 2);
    }

    public double getRadius() {
        // Calculate the radius from the width or height, as the circle has equal width and height
        return getWidth() / 2;
    }
}
