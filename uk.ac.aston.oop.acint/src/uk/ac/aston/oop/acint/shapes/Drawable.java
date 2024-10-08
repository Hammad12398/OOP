package uk.ac.aston.oop.acint.shapes;

import uk.ac.aston.oop.acint.util.GraphicsContextWrapper;

public interface Drawable {
    void draw(GraphicsContextWrapper gcw);
    double getX();
    double getY();
    void move(GraphicsContextWrapper gcw, double dx, double dy);
}
