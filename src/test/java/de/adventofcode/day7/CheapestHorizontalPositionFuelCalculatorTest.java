package de.adventofcode.day7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheapestHorizontalPositionFuelCalculatorTest {

    @Test
    void testCalculateCheapestHorizontalPositionAlignmentFuelCalculator_withOneElement_shouldReturnZero() {
        List<Integer> horizontalCrabSubmarinePositions = List.of(3);
        assertEquals(0, CrabSubmarineHorizontalPositionAlignmentCalculator.calculateCheapestFuelSpendingForAlignment(horizontalCrabSubmarinePositions));
    }

    @Test
    void testCalculateCheapestHorizontalPositionAlignmentFuelCalculator_withTwoElements_shouldReturnDifference() {
        List<Integer> horizontalCrabSubmarinePositions = List.of(3, 2);
        assertEquals(1, CrabSubmarineHorizontalPositionAlignmentCalculator.calculateCheapestFuelSpendingForAlignment(horizontalCrabSubmarinePositions));

        horizontalCrabSubmarinePositions = List.of(3, 6);
        assertEquals(4, CrabSubmarineHorizontalPositionAlignmentCalculator.calculateCheapestFuelSpendingForAlignment(horizontalCrabSubmarinePositions));
    }

    @Test
    void testCalculateCheapestHorizontalPositionAlignmentFuelCalculator_withMoreElements_shouldReturnMinimumFuel() {

        List<Integer> horizontalCrabSubmarinePositions = List.of(3, 2, 2);
        assertEquals(1, CrabSubmarineHorizontalPositionAlignmentCalculator.calculateCheapestFuelSpendingForAlignment(horizontalCrabSubmarinePositions));

        horizontalCrabSubmarinePositions = List.of(3, 6, 5);
        assertEquals(4, CrabSubmarineHorizontalPositionAlignmentCalculator.calculateCheapestFuelSpendingForAlignment(horizontalCrabSubmarinePositions));

        horizontalCrabSubmarinePositions = List.of(1, 2, 3);
        assertEquals(2, CrabSubmarineHorizontalPositionAlignmentCalculator.calculateCheapestFuelSpendingForAlignment(horizontalCrabSubmarinePositions));

        horizontalCrabSubmarinePositions = List.of(16, 1, 2, 0, 4, 2, 7, 1, 2, 14);
        assertEquals(168, CrabSubmarineHorizontalPositionAlignmentCalculator.calculateCheapestFuelSpendingForAlignment(horizontalCrabSubmarinePositions));
    }
}
