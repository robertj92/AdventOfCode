package de.adventofcode.day6;

import de.adventofcode.day5.HydrothermalVentLineParser;

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
                .getResource("day6/input.txt").toURI());

        final List<Integer> inputLanternfishes = Arrays.stream(Files.lines(path)
                .findFirst()
                .map(line -> line.split(","))
                .get()).map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("Lantern Fishes after 256 days are " + LanternfishGrowthRateCalculator.countLanternFishesAfterDays(inputLanternfishes, 256));
    }
}
