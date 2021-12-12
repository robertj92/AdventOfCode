package de.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class IntegerFileReader {

    public static int[] readIntegersFromFile(String fileName) throws FileNotFoundException {

        final List<Integer> elements = new ArrayList<>();
        final Scanner scanner = new Scanner(readFileFromResources(fileName));

        while (scanner.hasNextInt()) {
            elements.add(scanner.nextInt());
        }

        return convertIntegerListToArray(elements);
    }

    private static File readFileFromResources(final String fileName) {
        final ClassLoader classLoader = IntegerFileReader.class.getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
    }

    private static int[] convertIntegerListToArray(final List<Integer> elements) {
        final int[] result = new int[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            result[i] = elements.get(i);
        }

        return result;
    }
}
