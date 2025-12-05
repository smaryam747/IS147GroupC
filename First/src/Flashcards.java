/**
 * The Flashcard class that holds all methods necessary to run the Flashcard game in the program.
 */
public class Flashcards extends Game{
    private static int NumofCards;
    private static String[][] deck;
    private static Boolean continueGame = true;
    private static int correctStreakBack;
    private static int correctAmtBack;
    private static int correctStreakFront;
    private static int correctAmtFront;

    /**
     * Method in all Gametype files to run all methods involved with the game's operation.
     */
    @Override
    public void RunGame() {
         // give directions and ask for the amount of rows in deck array
        intro();

        //have the user input the indices of deck
        makeDeck();

        //prints the current deck
        displayDeck();

        //run the main switch until the user exits this game
        while (continueGame) {
            menu1();
        }
    }

    /**
     * Method to give directions to the user and ask for the amount of rows in deck array.
     */
    @Override
    public void intro() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("This is the Flashcard game!\n  Directions: First enter the number of cards you're making and then enter the front & back sides of each card.\n  Then you can choose to practice the backs of your cards, where you are given the front and must answer with the back or practice the fronts.\n  Try to get the best Correct Streak!");
        System.out.println("---------------------------------------------------------------");
        System.out.println("To start, please enter the number of flashcards you're making below (enter a digit):");
        NumofCards = super.sc.nextShort();
        deck = new String[NumofCards][2];
        sc.nextLine();
    }

    /**
     * method to have the user input data for all deck array inputs.
     */
    private void makeDeck() {
        System.out.println("Now please enter the front and back of each card.");
        for(int i = 0; i < NumofCards; i++){
            System.out.println("Enter the front of card number " + (i + 1) + ": ");
            deck[i][0] = super.sc.nextLine();

            System.out.println("Enter the back of card number " + (i + 1) + ": ");
            deck[i][1] = super.sc.nextLine();
        }
    }

    /**
     * A method to print the current deck.
     */
    private static void displayDeck() {
        for(int i = 0; i < NumofCards; i++){
            System.out.println("Card num. " + (i + 1) + ": Front: " + deck[i][0] + " | Back: " + deck[i][1]);
        }
    }

    /**
     * The Method that displays the options for the Flashcards section of the program.
     */
    public void menu1() {
        System.out.println("\nWhat would you like to do now? (type a or b or c, etc.)\na. Practice Backs\nb. Practice Fronts\nc. Edit a card\nd. Display deck\ne. Remake deck\nf. Exit game");
        String reply = sc.nextLine();
        String replyLow = reply.toLowerCase();
        menu1switch(replyLow);
    }

    /**
     * Method to contain the switch statement of the menu1 method.
     * @param replyLow all lowercase reply from user to decide which method to execute next.
     */
    public void menu1switch(String replyLow){
        switch (replyLow) {
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

    /**
     * method to print the 1st column (front of flashcard) and have the user type the 2nd column (back of flashcard).
     */
    private void practiceBacks(){
        System.out.println("In this you will practice the backs of your flashcards. You will be given the front and asked to type the back verbatim.\n");
        for(int i = 0; i < NumofCards; i++){
            System.out.println("Front of card " + (i + 1) + ": " + deck[i][0]);
            System.out.println("What is the back? (enter it below)");
            String back = super.sc.nextLine();
            String backLow = back.toLowerCase();
                if(backLow.equals(deck[i][1].toLowerCase())){
                    System.out.println("Correct!");
                    correctStreakBack = Math.incrementExact(correctStreakBack) ;
                    correctAmtBack = Math.incrementExact(correctAmtBack);
                } else {
                    System.out.println("Incorrect, the correct answer was: "+ deck[i][1]);
                    correctStreakBack = 0;
                }
            System.out.println("Your current correct streak for the backs is " + correctStreakBack + " in a row!");
            System.out.println("Your total amount correct for the backs is " + correctAmtBack + " correct!\n");
        }
    }

    /**
     * method to print the 2nd column (back of flashcard) and have the user type the 1st column (front of flashcard).
     */
    private void practiceFronts(){
        System.out.println("In this you will practice the fronts of your flashcards. You will be given the back and asked to type the front verbatim.\n");
        for(int i = 0; i < NumofCards; i++){
            System.out.println("Back of card " + (i + 1) + ": " + deck[i][1]);
            System.out.println("What is the front? (enter it below)");
            String front = super.sc.nextLine();
            String frontLow = front.toLowerCase();
            if(frontLow.equals(deck[i][0].toLowerCase())){
                System.out.println("Correct!");
                correctStreakFront = Math.incrementExact(correctStreakFront) ;
                correctAmtFront = Math.incrementExact(correctAmtFront);
            } else {
                System.out.println("Incorrect, the correct answer was: "+ deck[i][1]);
                correctStreakFront = 0;
            }
            System.out.println("Your current correct streak for the fronts is " + correctStreakFront + " in a row!");
            System.out.println("Your total amount correct for the fronts is " + correctAmtFront + " correct!\n");
        }
    }

    /**
     * A method to edit index of deck[], user picks the row then chooses the front or back (column 0 or 1).
     */
    private void editDeck(){
        int columnNum = 3;
        int row;
        String colWrite = "";

            System.out.println("Enter the card number you wish to edit (enter a digit): ");
            row = super.sc.nextInt();
            super.sc.nextLine();
            System.out.println("Do you wish to change the front or back? (Type front or back):");
            String column = super.sc.nextLine();
            String colLow = column.toLowerCase();

            if (colLow.equals("front")) {
                columnNum = 0;
                colWrite = "front";
            } else if (colLow.equals("back")) {
                columnNum = 1;
                colWrite = "back";
            } else System.out.println("Invalid answer, please retry.");

            System.out.println("Enter the new " + colWrite + " of card " + row + ": ");
            String reply = sc.nextLine();
            deck[(row - 1)][columnNum] = reply;
            System.out.println("Here is the fix:\nCard num. " + (row - 1) + ": Front: " + deck[(row - 1)][0] + "| Back: " + deck[(row - 1)][1]);

    }

    /**
     * A method to end the use of the Flashcard class and move back to the main switch.
     */
    public void makeExitFlash(){
        System.out.println("Are you sure you want to stop using your flashcards? You'll have to remake them if you leave! (yes/no)");
        String ans = super.sc.nextLine();
        String ansIn = ans.toLowerCase();
        if (ansIn.equals("yes")) {
            System.out.println("Okay, returning to main page!");
            continueGame = false;
        } else {
            System.out.println("Continuing game...");
        }
    }

    /**
     * Returns the total amount of correct answers the user got in the Flashcards game.
     * This method is overloading with the getter for the 2 correctAmt variables, if a string is inputted it gives the total correctAmt, if an int is inputted it returns it.
     */
    public int getCorrectAmt(String t){
        return getCorrectAmt(correctAmtBack) + getCorrectAmt(correctAmtFront);
    }

    public int getCorrectAmt(int amt){
        return amt;
    }
}