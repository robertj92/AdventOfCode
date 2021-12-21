package de.adventofcode.day6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternfishGrowthRateCalculatorTest {

    @Test
    void testCalculateLanternfishes_AfterOneDayShouldReturnTheSameFishWithDecreasedNumber() {
        List<Integer> lanternFishInput = List.of(3);
        assertEquals(1, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 1));

        lanternFishInput = List.of(5);
        assertEquals(1, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 1));
    }

    @Test
    void testCalculateLanternfishes_AfterTwoDaysShouldReturnTheSameFishWithDecreasedNumber() {
        List<Integer> lanternFishInput = List.of(3);
        assertEquals(1, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 2));

        lanternFishInput = List.of(5);
        assertEquals(1, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 2));
    }

    @Test
    void testCalculateLanternfishes_AfterFishWasZero_ANewFishWith8ShouldBeCreated_AndTheOldOneShouldBeResetTo6() {
        List<Integer> lanternFishInput = List.of(0);
        assertEquals(2, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 1));
    }

    @Test
    void testCalculateLaternfishes_WithTestInput() {
        List<Integer> lanternFishInput = List.of(3, 4, 3, 1, 2);
        assertEquals(6, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 2));
        assertEquals(7, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 3));
        assertEquals(9, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 4));
        assertEquals(10, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 5));
        assertEquals(10, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 6));
        assertEquals(12, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 10));
        assertEquals(17, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 12));
        assertEquals(26, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 18));
        assertEquals(5934, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 80));
        assertEquals(26984457539L, LanternfishGrowthRateCalculator.countLanternFishesAfterDays(lanternFishInput, 256));
    }
}
