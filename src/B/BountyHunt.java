package B;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BountyHunt {
    private final String pathToFile;
    private final ArrayList planetConnections;
    private final int amountOfPlanets;

    public BountyHunt(String pathToFile) throws IOException {
        this.pathToFile = pathToFile;
        this.amountOfPlanets = Integer.parseInt(textToStringArray()[0]);
        this.planetConnections = new ArrayList();
        this.createListArray();
    }

    public int getMinDroids() {
        int amountDroids = 0;
        for (int planetIndex = 0; planetIndex < amountOfPlanets; planetIndex++) {
            if(!(this.planetConnections.contains(planetIndex))) {
                amountDroids += 1;
            }
        }
        return amountDroids;
    }

    //  Helper Methods
    private void createListArray() throws IOException {
        for (int i = 1; i <= amountOfPlanets; i++) {
            this.planetConnections.addFirst(stringToIntArray(textToStringArray()[i]));
        }
    }
    private String[] textToStringArray() throws IOException {
        return Files.readAllLines(Paths.get(pathToFile)).toArray(new String[0]);

    }
    private int[] stringToIntArray(String line) {
        int[] accessiblePlanets = new int[Integer.parseInt(line.split(" ")[0])];
        for (int i = 0; i < accessiblePlanets.length; i++) {
            accessiblePlanets[i] = Integer.parseInt(line.split(" ")[i + 1]);
        }
        return accessiblePlanets;
    }
}
