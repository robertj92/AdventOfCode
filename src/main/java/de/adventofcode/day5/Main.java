package de.adventofcode.day5;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        final List<HydrothermalVentLine> ventLines = HydrothermalVentLineParser.loadVentLinesFromFile("day5/input.txt");
        final int dangerousPositionCount = HydrothermalVentAreaCalculator.calculateDangerousPositionsFor(ventLines);
        System.out.println("Number of dangerous positions: " + dangerousPositionCount);
    }
}
