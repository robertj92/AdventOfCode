package de.adventofcode.day1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class IntegerFileReaderTest {

    @Test
    void testReadIntegersFromFile_withOneValue() throws FileNotFoundException {
        final String fileName = "input_one_element.txt";
        final int[] elements = IntegerFileReader.readIntegersFromFile(fileName);

        assertEquals(1, elements.length);
        assertEquals(123, elements[0]);
    }

    @Test
    void testReadIntegersFromFile_WithInvalidFileName() {
        final String invalidFileName = "invalid_file_name.txt";

        assertThrows(FileNotFoundException.class, () -> {
            IntegerFileReader.readIntegersFromFile(invalidFileName);
        });
    }

    @Test
    void testReadIntegersFromFile_withThreeInputValues() throws FileNotFoundException {
        final String fileName = "input_small.txt";
        final int[] elements = IntegerFileReader.readIntegersFromFile(fileName);

        assertEquals(3, elements.length);
        assertEquals(157, elements[0]);
        assertEquals(148, elements[1]);
        assertEquals(149, elements[2]);
    }
}