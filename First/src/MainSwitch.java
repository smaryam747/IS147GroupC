import java.util.*;
public class MainSwitch {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        //loop the main sequence to run until user quits (also not completely working)
        while(true) {
            firstSwitch();
        }
    }

    public static void firstSwitch(){
        //output game choices
        System.out.println("Welcome to the game program! What would you like to play?\na.Truth or Dare\nb.Study Check\nc.Trivia\nd.Exit");
            String c = sc.nextLine();
            String cLow = c.toLowerCase();

            //pick which game to play
            switch (cLow) {
                case "a", "a.":
                    Games.truthOrDare();
                    break;
                case "b", "b.":
                    Games.flashCards();
                    break;
                case "c", "c.":
                    break;
                case "d", "d.":
                    makeExit();
                    break;
                default:
                    System.out.println("This error occurred.");
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
            System.out.println("Re-running program...");
        }
    }


}
