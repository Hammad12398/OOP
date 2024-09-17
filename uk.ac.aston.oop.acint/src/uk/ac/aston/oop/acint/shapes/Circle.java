// Circle class
package uk.ac.aston.oop.acint.shapes;

import uk.ac.aston.oop.acint.util.GraphicsContextWrapper;

public class Circle extends Shape {

    private double centerX;
    private double centerY;
    private double radius;

    public Circle(double centerX, double centerY, double radius) {
        super(centerX - radius, centerY - radius, radius * 2, radius * 2);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    public void move(GraphicsContextWrapper gcw, double dx, double dy) {
        centerX += dx;
        centerY += dy;
        upperLeftX += dx;
        upperLeftY += dy;
    }

    @Override
    public void draw(GraphicsContextWrapper gcw) {
        gcw.fillCircle(centerX, centerY, radius);
    }

    public void scale(double factor) {
        radius *= factor;
        width *= factor;
        height *= factor;
    }

    // Getters and Setters
    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
