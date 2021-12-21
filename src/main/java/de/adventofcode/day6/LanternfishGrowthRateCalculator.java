package de.adventofcode.day6;

import java.util.Arrays;
import java.util.List;

public class LanternfishGrowthRateCalculator {

    public static long countLanternFishesAfterDays(final List<Integer> lanternFishes, int days) {
        long[] fishCounts = new long[9];
        Arrays.fill(fishCounts, 0);

        for (int lanternFish : lanternFishes) {
            fishCounts[lanternFish]++;
        }

        int currentDay = 0;

        while (currentDay < days) {
            long numberOfNewBorns = fishCounts[0];

            for (int i = 1;  i < fishCounts.length; i++) {
                fishCounts[i - 1] = fishCounts[i];
            }

            fishCounts[8] = numberOfNewBorns;
            fishCounts[6] += numberOfNewBorns;

            currentDay++;
        }

        long sumOfFishes = 0;
        for (long fishCount : fishCounts)
            sumOfFishes += fishCount;

        return sumOfFishes;
    }
}
