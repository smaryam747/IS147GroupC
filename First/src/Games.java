import java.util.*;
public class Games {
    public static Scanner sc = new Scanner(System.in);
    public static Random rn = new Random();

    //method for truth or dare game
    public static void truthOrDare() {
        //assign truth and dare arrays to hold questions
        String[] truth = {"How old are you?", "What's something you never told your mom?", "Whats an embarrasing secret you have?", "What was your middle school phase?"};
        String[] dare = {"Do 15 push-ups!", "Say the alphabet backwards in a minute!", "Spin around for 20 seconds and walk in a straight line!", "Let your friend text one of your contacts!"};

        //t or d prompt, take input for switch
        System.out.println("This is Truth or Dare!\nWe'll give you prompts to play with your friends, if you get a repeat just retry!\n---------------------------------------");

        String replyLow;
        do {
            System.out.println("So, Truth or Dare? (When you're done type done.)");
            String uIn = sc.nextLine();
            String uInLow = uIn.toLowerCase();

            //switch statement to pick truth or dare prompt or exit (this is unfinished)
            switch (uInLow) {
                case "truth":
                    int ranNum = rn.nextInt(0, 4);
                    System.out.println(truth[ranNum]);
                    break;
                case "dare":
                    int randNum = rn.nextInt(0, 4);
                    System.out.println(dare[randNum]);
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

    public static void flashCards(){

    }
}
