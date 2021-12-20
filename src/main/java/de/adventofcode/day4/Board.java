package de.adventofcode.day4;

import java.util.Arrays;

public class Board {

    private static final int BOARD_SIZE = 5;

    private int[][] board;
    private boolean[][] boardMarkers;

    private int lastDrawnNumber;

    public Board(final int[][] board) {
        validateSize(board);

        this.board = board;
        initializeBoardMarkers();
    }

    public void drawNumber(int number) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == number)
                    boardMarkers[i][j] = true;
            }
        }

        lastDrawnNumber = number;
    }

    public boolean hasWon() {
        return hasCompletedColumn() || hasCompletedRow();
    }

    private void initializeBoardMarkers() {
        this.boardMarkers = new boolean[BOARD_SIZE][BOARD_SIZE];

        for (boolean[] row : boardMarkers) {
            Arrays.fill(row, false);
        }
    }

    private void validateSize(int[][] board) {
        if (board.length != BOARD_SIZE)
            throw new IllegalArgumentException();

        for (int[] row : board)
            if (row.length != BOARD_SIZE)
                throw new IllegalArgumentException();
    }

    private boolean hasCompletedRow() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            boolean onlyHasMarkedFields = true;

            for (int j = 0; j < BOARD_SIZE; j++) {
                if (!boardMarkers[i][j]) {
                    onlyHasMarkedFields = false;
                    break;
                }
            }

            if (onlyHasMarkedFields)
                return true;
        }

        return false;
    }

    private boolean hasCompletedColumn() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            boolean onlyHasMarkedFields = true;

            for (int j = 0; j < BOARD_SIZE; j++) {
                if (!boardMarkers[j][i]) {
                    onlyHasMarkedFields = false;
                    break;
                }
            }

            if (onlyHasMarkedFields)
                return true;
        }

        return false;
    }

    public int getScore() {
        int sum = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (!boardMarkers[i][j])
                    sum += board[i][j];
            }
        }

        return lastDrawnNumber * sum;
    }
}
