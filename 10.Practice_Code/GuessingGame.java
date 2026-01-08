import java.io.*;
import java.util.*;

public class GuessingGame
{
    public static void main(String[] args)
    {
        //Create a number guessing Game
        //Secreate number=42(hardcode)
        //user get max 5 attempts
        //Give hints : "Too High " or :To Low
        //if guessts print attempt taken
        Scanner sc = new Scanner(System.in);
        int secretNumber = 42;
        int maxAttempts = 5;
        int attempts = 0;
        boolean guessed = false;
        
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I have a number between 1 and 100. Can you guess it?");
        System.out.println("You have " + maxAttempts + " attempts.");
        
        while (attempts < maxAttempts && !guessed) {
            System.out.print("\nEnter your guess: ");
            int guess = sc.nextInt();
            attempts++;
            
            if (guess == secretNumber) {
            guessed = true;
            System.out.println("Congratulations! You guessed it in " + attempts + " attempts!");
            } else if (guess > secretNumber) {
            System.out.println("Too High!");
            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            } else {
            System.out.println("Too Low!");
            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }
        }
        
        //if failed, reveal Secret Number
        if (!guessed) {
            System.out.println("\nGame Over! You've used all attempts.");
            System.out.println("The secret number was: " + secretNumber);
        }
        
        sc.close();

       
    }
}