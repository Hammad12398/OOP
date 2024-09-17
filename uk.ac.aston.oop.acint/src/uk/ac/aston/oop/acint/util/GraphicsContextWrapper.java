package uk.ac.aston.oop.acint.util;
import uk.ac.aston.oop.acint.util.GraphicsContextWrapper;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GraphicsContextWrapper {

    private GraphicsContext gc;

    public GraphicsContextWrapper(GraphicsContext gc) {
        this.gc = gc;
    }

    public void oval(double x, double y, double w, double h) {
        gc.strokeOval(x, y, w, h);
    }

    public void fill(Color fill) {
        gc.setFill(fill);
    }

    public void fillRect(double x, double y, double w, double h) {
        gc.fillRect(x, y, w, h);
    }

    public void lineWidth(int lw) {
        gc.setLineWidth(lw);
    }

    public void rect(double x, double y, double w, double h) {
        gc.strokeRect(x, y, w, h);
    }

    public void line(double fromX, double fromY, double toX, double toY) {
        gc.beginPath();
        gc.moveTo(fromX, fromY);
        gc.lineTo(toX, toY);
        gc.stroke();
    }

    public double width() {
        return gc.getCanvas().getWidth();
    }

    public double height() {
        return gc.getCanvas().getHeight();
    }

    public void newLine(double startX, double startY, double endX, double endY) {
        gc.beginPath();
        gc.moveTo(startX, startY);
        gc.lineTo(endX, endY);
        gc.stroke();
    }

    public void fillCircle(double centerX, double centerY, double radius) {
        gc.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
    }
}
