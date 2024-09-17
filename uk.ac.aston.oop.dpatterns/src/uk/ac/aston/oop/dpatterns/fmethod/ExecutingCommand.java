package uk.ac.aston.oop.dpatterns.fmethod;

public class ExecutingCommandReader extends AbstractCommandReader {
    private int x = 0;
    private int y = 0;

    @Override
    protected Command createCommand(String input) {

        String[] parts = input.split(",");
        int dx = Integer.parseInt(parts[0]);
        int dy = Integer.parseInt(parts[1]);
        return createMovementCommand(dx, dy);
    }

    protected Command createMovementCommand(int dx, int dy) {
        return new Command() {
            @Override
            public void run() {
                x += dx;
                y += dy;
                System.out.println("New position: (" + x + ", " + y + ")");
            }
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
