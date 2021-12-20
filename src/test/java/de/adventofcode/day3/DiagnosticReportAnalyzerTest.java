package de.adventofcode.day3;

import de.adventofcode.day3.DiagnosticReportAnalyzer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagnosticReportAnalyzerTest {

    private DiagnosticReportAnalyzer analyzer = new DiagnosticReportAnalyzer();

    @Test
    void testCreateDiagnosticReportAnalzyer() {
        assertEquals(0, analyzer.getPowerConsumption());
        assertEquals(0, analyzer.getGammaRate());
        assertEquals(0, analyzer.getEpsilonRate());
        assertEquals(0, analyzer.getLifeSupportRating());
        assertEquals(0, analyzer.getOxygenGeneratorRating());
        assertEquals(0, analyzer.getCo2ScrubberRating());
    }

    @Test
    void testAddDiagnosticReportValueToAnalyzer_gammaRateAndEpsilonRateShouldBeCalculated() {
        analyzer.addDiagnosticReportValue("00001");
        assertEquals(1, analyzer.getGammaRate());
        assertEquals(1, analyzer.getEpsilonRate());
        assertEquals(1, analyzer.getPowerConsumption());
        assertEquals(1, analyzer.getLifeSupportRating());
        assertEquals(1, analyzer.getOxygenGeneratorRating());
        assertEquals(1, analyzer.getCo2ScrubberRating());
    }

    @Test
    void testAddDiagnosticReportValueToAnalyzer_gammaRateAndEpsilonRateShouldBeCalculated2() {
        analyzer.addDiagnosticReportValue("00011");

        assertEquals(3, analyzer.getGammaRate());
        assertEquals(3, analyzer.getEpsilonRate());
        assertEquals(9, analyzer.getPowerConsumption());
        assertEquals(3, analyzer.getOxygenGeneratorRating());
        assertEquals(3, analyzer.getCo2ScrubberRating());
        assertEquals(9, analyzer.getLifeSupportRating());

        analyzer.addDiagnosticReportValue("00011");
        analyzer.addDiagnosticReportValue("00111");

        assertEquals(3, analyzer.getGammaRate());
        assertEquals(7, analyzer.getEpsilonRate());
        assertEquals(21, analyzer.getPowerConsumption());
        assertEquals(3, analyzer.getOxygenGeneratorRating());
        assertEquals(7, analyzer.getCo2ScrubberRating());
        assertEquals(21, analyzer.getLifeSupportRating());
    }

    @Test
    void testAddDiagnosticReportValueToAnalyzer_gammaRateAndEpsilonRateShouldBeCalculated3() {
        analyzer.addDiagnosticReportValue("00100");
        analyzer.addDiagnosticReportValue("11110");
        analyzer.addDiagnosticReportValue("10110");
        analyzer.addDiagnosticReportValue("10111");
        analyzer.addDiagnosticReportValue("10101");
        analyzer.addDiagnosticReportValue("01111");
        analyzer.addDiagnosticReportValue("00111");
        analyzer.addDiagnosticReportValue("11100");
        analyzer.addDiagnosticReportValue("10000");
        analyzer.addDiagnosticReportValue("11001");
        analyzer.addDiagnosticReportValue("00010");
        analyzer.addDiagnosticReportValue("01010");

        assertEquals(22, analyzer.getGammaRate());
        assertEquals(9, analyzer.getEpsilonRate());
        assertEquals(198, analyzer.getPowerConsumption());
        // assertEquals(23, analyzer.getOxygenGeneratorRating());
        assertEquals(10, analyzer.getCo2ScrubberRating());
        assertEquals(230, analyzer.getLifeSupportRating());
    }
}
