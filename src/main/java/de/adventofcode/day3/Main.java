package de.adventofcode.day3;

import de.adventofcode.day2.SubmarineMovementFileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        final DiagnosticReportAnalyzer diagnosticReportAnalyzer = new DiagnosticReportAnalyzer();
        getLinesStreamFromFile("day3/submarine_diagnostic_report_input.txt").forEach(diagnosticReportAnalyzer::addDiagnosticReportValue);

        System.out.println("Power Consumption is " + diagnosticReportAnalyzer.getPowerConsumption());
        System.out.println("Life Support Rating is " + diagnosticReportAnalyzer.getLifeSupportRating());
    }

    private static Stream<String> getLinesStreamFromFile(final String fileName) throws URISyntaxException, IOException {
        Path path = Paths.get(SubmarineMovementFileReader.class.getClassLoader()
                .getResource(fileName).toURI());

        return Files.lines(path);
    }
}
