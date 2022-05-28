package A;
import java.util.Scanner;

public class UserInterface {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Simulator playlist = new Simulator();
        while (true) {
            String input = scanner.nextLine();
            String[] params = input.split(" ");
            String QUIT = "quit";
            if (params[0].equals(QUIT)) {
                break;
            }
            switch (params[0]) {
                case "add":
                    params = params[1].split(":");
                    playlist.add(Integer.parseInt(params[0]), params[1], params[2],
                            Integer.parseInt(params[3]), Integer.parseInt(params[4]));
                    break;
                case "remove":
                    System.out.print(playlist.remove(Integer.parseInt(params[1]), true));
                    break;
                case "play":
                    playlist.play(Integer.parseInt(params[1]));
                    break;
                case "skip":
                    playlist.skip();
                    break;
                case "peek":
                    System.out.print(playlist.peek());
                    break;
                case "list":
                    System.out.print(playlist.list());
                    break;
                case "history":
                    System.out.print(playlist.history());
                    break;
            }
        }
        scanner.close();
    }
}
