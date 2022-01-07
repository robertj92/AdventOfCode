package de.adventofcode.day8;

import de.adventofcode.day5.HydrothermalVentLineParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {

        Path path = Paths.get(HydrothermalVentLineParser.class.getClassLoader()
                .getResource("day8/input.txt").toURI());

        final List<String> inputs = Files.lines(path).collect(Collectors.toList());

        System.out.println("Number of digits is " + DigitCounter.calculateDigitSum(inputs));
    }
}
