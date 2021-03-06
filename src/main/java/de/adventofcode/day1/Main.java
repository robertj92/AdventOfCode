package de.adventofcode.day1;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws IOException {
        final DepthIncreasementCalculator depthIncreasementCalculator = new DepthIncreasementCalculator();
        int[] depthMeasurements = IntegerFileReader.readIntegersFromFile("day1/input.txt");
        System.out.println("Depth Increasement was: " + depthIncreasementCalculator.countDepthIncreasements(depthMeasurements, 3));
    }
}
