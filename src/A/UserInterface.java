package A;
import java.util.Scanner;

/**
 * This class helps us process commands and inputs given through the command line.
 * @author ugpsy
 * @version 1.0
 */
public class UserInterface {

    /**
     * This method runs the user-interface for the playlist app on the command line.
     * Used a switch case to determine which method to run depending on the given command.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Simulator playlist = new Simulator();
        while (true) {
            String input = scanner.nextLine();
            String[] params = input.split(" ");
            String QUIT = "quit";
            // A.1.2.8 The while halts if the command is quit and the program ends.
            if (params[0].equals(QUIT)) {
                break;
            }
            switch (params[0]) {
                case "add": // A.1.2.1
                    params = params[1].split(":");
                    playlist.add(Integer.parseInt(params[0]), params[1], params[2],
                            Integer.parseInt(params[3]), Integer.parseInt(params[4]));
                    break;
                case "remove": // A.1.2.2
                    System.out.print(playlist.remove(Integer.parseInt(params[1]), true));
                    break;
                case "play": // A.1.2.3
                    playlist.play(Integer.parseInt(params[1]));
                    break;
                case "skip": // A.1.2.4
                    playlist.skip();
                    break;
                case "peek": // A.1.2.5
                    System.out.print(playlist.peek());
                    break;
                case "list": // A.1.2.6
                    System.out.print(playlist.list());
                    break;
                case "history": // A.1.2.7
                    System.out.print(playlist.history());
                    break;
            }
        }
        scanner.close();
    }
}
