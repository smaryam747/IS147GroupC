import java.util.Random;
import java.util.Scanner;

public class NumGuess extends Player {
    Scanner sc = new Scanner(System.in);
    public static Random rn = new Random();

    public static void intro(){
        System.out.println("Welcome to the Number Guessing game!\nYou must guess 3 numbers within a given range and will gain a score based on how many you get right!");
    }

}
