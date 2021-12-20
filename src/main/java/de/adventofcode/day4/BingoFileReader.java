package de.adventofcode.day4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BingoFileReader {

    public static List<Integer> readNumberDrawingsFromFile(final String fileName) throws IOException, URISyntaxException {
        return Arrays.stream(getLinesStreamFromFile(fileName)
                .findFirst()
                .get().split(","))
                .map(line -> line.split(","))
                .flatMap(numbers -> Arrays.stream(numbers).map(Integer::parseInt))
                .collect(Collectors.toList());
    }

    public static List<int[][]> readBoardsFromFile(final String fileName) throws IOException, URISyntaxException {
        final List<String> boardRows = getLinesStreamFromFile(fileName)
                .skip(1)
                .filter(line -> !line.isEmpty())
                .collect(Collectors.toList());

        final List<int[][]> boards = new ArrayList<>();

        int[][] board = new int[5][5];
        int boardRow = 0;
        for (int i = 0; i < boardRows.size(); i++) {

            if (i % 5 == 0) {
                boards.add(board);
                board = new int[5][5];
                boardRow = 0;
            }

            final List<String> numbers = Arrays.stream(boardRows.get(i).split(" "))
                    .filter(number -> !number.isEmpty())
                    .collect(Collectors.toList());

            for (int j = 0; j < numbers.size(); j++) {
                board[boardRow][j] = Integer.parseInt(numbers.get(j));
            }

            boardRow++;
        }

        return boards;
    }

    private static Stream<String> getLinesStreamFromFile(final String fileName) throws URISyntaxException, IOException {
        Path path = Paths.get(BingoFileReader.class.getClassLoader()
                .getResource(fileName).toURI());

        return Files.lines(path);
    }
}
