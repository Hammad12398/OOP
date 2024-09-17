package uk.ac.aston.oop.acint.shapes;

import uk.ac.aston.oop.acint.util.GraphicsContextWrapper;

public class Rectangle extends Shape {

    public Rectangle(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(GraphicsContextWrapper gcw) {
        gcw.rect(getX(), getY(), width, height);
    }

    @Override
    public void move(GraphicsContextWrapper gcw, double deltaX, double deltaY) {
        upperLeftX += deltaX;
        upperLeftY += deltaY;
    }
}
