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
        /*
        final Submarine submarine = new Submarine();
        final List<Movement> movements = SubmarineMovementFileReader.readMovementsFromFile("submarine_input.txt");
        movements.forEach(submarine::move);
        System.out.println("Total Movement is " + submarine.getTotalMovement());

        final DiagnosticReportAnalyzer diagnosticReportAnalyzer = new DiagnosticReportAnalyzer();
        getLinesStreamFromFile("submarine_diagnostic_report_input.txt").forEach(diagnosticReportAnalyzer::addDiagnosticReportValue);

        System.out.println("Power Consumption is " + diagnosticReportAnalyzer.getPowerConsumption());
        System.out.println("Life Support Rating is " + diagnosticReportAnalyzer.getLifeSupportRating());
        */

        final BingoGame bingoGame = new BingoGame();
        BingoFileReader.readBoardsFromFile("submarine_bingo_input.txt")
                .forEach(bingoGame::addBoard);
        BingoFileReader.readNumberDrawingsFromFile("submarine_bingo_input.txt")
                .forEach(bingoGame::drawNumber);

        System.out.println("Bingo has open board: " + bingoGame.hasOpenBoard());
        System.out.println("Bingo winner score: " + bingoGame.getLastWinnerScore());
    }

    private static Stream<String> getLinesStreamFromFile(final String fileName) throws URISyntaxException, IOException {
        Path path = Paths.get(SubmarineMovementFileReader.class.getClassLoader()
                .getResource(fileName).toURI());

        return Files.lines(path);
    }
}
