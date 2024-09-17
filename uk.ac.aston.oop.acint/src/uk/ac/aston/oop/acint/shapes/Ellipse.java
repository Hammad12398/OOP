package uk.ac.aston.oop.acint.shapes;

import uk.ac.aston.oop.acint.util.GraphicsContextWrapper;

public class Ellipse extends Shape {

    private double centerX;
    private double centerY;
    private double radiusX;
    private double radiusY;

    public Ellipse(double centerX, double centerY, double radiusX, double radiusY) {
        super(centerX - radiusX, centerY - radiusY, radiusX * 2, radiusY * 2);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
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
        gcw.fillOval(centerX - radiusX, centerY - radiusY, radiusX * 2, radiusY * 2);
    }

