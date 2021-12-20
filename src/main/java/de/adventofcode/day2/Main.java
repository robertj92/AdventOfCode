package de.adventofcode.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        final Submarine submarine = new Submarine();
        final List<Movement> movements = SubmarineMovementFileReader.readMovementsFromFile("submarine_input.txt");
        movements.forEach(submarine::move);
        System.out.println("Total Movement is " + submarine.getTotalMovement());
    }

    private static Stream<String> getLinesStreamFromFile(final String fileName) throws URISyntaxException, IOException {
        Path path = Paths.get(SubmarineMovementFileReader.class.getClassLoader()
                .getResource(fileName).toURI());

        return Files.lines(path);
    }
}
