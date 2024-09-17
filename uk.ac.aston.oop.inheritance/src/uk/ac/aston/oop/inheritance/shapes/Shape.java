package uk.ac.aston.oop.inheritance.shapes;

import uk.ac.aston.oop.inheritance.util.GraphicsContextWrapper;

/**
 * Represents a geometric Shape specified by its upper-left corner coordinates,
 * width, and height.
 *
 * This is the base class for all geometric shapes in the inheritance lab.
 * It provides common functionality and properties shared by all shapes.
 *
 * @author Hammad Ali
 * @version 1.0
 */
public class Shape {
    private double upperLeftX, upperLeftY;
    private double width, height;

    /**
     * Creates a new instance of the Shape class.
     *
     * @param ulX X coordinate of the upper left corner.
     * @param ulY Y coordinate of the upper left corner.
     * @param width Width of the shape.
     * @param height Height of the shape.
     */
    public Shape(double ulX, double ulY, double width, double height) {
        this.upperLeftX = ulX;
        this.upperLeftY = ulY;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the X coordinate of the upper left corner.
     *
     * @return X coordinate of upper left corner.
     */
    public double getX() {
        return upperLeftX;
    }

    /**
     * Gets the Y coordinate of the upper left corner.
     *
     * @return Y coordinate of upper left corner.
     */
    public double getY() {
        return upperLeftY;
    }

    /**
     * Gets the width of the shape.
     *
     * @return Width of the shape.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Gets the height of the shape.
     *
     * @return Height of the shape.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Draws the shape on the provided graphics context.
     *
     * @param gc Graphics context to draw on.
     */
    public void draw(GraphicsContextWrapper gc) {
        // Implementation specific to each shape
        System.out.println("Cannot draw a generic shape.");
    }
}
