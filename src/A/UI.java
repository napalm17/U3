package A;

import java.util.Scanner;

public class UI {
    private final String QUIT = "quit";
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            Playlist playlist = new Playlist();
            String input = scanner.nextLine();
            String[] params = input.split(" ");
            if (params[0].equals(QUIT)) {
                break;
            }
            switch (params[0]) {
                case "add":
                    playlist.add(Integer.parseInt(params[1]), params[2], params[3],
                            Integer.parseInt(params[4]), Integer.parseInt(params[5]));
                    break;
                case "remove":
                    playlist.remove(Integer.parseInt(params[1]));
                    break;
                case "play":
                    playlist.play(Integer.parseInt(params[1]));
                    break;
                case "skip":
                    playlist.skip();
                    break;
                case "peek":
                    playlist.peek();
                    break;
                case "list":
                    playlist.list();
                    break;
                case "history":
                    playlist.history();
                    break;
            }
        }
        scanner.close();
    }
}
