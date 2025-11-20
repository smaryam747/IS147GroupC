import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static String neatDate;

    public static void main(String[] args){
        //gathers and formats the date to put into the intro prompt
        dateFormat();
        //loop the main sequence to run until user quits
        while(true) {
            mainSwitch();
        }
    }

    //initiates the game prompt
    public static void mainSwitch(){
        String cLow = introPrompt();
        gameSelect(cLow);
    }

    public static void dateFormat(){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        neatDate = LocalDateTime.now().format(formatDate);
    }


    private static String introPrompt() {
        //output game choices
        System.out.println("\nWelcome to the game program! It is currently " + neatDate + "\nWhat would you like to play? (type a or b or c, etc.)\na. Truth or Dare\nb. Flashcards\nc. Number Guessing Game\nd. Exit");
        String c = sc.nextLine();
        return c.toLowerCase();
    }

    private static void gameSelect(String cLow) {
        //pick which game to play
        switch (cLow) {
            case "a", "a.":
                TorD.truthOrDare();
                break;
            case "b", "b.":
                Flashcards.flashCards();
                break;
            case "c", "c.":
                break;
            case "d", "d.":
                makeExit();
                break;
            default:
                System.out.println("An error occurred.");
                break;
        }
    }

    //method to end program
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
