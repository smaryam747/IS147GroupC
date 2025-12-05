import java.util.Random;
import java.util.Scanner;

/**
 * The Truth or Dare class that holds all methods necessary to run the Truth or Dare game in the program.
 */
public class TorD extends Game {
    public static Scanner sc = new Scanner(System.in);
    public static Random rn = new Random();
    private static String uInLow;
    final static String[] truth = {"How old are you?", "What's something you never told your mom?", "Whats an embarrasing secret you have?", "What was your middle school phase?"};
    final static String[] dare = {"Do 15 push-ups!", "Say the alphabet backwards in a minute!", "Spin around for 20 seconds and walk in a straight line!", "Let your friend text one of your contacts!"};

    /**
     * A method that runs the truth or dare game.
     */
    @Override
    public void RunGame() {
        intro();
        menu1();
    }

    /**
     * Method that repeats the game to keep giving answers and stop when the conditions are false.
     */
    @Override
    public void menu1(){
        String replyLow;
        do {
            System.out.println("So, Truth or Dare? (When you're done type 'done'.)");
            String uIn = sc.nextLine();
            uInLow = uIn.toLowerCase();

            menu1switch();

            System.out.println("Do you want to go again? ('yes' to continue, anything else to exit)");
            String reply = sc.nextLine();
            replyLow = reply.toLowerCase();
        } while (replyLow.equals("yes") || replyLow.equals("y"));
    }

    public void intro(){
        System.out.println("This is Truth or Dare!\nWe'll give you prompts to play with your friends, if you get a repeat just retry!\n---------------------------------------");
    }

    /**
     * Method that holds the menu1 switch statement.
     */
    public void menu1switch() {
        switch (uInLow) {
            case "truth":
                outRandPrompt();
                break;
            case "dare":
                outRandPrompt();
                break;
            case "done":
                break;
            default:
                System.out.println("An error occurred.");
                break;
        }
    }

    /**
     * Method that produces a random prompt from the selection of the truth array or dare array.
     */
    public static void outRandPrompt(){
        switch(uInLow) {
            case "truth":
                int ranNum = rn.nextInt(0, truth.length);
                System.out.println(truth[ranNum]);
                break;
            case "dare":
                int ranNum2 = rn.nextInt(0, dare.length);
                System.out.println(dare[ranNum2]);
                break;
            default:
                System.out.println("an error occurred.");
                break;
        }
    }

}
