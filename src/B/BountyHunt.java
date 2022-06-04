package B;

/**
 * The class BountyHunt simulates the bounty hunt.
 * It contains the method to get the minimum amount of droids required to cover all planet routes
 * alongside some private helper methods.
 * @author ugpsy
 * @version 1.0
 */
public class BountyHunt {
    private final String pathToFile;
    private final ArrayList planetConnections; // An array of numbers that represent a planet.
                                               // Planets in the same array are connected through portals.
    private final int amountOfPlanets; // The size of the universe.

    /**
     * Constructor for the class.
     * Gets the size of the universe from the first line of the text input.
     */
    public BountyHunt(String pathToFile) {
        this.pathToFile = pathToFile;
        this.amountOfPlanets = Integer.parseInt(textToStringArray()[0]);
        this.planetConnections = new ArrayList();
        this.createListArray();
    }

    public int getMinDroids() {
        int amountDroids = 0; // Counter for the minimum number of droids required for the hunt.
        for (int planetIndex = 0; planetIndex < amountOfPlanets; planetIndex++) { // Go through every planet in the universe.
            if(!(this.planetConnections.contains(planetIndex))) { // Searches if there is a "portal" from any planet to the current one at the index.
                amountDroids += 1; // If the "Eingangsgrad" of the planet is zero, this means a new droid has to be sent there.
            }
        }
        return amountDroids;
    }

    //  Helper Methods

    /**
     * Converts a text line first to a String array then to an integer array and adds it to the planet connections list.
     */
    private void createListArray()  {
        for (int i = 1; i <= amountOfPlanets; i++) {
            this.planetConnections.addFirst(stringToIntArray(textToStringArray()[i]));
        }
    }

    /**
     * Converts a text line first to a String array.
     * @return A String array that contains numbers which represent planets.
     */
    private String[] textToStringArray() {
        return FileHelper.readAllLines(this.pathToFile).split("\n");

    }
    /**
     * Converts a string array to an integer array.
     * @return an array of numbers which represent planets that can be accessed from the nth planet
     * with n being the index of the array in the planetConnections list.
     */
    private int[] stringToIntArray(String line) {
        int[] accessiblePlanets = new int[Integer.parseInt(line.split(" ")[0])];
        for (int i = 0; i < accessiblePlanets.length; i++) {
            accessiblePlanets[i] = Integer.parseInt(line.split(" ")[i + 1]);
        }
        return accessiblePlanets;
    }
}
