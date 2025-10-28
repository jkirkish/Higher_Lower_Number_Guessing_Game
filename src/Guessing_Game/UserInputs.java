package Guessing_Game;

import java.util.Random;
import java.util.Scanner;

public class UserInputs {

    private static final int MAX_ATTEMPTS = 5;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = new Random().nextInt(MAX_NUMBER) + MIN_NUMBER;

        System.out.printf("🎯 Welcome to Guess the Number!%nI've chosen a number between %d and %d.%nYou have %d attempts.%n%n",
                MIN_NUMBER, MAX_NUMBER, MAX_ATTEMPTS);

        playGame(scanner, target);

        scanner.close();
    }

    private static void playGame(Scanner scanner, int target) {
        for (int attemptsLeft = MAX_ATTEMPTS; attemptsLeft > 0; attemptsLeft--) {
            int guess = getUserGuess(scanner, attemptsLeft);

            if (guess == target) {
                System.out.println("🎉 You win!");
                return;
            }

            String hint = guess < target ? "Try a higher number." : "Try a lower number.";
            System.out.println(hint);
        }

        System.out.printf("💀 You lose! The number was: %d%n", target);
    }

    private static int getUserGuess(Scanner scanner, int attemptsLeft) {
        while (true) {
            System.out.printf("Attempt %d - Enter a number between %d and %d: ",
                    MAX_ATTEMPTS - attemptsLeft + 1, MIN_NUMBER, MAX_NUMBER);

            String input = scanner.nextLine();

            try {
                int guess = Integer.parseInt(input);
                if (guess >= MIN_NUMBER && guess <= MAX_NUMBER) {
                    return guess;
                }
                System.out.printf("⚠️ Please enter a number between %d and %d.%n", MIN_NUMBER, MAX_NUMBER);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input. Please enter a valid integer.");
            }
        }
    }
}
