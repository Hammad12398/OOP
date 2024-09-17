package uk.ac.aston.oop.dpatterns.singleton;

import java.util.Random;

public class DiceRoller {
    private static DiceRoller instance;
    private static long seed = -1; 
    private final Random random;

    private DiceRoller() {
        
        this.random = (seed != -1) ? new Random(seed) : new Random();
    }

    public static synchronized void setSeed(long newSeed) {
        if (instance != null) {
            System.err.println("Instance already created, can't set seed now.");
        } else {
            seed = newSeed;
        }
    }

    public static synchronized DiceRoller getInstance() {
        if (instance == null) {
            instance = new DiceRoller();
        }
        return instance;
    }

    public int roll(int diceSides) {
        if (diceSides <= 0) {
            throw new IllegalArgumentException("Dice sides must be positive.");
        }
        return random.nextInt(diceSides) + 1;
    }
}
