package B;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BountyHunt bountyHunt = new BountyHunt("src/B/input.txt");
        int result = bountyHunt.getMinDroids();
        System.out.println(result);
    }
}