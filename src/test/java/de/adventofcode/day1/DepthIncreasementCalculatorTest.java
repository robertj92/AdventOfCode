package de.adventofcode.day1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DepthIncreasementCalculatorTest {

    private final DepthIncreasementCalculator depthIncreasementCalculator = new DepthIncreasementCalculator();

    @Test
    void depthMeasurement_withOneValue_shouldReturnZero() {
        int[] depthMeasurements = { 2 };

        assertEquals(0, depthIncreasementCalculator.countDepthIncreasements(depthMeasurements));
    }

    @Test
    void depthMeasurements_withOneIncrease_shoudReturnOne() {
        int[] depthMeasurements = { 2, 3 };

        assertEquals(1, depthIncreasementCalculator.countDepthIncreasements(depthMeasurements));
    }

    @Test
    void depthMeasurements_withoutIncreasement_shoudReturnZero() {
        int[] depthMeasurements = { 3, 2 };

        assertEquals(0, depthIncreasementCalculator.countDepthIncreasements(depthMeasurements));
    }

    @Test
    void depthMeasurements_withMultipleIncreasements_shouldReturnCorrectNumberOfIncreasements() {
        int[] depthMeasurements = { 1, 2, 3, 2, 4 };

        assertEquals(3, depthIncreasementCalculator.countDepthIncreasements(depthMeasurements));
    }

    @Test
    void depthMeasurements_withInputSourceFromAdventOfCode() throws FileNotFoundException {
        int[] depthMeasurements = IntegerFileReader.readIntegersFromFile("day1/input.txt");

        assertEquals(1548, depthIncreasementCalculator.countDepthIncreasements(depthMeasurements));
    }

    @Test
    void depthMeasurementsWithThreeMeasurementSlidingWindows_withOneIncrement_shouldReturnOne() {
        int[] depthMeasurements = { 1, 2, 3, 4 };

        assertEquals(1, depthIncreasementCalculator.countDepthIncreasements(depthMeasurements, 3));
    }

    @Test
    void depthMeasurementsWithThreeMeasurementSlidingWindows_withoutIncrement_shouldReturnZero() {
        int[] depthMeasurements = { 1, 2, 3, 1 };

        assertEquals(0, depthIncreasementCalculator.countDepthIncreasements(depthMeasurements, 3));
    }

    @Test
    void depthMeasurementsWithThreeMeasurementSlidingWindows_withInputSourceFromAdventOfCode() throws FileNotFoundException {
        int[] depthMeasurements = IntegerFileReader.readIntegersFromFile("day1/input.txt");

        assertEquals(1589, depthIncreasementCalculator.countDepthIncreasements(depthMeasurements, 3));
    }
}
