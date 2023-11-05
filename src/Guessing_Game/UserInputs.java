package Guessing_Game;

import java.util.Random;
import java.util.Scanner;

public class UserInputs {
	
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
        int theRandomNumber = random.nextInt(100) + 1;
        int attempts = 5;
        
        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I've chosen a random number between 1 and 100. You have 5 attempts to guess it.");
        
        while(attempts > 0) {
        	System.out.print("Pick a number between 1 and 100: ");
        	int guess;
        	
        	try {
        		guess = Integer.parseInt(scanner.nextLine());
        	}catch(NumberFormatException e) {
        		System.out.println("Invalid input. Please enter a valid integer.");
        		continue;
        	}
        	 if (guess < 1 || guess > 100) {
                 System.out.println("Your guess is not between 1 and 100, please try again.");
             } else if (guess < theRandomNumber) {
                 System.out.println("Please pick a higher number");
             } else if (guess > theRandomNumber) {
                 System.out.println("Please pick a lower number");
             } else {
                 System.out.println("You win!");
                 break;
             }
        	 attempts--;
        }
        if (attempts == 0) {
            System.out.println("You lose! The number to guess was: " + theRandomNumber);
        }
        
		scanner.close();
	}

}
