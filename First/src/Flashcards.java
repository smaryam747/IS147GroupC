import java.util.Random;
import java.util.Scanner;

public class Flashcards {
    public static Scanner sc = new Scanner(System.in);
    public static Random rn = new Random();
    static int numofcards;
    static String[][] deck;
    static Boolean continueGame = true;
    static short correctStreakBack = 0;
    static short correctAmtBack = 0;
    static short correctStreakFront = 0;
    static short correctAmtFront = 0;

    
    public static void flashCards() {
        //give directions and ask for the amount of rows in deck array
        intro();

        //method to have user input values in the deck
        makeDeck();

        //prints the current deck
        displayDeck();

        //run the main switch until the user exits this game
        while (continueGame) {
            mainSwitch();
        }
    }

    //give directions and ask for the amount of rows in deck array
    private static void intro() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("This is the Flashcard game!\n  Directions: First enter the number of cards you're making and then enter the front & back sides of each card.\n  Then you can choose to practice the backs of your cards, where you are given the front and must answer with the back or practice the fronts.\n  Try to get the best Correct Streak!");
        System.out.println("---------------------------------------------------------------");
        System.out.println("To start, please enter the number of flashcards you're making below (enter a digit):");
        numofcards = sc.nextInt();
        deck = new String[numofcards][2];
        sc.nextLine();
    }

    //method to have the user input data for all deck array inputs
    private static void makeDeck() {
        System.out.println("Now please enter the front and back of each card.");
        for(int i = 0; i < numofcards; i++){
            System.out.println("Enter the front of card number " + (i + 1) + ": ");
            deck[i][0] = sc.nextLine();

            System.out.println("Enter the back of card number " + (i + 1) + ": ");
            deck[i][1] = sc.nextLine();
        }
    }

    //method to print the current deck
    private static void displayDeck() {
        for(int i = 0; i < numofcards; i++){
            System.out.println("Card num. " + (i + 1) + ": Front: " + deck[i][0] + " | Back: " + deck[i][1]);
        }
    }

    private static void mainSwitch() {
        System.out.println("\nNow that you have your cards what would you like to do? (type a or b or c, etc.)\na. Practice Backs\nb. Practice Fronts\nc. Edit a card\nd. Display deck\ne. Remake deck\nf. Exit game");
        String c = sc.nextLine();
        String cLow = c.toLowerCase();

        //pick option
        switch (cLow) {
            case "a", "a.":
                practiceBacks();
                break;
            case "b", "b.":
                practiceFronts();
                break;
            case "c", "c.":
                editDeck();
                break;
            case "d", "d.":
                displayDeck();
                break;
            case "e", "e.":
                makeDeck();
                break;
            case "f", "f.":
                makeExitFlash();
                break;
            default:
                System.out.println("An error occurred.");
                break;
        }
    }

    //method to print the 1st column and have the user type the 2nd column
    private static void practiceBacks(){
        System.out.println("In this you will practice the backs of your flashcards. You will be given the front and asked to type the back verbatim.\n");
        for(int i = 0; i < numofcards; i++){
            System.out.println("Front of card " + (i + 1) + ": " + deck[i][0]);
            System.out.println("What is the back? (enter it below)");
            String back = sc.nextLine();
            String backLow = back.toLowerCase();
                if(backLow.equals(deck[i][1])){
                    System.out.println("Correct!");
                    correctStreakBack++;
                    correctAmtBack++;
                } else {
                    System.out.println("Incorrect, the correct answer was: "+ deck[i][1]);
                    correctStreakBack = 0;
                }

            System.out.println("Your current correct streak for the backs is " + correctStreakBack + "in a row!");
            System.out.println("Your total amount correct for the backs is " + correctAmtBack + "correct!\n");
        }
    }

    //method to print the 2nd column (back of flashcard) and have the user type the 1st column (front of flashcard)
    private static void practiceFronts(){
        System.out.println("In this you will practice the fronts of your flashcards. You will be given the back and asked to type the front verbatim.\n");
        for(int i = 0; i < numofcards; i++){
            System.out.println("Back of card " + (i + 1) + ": " + deck[i][1]);
            System.out.println("What is the front? (enter it below)");
            String front = sc.nextLine();
            String frontLow = front.toLowerCase();
            if(frontLow.equals(deck[i][0])){
                System.out.println("Correct!");
                correctStreakFront++;
                correctAmtFront++;
            } else {
                System.out.println("Incorrect, the correct answer was: "+ deck[i][1]);
                correctStreakFront = 0;
            }
            System.out.println("Your current correct streak for the fronts is " + correctStreakFront + " in a row!");
            System.out.println("Your total amount correct for the fronts is " + correctAmtFront + " correct!\n");
        }
    }

    //method to edit one row/flashcard choosing the front or back
    private static void editDeck(){
        int columnNum = 3;
        int row;
        System.out.println("Enter the card number you wish to edit: ");
        row = sc.nextInt();
        sc.nextLine();
        System.out.println("Do you wish to change the front or back?");
        String column = sc.nextLine();
        String colLow = column.toLowerCase();
            if(colLow.equals("front")){
                columnNum = 0;
            } else if(colLow.equals("back")){
                columnNum = 1;
            }
        System.out.println("Enter the new " + colLow + " of card " + row + ": ");
        String reply = sc.nextLine();
        deck[(row - 1)][columnNum] = reply;
        System.out.println("Here is the fix:\nCard num. " + (row - 1) + ": Front: " + deck[(row - 1)][0] + "| Back: " + deck[(row - 1)][1]);
    }

    //method to end program
    public static void makeExitFlash(){
        System.out.println("Are you sure you want to stop using your flashcards? (yes/no)");
        String ans = sc.nextLine();
        String ansIn = ans.toLowerCase();
        if (ansIn.equals("yes")) {
            System.out.println("Okay, returning to main page!");
            continueGame = false;
        } else {
            System.out.println("Continuing game...");
        }
    }
}