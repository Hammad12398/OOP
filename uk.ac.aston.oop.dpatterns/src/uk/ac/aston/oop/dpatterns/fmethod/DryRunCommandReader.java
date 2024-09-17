package uk.ac.aston.oop.dpatterns.fmethod;

public class DryRunCommandReader extends AbstractCommandReader {
    @Override
    protected Runnable createMovementCommand(int dx, int dy) {

        return () -> System.out.println("Simulating movement command: Move by dx=" + dx + ", dy=" + dy);
    }

        @Override
    protected Command createCommand(String input) {

        return () -> System.out.println("Simulated command for input: " + input);
    }
}
