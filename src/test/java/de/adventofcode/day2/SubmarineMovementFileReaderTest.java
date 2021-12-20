package de.adventofcode.day2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubmarineMovementFileReaderTest {

    @Test
    void testReadMovementsFromFile_shouldMatchMovementsInFile() throws URISyntaxException, IOException {
        final List<Movement> movements = SubmarineMovementFileReader.readMovementsFromFile("day2/submarine_input_example.txt");

        assertEquals(6, movements.size());
        assertEquals(new Movement(Direction.FORWARD, 5), movements.get(0));
        assertEquals(new Movement(Direction.DOWN, 5), movements.get(1));
        assertEquals(new Movement(Direction.FORWARD, 8), movements.get(2));
        assertEquals(new Movement(Direction.UP, 3), movements.get(3));
        assertEquals(new Movement(Direction.DOWN, 8), movements.get(4));
        assertEquals(new Movement(Direction.FORWARD, 2), movements.get(5));
    }
}
