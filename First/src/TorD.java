import java.util.Random;
import java.util.Scanner;

public class TorD {
    public static Scanner sc = new Scanner(System.in);
    public static Random rn = new Random();
    static String uInLow;
    static String[] truth = {"How old are you?", "What's something you never told your mom?", "Whats an embarrasing secret you have?", "What was your middle school phase?"};
    static String[] dare = {"Do 15 push-ups!", "Say the alphabet backwards in a minute!", "Spin around for 20 seconds and walk in a straight line!", "Let your friend text one of your contacts!"};

    /**
     * A method that runs the truth or dare game
     */
    public static void truthOrDare() {
        //t or d prompt, take input for switch
        System.out.println("This is Truth or Dare!\nWe'll give you prompts to play with your friends, if you get a repeat just retry!\n---------------------------------------");
        String replyLow;
        do {
            System.out.println("So, Truth or Dare? (When you're done type done.)");
            String uIn = sc.nextLine();
            uInLow = uIn.toLowerCase();

            //switch statement to pick a truth or dare prompt or exit
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
            System.out.println("Do you want to go again? (yes to continue)");
            String reply = sc.nextLine();
            replyLow = reply.toLowerCase();
        } while (replyLow.equals("yes") || replyLow.equals("y"));
    }

    /**
     * Method that produces a random prompt from the selection of the truth array or dare array
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
