package Guessing_Game;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GuessingGameLogicTest {

    @Test
    void guessTooLow_returnsHigher() {
        GuessingGameLogic game = new GuessingGameLogic(50, 5);
        assertEquals("Higher", game.makeGuess(25));
    }

    @Test
    void guessTooHigh_returnsLower() {
        GuessingGameLogic game = new GuessingGameLogic(50, 5);
        assertEquals("Lower", game.makeGuess(75));
    }

    @Test
    void correctGuess_setsWinState() {
        GuessingGameLogic game = new GuessingGameLogic(50, 5);
        assertEquals("Correct", game.makeGuess(50));
        assertTrue(game.isWon());
    }

    @Test
    void invalidGuess_doesNotConsumeAttempt() {
        GuessingGameLogic game = new GuessingGameLogic(50, 5);
        game.makeGuess(150);
        assertEquals(0, game.getAttempts());
    }

    @Test
    void gameEndsAfterMaxAttempts() {
        GuessingGameLogic game = new GuessingGameLogic(50, 2);
        game.makeGuess(10);
        game.makeGuess(20);
        assertFalse(game.hasAttemptsRemaining());
    }
}

