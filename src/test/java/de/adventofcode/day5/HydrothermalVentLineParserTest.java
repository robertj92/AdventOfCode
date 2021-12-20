package de.adventofcode.day5;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HydrothermalVentLineParserTest {

    @Test
    void parseHydrothermalVentLinesFromFile() throws URISyntaxException, IOException {

        final List<HydrothermalVentLine> ventLines = HydrothermalVentLineParser.loadVentLinesFromFile("day5/input_one_element.txt");
        final var expected = new HydrothermalVentLine(new Position(0, 9), new Position(5, 9));

        assertEquals(1, ventLines.size());
        assertEquals(expected, ventLines.get(0));
    }

    @Test
    void parseHydrothermalVentLinesFromFileTwo() throws URISyntaxException, IOException {

        final List<HydrothermalVentLine> ventLines = HydrothermalVentLineParser.loadVentLinesFromFile("day5/input_small.txt");
        final var expected = new HydrothermalVentLine(new Position(0, 9), new Position(5, 9));

        assertEquals(10, ventLines.size());
        assertEquals(expected, ventLines.get(0));

        assertEquals(12, HydrothermalVentAreaCalculator.calculateDangerousPositionsFor(ventLines));
    }
}
