package B;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BountyHunt bh = new BountyHunt("src/input.txt");
        int result = bh.getMinDroids();
        System.out.println(result);
    }
}