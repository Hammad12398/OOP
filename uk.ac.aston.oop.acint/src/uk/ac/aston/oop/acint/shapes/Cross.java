package uk.ac.aston.oop.acint.shapes;

import uk.ac.aston.oop.acint.util.GraphicsContextWrapper;

public class Cross implements Drawable {

    protected static final int SIZE = 20;
    private double centerX;
    private double centerY;

    public Cross(double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void draw(GraphicsContextWrapper gcw) {
        double halfSize = SIZE / 2.0;
        double startX1 = centerX - halfSize;
        double startY1 = centerY - halfSize;
        double endX1 = centerX + halfSize;
        double endY1 = centerY + halfSize;
        double startX2 = centerX + halfSize;
        double startY2 = centerY - halfSize;
        double endX2 = centerX - halfSize;
        double endY2 = centerY + halfSize;

        // Drawing the lines of the cross
        gcw.newLine(startX1, startY1, endX1, endY1);
        gcw.newLine(startX2, startY2, endX2, endY2);
    }

    @Override
    public void move(GraphicsContextWrapper gcw, double dx, double dy) {
        centerX += dx;
        centerY += dy;

        // Clipping the center position
        double maxX = gcw.width() - SIZE / 2.0;
        double maxY = gcw.height() - SIZE / 2.0;

        if (centerX < SIZE / 2.0) {
            centerX = SIZE / 2.0;
        } else if (centerX > maxX) {
            centerX = maxX;
        }

        if (centerY < SIZE / 2.0) {
            centerY = SIZE / 2.0;
        } else if (centerY > maxY) {
            centerY = maxY;
        }
    }
}
