package uk.ac.aston.oop.dpatterns.singleton;

public class Player {
    private final int dieFaces; // Number of faces on the player's die

    /**
     * Constructs a Player object with a specified number of die faces.
     *
     * @param 
     */
    public Player(int dieFaceCount) {
        if (dieFaceCount <= 0) {
            throw new IllegalArgumentException("Number of die faces must be greater than zero.");
        }
        this.dieFaces = dieFaceCount;
    }

    /**
     * Rolls the die associated with this player using the DiceRoller singleton.
     * This method retrieves the singleton instance of DiceRoller and uses it to roll a die
     * with the number of faces specified in this Player instance.
     *
     * @return The result of the die roll, a value between 1 and the number of die faces.
     */
    public int roll() {
        DiceRoller diceRoller = DiceRoller.getInstance(); // Access the singleton instance
        return diceRoller.roll(dieFaces); // Roll the die with the specified number of faces
    }

    /**
     * Retrieves the number of faces on the player's die.
     *
     * @return The number of die faces.
     */
    public int getDieFaces() {
        return dieFaces;
    }
}
