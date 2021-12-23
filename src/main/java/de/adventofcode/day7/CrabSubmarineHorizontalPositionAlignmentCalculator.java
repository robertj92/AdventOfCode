package de.adventofcode.day7;

import java.util.Collections;
import java.util.List;

public class CrabSubmarineHorizontalPositionAlignmentCalculator {

    public static int calculateCheapestFuelSpendingForAlignment(final List<Integer> horizontalCrabSubmarinePositions) {

        int lowestFuel = -1;
        for (int center = Collections.min(horizontalCrabSubmarinePositions); center <= Collections.max(horizontalCrabSubmarinePositions); center++) {
            int sum = 0;
            for (Integer position : horizontalCrabSubmarinePositions) {
                if (position.equals(center))
                    continue;

                for (int i = Math.min(position, center), currentIteration = 1; i < Math.max(position, center); i++, currentIteration++) {
                    sum += currentIteration;
                }
            }

            if (lowestFuel == -1 || sum < lowestFuel)
                lowestFuel = sum;
        }

        return lowestFuel;
    }
}
