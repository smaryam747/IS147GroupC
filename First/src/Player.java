import java.util.*;
public class Player {
    public static Scanner sc = new Scanner(System.in);
    public static Random rn = new Random();
    private String playerName;
    private int triviaScore;
    private int guessScore;

    public static void main(String[] args){

    }

    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String newPlayerName){
        playerName = newPlayerName;
    }


}
