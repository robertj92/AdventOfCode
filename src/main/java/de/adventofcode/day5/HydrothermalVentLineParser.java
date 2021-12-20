package de.adventofcode.day5;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class HydrothermalVentLineParser {

    public static List<HydrothermalVentLine> loadVentLinesFromFile(String fileName) throws URISyntaxException, IOException {

        Path path = Paths.get(HydrothermalVentLineParser.class.getClassLoader()
                .getResource(fileName).toURI());

        return Files.lines(path)
                .map(HydrothermalVentLineParser::parseVentLineFromLine)
                .collect(Collectors.toList());
    }

    private static HydrothermalVentLine parseVentLineFromLine(final String line) {
        final String[] positions = line.split("->");
        final Position position1 = parsePositionFromString(positions[0]);
        final Position position2 = parsePositionFromString(positions[1]);

        return new HydrothermalVentLine(position1, position2);
    }

    private static Position parsePositionFromString(final String position) {
        final String[] positionDetails = position.strip().split(",");

        return new Position(Integer.parseInt(positionDetails[0]), Integer.parseInt(positionDetails[1]));
    }
}
