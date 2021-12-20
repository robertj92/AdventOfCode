package de.adventofcode.day5;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HydrothermalVentAreaCalculator {

    public static int calculateDangerousPositionsFor(final List<HydrothermalVentLine> ventLines) {

        final List<Position> allPositions = ventLines.stream()
                .map(HydrothermalVentLine::calculatePositionsInLine)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        final Set<Position> dangerousPoints = new HashSet<>();

        final Set<Position> uniquePositions = new HashSet<>(allPositions);

        for (Position position : uniquePositions) {
            if (Collections.frequency(allPositions, position) > 1)
                dangerousPoints.add(position);
        }

        return dangerousPoints.size();
    }
}
