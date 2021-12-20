package de.adventofcode.day3;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiagnosticReportAnalyzer {

    private int gammaRate = 0;
    private int epsilonRate = 0;
    private int oxygenGeneratorRating = 0;
    private int co2ScrubberRating = 0;

    private List<List<Integer>> diagnosticReportValues = new ArrayList<>();

    public int getPowerConsumption() {
        return gammaRate * epsilonRate;
    }

    public int getGammaRate() {
        return gammaRate;
    }

    public int getEpsilonRate() {
        return epsilonRate;
    }

    public int getLifeSupportRating() {
        return oxygenGeneratorRating * co2ScrubberRating;
    }

    public int getOxygenGeneratorRating() {
        return oxygenGeneratorRating;
    }

    public int getCo2ScrubberRating() {
        return co2ScrubberRating;
    }

    public void addDiagnosticReportValue(String value) {
        diagnosticReportValues.add(convertBinaryStringToListOfIntegers(value));

        epsilonRate = calculateEpsilonRateFromDiagnosticReportValues();
        gammaRate = calculateGammaRateFromDiagnosticReportValues();

        oxygenGeneratorRating = calculateOxygenGeneratorRatingFromDiagnosticReportValues();
        co2ScrubberRating = calculateCo2ScrubberRatingFromDiagnosticReportValues();
    }

    private int calculateOxygenGeneratorRatingFromDiagnosticReportValues() {
        StringBuilder stringBuilder = new StringBuilder();

        List<List<Integer>> remainingNumbers = List.copyOf(diagnosticReportValues);

        for (int i = 0; i < diagnosticReportValues.get(0).size(); i++) {

            if (remainingNumbers.size() == 1) {
                for (Integer binaryDigit : remainingNumbers.get(0))
                    stringBuilder.append(binaryDigit);

                return Integer.parseInt(stringBuilder.toString(), 2);
            }

            int ones = 0;
            int zeros = 0;

            for (List<Integer> diagnosticReportValue : remainingNumbers) {
                if (diagnosticReportValue.get(i) == 0)
                    zeros++;
                else
                    ones++;
            }

            int finalOnes = ones;
            int finalZeros = zeros;
            int finalI = i;

            remainingNumbers = remainingNumbers.stream().filter(number -> {
                if (finalOnes == finalZeros || finalOnes > finalZeros)
                    return number.get(finalI) == 1;
                else
                    return number.get(finalI) == 0;
            }).collect(Collectors.toList());
        }

        for (Integer binaryDigit : remainingNumbers.get(0))
            stringBuilder.append(binaryDigit);

        return Integer.parseInt(stringBuilder.toString(), 2);
    }

    private int calculateCo2ScrubberRatingFromDiagnosticReportValues() {
        StringBuilder stringBuilder = new StringBuilder();

        List<List<Integer>> remainingNumbers = List.copyOf(diagnosticReportValues);

        for (int i = 0; i < diagnosticReportValues.get(0).size(); i++) {

            if (remainingNumbers.size() == 1) {
                for (Integer binaryDigit : remainingNumbers.get(0))
                    stringBuilder.append(binaryDigit);

                return Integer.parseInt(stringBuilder.toString(), 2);
            }

            int ones = 0;
            int zeros = 0;

            for (List<Integer> diagnosticReportValue : remainingNumbers) {
                if (diagnosticReportValue.get(i) == 0)
                    zeros++;
                else
                    ones++;
            }

            int finalOnes = ones;
            int finalZeros = zeros;
            int finalI = i;

            remainingNumbers = remainingNumbers.stream().filter(number -> {
                if (finalOnes == finalZeros || finalOnes > finalZeros || finalOnes == 0)
                    return number.get(finalI) == 0;
                else
                    return number.get(finalI) == 1;
            }).collect(Collectors.toList());
        }

        return 0;
    }

    private int calculateGammaRateFromDiagnosticReportValues() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (Pair<Integer, Integer> onesAndZerosPair : calculateOnesAndZerosPerColumnFromDiagnosticReportValues()) {
            if (onesAndZerosPair.getValue0() > onesAndZerosPair.getValue1())
                stringBuilder.append(1);
            else
                stringBuilder.append(0);
        }

        return Integer.parseInt(stringBuilder.toString(), 2);
    }

    private int calculateEpsilonRateFromDiagnosticReportValues() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (Pair<Integer, Integer> onesAndZerosPair : calculateOnesAndZerosPerColumnFromDiagnosticReportValues()) {
            if (onesAndZerosPair.getValue0() == 0) {
                stringBuilder.append(0);
            } else if (onesAndZerosPair.getValue1() == 0) {
                stringBuilder.append(1);
            } else if (onesAndZerosPair.getValue0() > onesAndZerosPair.getValue1())
                stringBuilder.append(0);
            else
                stringBuilder.append(1);
        }

        return Integer.parseInt(stringBuilder.toString(), 2);
    }

    private List<Pair<Integer, Integer>> calculateOnesAndZerosPerColumnFromDiagnosticReportValues() {
        final List<Pair<Integer, Integer>> onesAndZerosPerColumn = new ArrayList<>();

        for (int i = 0; i < diagnosticReportValues.get(0).size(); i++) {
            int ones = 0;
            int zeros = 0;

            for (List<Integer> diagnosticReportValue : diagnosticReportValues) {
                if (diagnosticReportValue.get(i) == 0)
                    zeros++;
                else
                    ones++;
            }

            onesAndZerosPerColumn.add(new Pair<>(ones, zeros));
        }

        return onesAndZerosPerColumn;
    }

    private List<Integer> convertBinaryStringToListOfIntegers(String value) {
        return value.chars()
                .mapToObj(intValue -> String.valueOf((char) intValue))
                .map(character -> Integer.parseInt(character, 2))
                .collect(Collectors.toList());
    }
}
