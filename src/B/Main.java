package B;

import java.io.IOException;

/**
 * The Main Class.
 * @author ugpsy
 * @version 1.0
 */
public class Main {

    /**
     * The main method.
     */
    public static void main(String[] args) throws IOException {
        BountyHunt bountyHunt = new BountyHunt("src/B/input.txt");
        int result = bountyHunt.getMinDroids();
        System.out.println(result);
    }
}