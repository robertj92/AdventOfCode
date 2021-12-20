package de.adventofcode.day5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HydrothermalVentAreaCalculatorTest {

    @Test
    void testCalculateHydrothermalVentArea_withoutVentLines_shouldReturn0() {
        final List<HydrothermalVentLine> ventLines = new ArrayList<>();
        final int dangerousPositions = HydrothermalVentAreaCalculator.calculateDangerousPositionsFor(ventLines);

        assertEquals(0, dangerousPositions);
    }

    @Test
    void testCalculateHydrothermalVentArea_WithOneOverlappingPoint_shouldReturn0() {
        final List<HydrothermalVentLine> ventLines = new ArrayList<>();
        ventLines.add(new HydrothermalVentLine(new Position(9, 4), new Position(3, 4)));
        ventLines.add(new HydrothermalVentLine(new Position(7, 0), new Position(7, 4)));

        assertEquals(1, HydrothermalVentAreaCalculator.calculateDangerousPositionsFor(ventLines));
    }

    @Test
    void testCalculateHydrothermalVentArea_WithTwoOverlappingPoints_shouldReturn2() {
            List<HydrothermalVentLine> ventLines = new ArrayList<>();
            ventLines.add(new HydrothermalVentLine(new Position(9, 4), new Position(3, 4)));
            ventLines.add(new HydrothermalVentLine(new Position(7, 0), new Position(7, 4)));
            ventLines.add(new HydrothermalVentLine(new Position(6, 0), new Position(6, 5)));

            assertEquals(2, HydrothermalVentAreaCalculator.calculateDangerousPositionsFor(ventLines));

            ventLines = new ArrayList<>();
            ventLines.add(new HydrothermalVentLine(new Position(9, 4), new Position(3, 4)));
            ventLines.add(new HydrothermalVentLine(new Position(7, 0), new Position(7, 4)));
            ventLines.add(new HydrothermalVentLine(new Position(6, 0), new Position(6, 5)));
            ventLines.add(new HydrothermalVentLine(new Position(0, 0), new Position(0, 3)));

            assertEquals(2, HydrothermalVentAreaCalculator.calculateDangerousPositionsFor(ventLines));
    }
}
