package uk.ac.aston.oop.dpatterns.fmethod;
import uk.ac.aston.oop.dpatterns.fmethod.Command;

public class ExecutingCommandReader extends AbstractCommandReader {
    private int x = 0;
    private int y = 0;

    @Override
    protected Command createCommand(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Input must contain two integers separated by a space.");
        }
        int dx = Integer.parseInt(parts[0]);
        int dy = Integer.parseInt(parts[1]);

        return createMovementCommand(dx, dy);
    }

    public Command createMovementCommand(int dx, int dy) {
        return () -> {
            x += dx;
            y += dy;
            System.out.println("Moved to (" + x + ", " + y + ")");
        };
    }

   
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
