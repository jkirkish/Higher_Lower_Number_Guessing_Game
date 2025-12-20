package Guessing_Game;

public class GuessingGameLogic {

    private final int targetNumber;
    private int attempts;
    private final int maxAttempts;
    private boolean isWon;

    public GuessingGameLogic(int targetNumber, int maxAttempts) {
        this.targetNumber = targetNumber;
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
        this.isWon = false;
    }

    public String makeGuess(int guess) {
        if (guess < 1 || guess > 100) {
            return "Invalid";
        }

        attempts++;

        if (guess == targetNumber) {
            isWon = true;
            return "Correct";
        } else if (guess < targetNumber) {
            return "Higher";
        } else {
            return "Lower";
        }
    }

    public boolean hasAttemptsRemaining() {
        return attempts < maxAttempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isWon() {
        return isWon;
    }

    public int getTargetNumber() {
        return targetNumber;
    }
}
