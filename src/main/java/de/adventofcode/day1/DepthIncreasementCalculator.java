package de.adventofcode.day1;

public class DepthIncreasementCalculator {

    public int countDepthIncreasements(final int[] depthMeasurements) {
        return countDepthIncreasements(depthMeasurements, 1);
    }

    public int countDepthIncreasements(int[] depthMeasurements, int slidingWindow) {

        int increasements = 0;

        if (depthMeasurements.length > slidingWindow) {
            for (int i = slidingWindow; i < depthMeasurements.length; i++) {
                int windowBefore = calculateSlidingWindow(depthMeasurements, i - 1, slidingWindow);
                int currentWindow = calculateSlidingWindow(depthMeasurements, i, slidingWindow);

                if (currentWindow > windowBefore)
                    increasements++;
            }
        }

        return increasements;
    }

    private int calculateSlidingWindow(int[] elements, int lastIndex, int slidingWindow) {
        int currentIndex = lastIndex - slidingWindow + 1;
        int sum = 0;
        while(currentIndex <= lastIndex) {
            sum += elements[currentIndex];
            currentIndex++;
        }

        return sum;
    }
}
