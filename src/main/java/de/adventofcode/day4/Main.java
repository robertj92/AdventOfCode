package de.adventofcode.day4;

import de.adventofcode.day2.SubmarineMovementFileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {

        final BingoGame bingoGame = new BingoGame();
        BingoFileReader.readBoardsFromFile("day4/submarine_bingo_input.txt")
                .forEach(bingoGame::addBoard);
        BingoFileReader.readNumberDrawingsFromFile("day4/submarine_bingo_input.txt")
                .forEach(bingoGame::drawNumber);

        System.out.println("Bingo has open board: " + bingoGame.hasOpenBoard());
        System.out.println("Bingo winner score: " + bingoGame.getLastWinnerScore());
    }
}
