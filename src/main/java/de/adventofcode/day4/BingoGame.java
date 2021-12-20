package de.adventofcode.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BingoGame {

    private List<Board> boards = new ArrayList<>();

    private Board lastWinner;

    public void addBoard(final int[][] board) {
        boards.add(new Board(board));
    }

    public void drawNumber(int number) {
        if (hasOpenBoard()) {
            if (getOpenBoards().size() == 1)
                lastWinner = getOpenBoards().stream().findFirst().orElse(null);

            boards.forEach(board -> board.drawNumber(number));
        }
    }

    public void drawNumbers(int... numbers) {
        for (int number : numbers)
            drawNumber(number);
    }

    public int getLastWinnerScore() {
        if (lastWinner != null && lastWinner.hasWon())
            return lastWinner.getScore();

        throw new IllegalArgumentException();
    }

    public boolean hasOpenBoard() {
        return !getOpenBoards().isEmpty();
    }

    private List<Board> getOpenBoards() {
        return boards.stream().filter(board -> !board.hasWon()).collect(Collectors.toList());
    }
}
