package de.adventofcode.day1;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        final DepthIncreasementCalculator depthIncreasementCalculator = new DepthIncreasementCalculator();
        int[] depthMeasurements = IntegerFileReader.readIntegersFromFile("input.txt");
        System.out.println("Depth Increasement was: " + depthIncreasementCalculator.countDepthIncreasements(depthMeasurements, 3));
    }
}
