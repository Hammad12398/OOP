package uk.ac.aston.oop.acint.shapes;

import uk.ac.aston.oop.acint.util.GraphicsContextWrapper;

public abstract class Shape implements Drawable {

    protected double upperLeftX;
    protected double upperLeftY;
    protected double width;
    protected double height;

    public Shape(double upperLeftX, double upperLeftY, double width, double height) {
        this.upperLeftX = upperLeftX;
        this.upperLeftY = upperLeftY;
        this.width = width;
        this.height = height;
    }

    public abstract double getX();

    public abstract double getY();
}
