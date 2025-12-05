import java.util.Scanner;

/**
 * The Player class holds the Player's data and the methods used to create/gather them.
 */
public class Player {
    public static Scanner sc = new Scanner(System.in);
    public static Flashcards fl = new Flashcards();
    public static Player pl = new Player(fl);
    private String playerName;
    final int flashScore;

    /**
     * Method that asks the user to set their name.
     */
    public static void MakePlayer(){
        System.out.println("Hello new player! Please enter your name:");
        String newplName = sc.nextLine();
        pl.setPlayerName(newplName);
        if (newplName.equals("Khalil Lovett")) {
            System.out.println("Hey you made this!");
        }
    }

    /**
     * Method that prints the Player's details: Name & total flashcard score.
     */
    public void showPlayerDetails(){
        System.out.println("Here are your player details:\nPlayer Name: " + pl.getPlayerName() + "\nFlashcards Total Score: " + pl.getFlashScore());
    }

    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String newPlayerName){
        playerName = newPlayerName;
    }

    public int getFlashScore(){
        return fl.getCorrectAmt("t");
    }

    /**
     * The Player constructor; it sets the total Flashcard game score.
     */
    public Player(Flashcards f){
        fl = f;
        this.flashScore = fl.getCorrectAmt("t");
    }

}
