package de.adventofcode.day4;

import de.adventofcode.day4.BingoGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BingoTest {

    private BingoGame bingoGame = new BingoGame();

    @Test
    void testCreateBingo() {
        final int[][] board = new int[][] {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        bingoGame.addBoard(board);
    }

    @Test
    void testThrowExceptionIfBoardHasWrongSize() {
        final int[][] board = new int[][] {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        };

        assertThrows(IllegalArgumentException.class, () -> {
            bingoGame.addBoard(board);
        });
    }

    @Test
    void testIfRoundPlayedAndRowIsCompletedBoardWins() {
        final int[][] board = new int[][] {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9}
        };

        bingoGame.addBoard(board);

        bingoGame.drawNumbers(1, 2, 3, 4);
        assertTrue(bingoGame.hasOpenBoard());

        bingoGame.drawNumber(5);
        assertFalse(bingoGame.hasOpenBoard());
    }

    @Test
    void testIfRoundPlayedAndColumnIsCompletedBoardWins() {
        final int[][] board = new int[][] {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        bingoGame.addBoard(board);

        bingoGame.drawNumber(6);
        assertTrue(bingoGame.hasOpenBoard());

        bingoGame.drawNumber(1);
        assertFalse(bingoGame.hasOpenBoard());
    }

    @Test
    void testIfGameIsNotCompletedWinnersScoreShouldThrowException() {
        final int[][] board = new int[][] {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        bingoGame.addBoard(board);

        bingoGame.drawNumber(6);
        assertTrue(bingoGame.hasOpenBoard());

        assertThrows(IllegalArgumentException.class, () -> bingoGame.getLastWinnerScore());
    }

    @Test
    void testIfGameIsCompletedBoardWinsGetWinnersScore() {
        final int[][] winnerBoard = new int[][] {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        final int[][] loserBoard = new int[][] {
                {2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6}
        };

        bingoGame.addBoard(winnerBoard);
        bingoGame.addBoard(loserBoard);

        bingoGame.drawNumber(1);
        assertTrue(bingoGame.hasOpenBoard());

        bingoGame.drawNumber(2);
        assertFalse(bingoGame.hasOpenBoard());
        assertEquals(180, bingoGame.getLastWinnerScore());
    }

    @Test
    void testIfGameIsCompletedBoardWinsGetWinnersScore2() {
        final int[][] board = new int[][] {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        bingoGame.addBoard(board);

        bingoGame.drawNumber(2);
        assertFalse(bingoGame.hasOpenBoard());
        bingoGame.drawNumber(3);
        assertEquals(130, bingoGame.getLastWinnerScore());
    }
}
