import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Game TorD = new TorD();
    public static Flashcards Flashcards = new Flashcards();
    public static Player pl = new Player(Flashcards);

    /**
     * The main method that executes and loops the program.
     */
    public static void main(String[] args){

    }
    public static void RunGame(){
        Player.MakePlayer();
        //loop the main sequence to run until user quits
        while(true) {
            mainSwitch();
        }
    }

    /**
     * The method that starts the intro and main menu.
     */
    public static void mainSwitch(){
        String cLow = introPrompt();
        gameSelect(cLow);
    }

    /**
     * A method to properly format java's date into the desired pattern.
     */
    public static String dateFormat(String formatType){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(formatType);
        return LocalDateTime.now().format(formatDate);
    }

    /**
     * A method to display the prompt for the gameSelect method.
     */
    private static String introPrompt() {
        //output game choices
        System.out.printf("\nWelcome to the game program! You started the game on %s\nWhat would you like to play? (type a or b or c, etc.)\na. Truth or Dare\nb. Flashcards\nc. See your Player details\nd. Exit\n", dateFormat("E, MMM dd yyyy HH:mm:ss"));
        String c = sc.nextLine();
        return c.toLowerCase();
    }

    /**
     * This method takes the user's input into the switch statement to decide which game should start, or to display their player details.
     */
    private static void gameSelect(String cLow) {
        //pick which game to play
        switch (cLow) {
            case "a", "a.":
                TorD.RunGame();
                break;
            case "b", "b.":
                Flashcards.RunGame();
                break;
            case "c", "c.":
                pl.showPlayerDetails();
                break;
            case "d", "d.":
                makeExit();
                break;
            default:
                System.out.println("An error occurred.");
                break;
        }
    }

    /**
     * Method that ends the whole program, ensures the user wants to quit before stopping the run.
     */
    public static void makeExit(){
        System.out.println("Are you sure you want to exit? (yes/no)");
        String ans = sc.nextLine();
        String ansIn = ans.toLowerCase();
        if (ansIn.equals("yes")) {
            System.out.println("Very Well, Goodbye!");
            sc.close();
            System.exit(0);
        } else {
            System.out.println("Continuing program...");
        }
    }
}
