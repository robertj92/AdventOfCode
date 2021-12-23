package de.adventofcode.day7;

import de.adventofcode.day5.HydrothermalVentLineParser;
import de.adventofcode.day6.LanternfishGrowthRateCalculator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {

        Path path = Paths.get(HydrothermalVentLineParser.class.getClassLoader()
                .getResource("day7/input.txt").toURI());

        final List<Integer> inputHorizontalPositions = Arrays.stream(Files.lines(path)
                .findFirst()
                .map(line -> line.split(","))
                .get()).map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("Lowest fuel Amount for crabs is " + CrabSubmarineHorizontalPositionAlignmentCalculator.calculateCheapestFuelSpendingForAlignment(inputHorizontalPositions));
    }
}
