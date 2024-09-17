package uk.ac.aston.oop.inheritance.shapes;

import javafx.scene.paint.Color;
import uk.ac.aston.oop.inheritance.util.GraphicsContextWrapper;

/**
 * Represents a geometric Frame specified by its upper-left corner coordinates,
 * width, and height. It consists of an outer rectangle and an inner rectangle.
 *
 * @author Hammad Ali
 * @version 1.0
 */
public class Frame extends Shape {

    protected Rectangle outerRectangle;
    protected Rectangle innerRectangle;

    private static final int FRAME_THICKNESS = 10;

    public Frame(double ulX, double ulY, double width, double height) {
        super(ulX, ulY, width, height);

        outerRectangle = new Rectangle(ulX, ulY, width, height);
        innerRectangle = new Rectangle(ulX + FRAME_THICKNESS, ulY + FRAME_THICKNESS, width - 2 * FRAME_THICKNESS, height - 2 * FRAME_THICKNESS);
    }

    @Override
    public void draw(GraphicsContextWrapper gc) {
        outerRectangle.draw(gc);
        innerRectangle.draw(gc);
    }
}
