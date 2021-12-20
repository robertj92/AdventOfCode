package de.adventofcode.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SubmarineMovementFileReader {

    public static List<Movement> readMovementsFromFile(String fileName) throws URISyntaxException, IOException {
        Path path = Paths.get(SubmarineMovementFileReader.class.getClassLoader()
                .getResource(fileName).toURI());

        return Files.lines(path)
                .map(line -> line.split(" "))
                .map(splittedLine -> new Movement(Direction.valueOf(splittedLine[0].toUpperCase()), Integer.parseInt(splittedLine[1])))
                .collect(Collectors.toList());
    }
}
