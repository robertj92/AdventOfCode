package de.adventofcode.day8;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DigitCounter {

    public static int calculateDigitSum(List<String> inputs) {
        return inputs.stream()
                .map(DigitCounter::extractOutputNumber)
                .reduce(0, Integer::sum);
    }

    public static int extractOutputNumber(String inputString) {
        final HashMap<Integer, Long> result = initializeResultMap();
        final HashMap<Integer, List<Character>> digitMappings = new HashMap<>();

        final String[] input = inputString.split(" \\| ");

        final String[] digitOutputs = input[1].split(" ");

        final Map<Integer, Character> letterCounts = countLetters(input[0]);
        final Set<Character> lettersOfOne = findLettersForDigitOne(input[0]);

        final StringBuffer buffer = new StringBuffer();
        for (String digit : digitOutputs)
            buffer.append(convertToDigit(digit, letterCounts, lettersOfOne));

        return Integer.parseInt(buffer.toString());
    }

    private static Set<Character> findLettersForDigitOne(String input) {
        for (String inputDigit : input.split(" "))
            if (inputDigit.length() == 2)
                return inputDigit.chars().mapToObj(i -> (char)i).collect(Collectors.toSet());

        return Collections.emptySet();
    }

    private static Map<Integer, Character> countLetters(final String inputDigits) {
        final Map<Character, Integer> letterCounts = new HashMap<>();
        for (char character : inputDigits.replaceAll(" ", "").toCharArray()) {
            letterCounts.put(character, letterCounts.getOrDefault(character, 0) + 1);
        }

        letterCounts.entrySet().removeIf(entry -> List.of(7, 8, 9).contains(entry.getValue()));

        return letterCounts.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    private static HashMap<Integer, Long> initializeResultMap() {
        final HashMap<Integer, Long> result = new HashMap<>();
        result.put(0, 0L);
        result.put(1, 0L);
        result.put(2, 0L);
        result.put(3, 0L);
        result.put(4, 0L);
        result.put(5, 0L);
        result.put(6, 0L);
        result.put(7, 0L);
        result.put(8, 0L);
        result.put(9, 0L);

        return result;
    }

    private static void incrementDigitCount(final Map<Integer, Long> digitCounts, int digit) {
        digitCounts.put(digit, digitCounts.get(digit) + 1);
    }

    private static int convertToDigit(final String input, final Map<Integer, Character> letterCounts, final Set<Character> lettersOfOne) {
        final long distinctCharacters = input.chars().distinct().count();

        if (distinctCharacters == 2) return 1;
        else if (distinctCharacters == 3) return 7;
        else if (distinctCharacters == 4) return 4;
        else if (distinctCharacters == 5) {
            // could be 2, 3 and 5
            if (input.contains(String.valueOf(letterCounts.get(4))))
                return 2;
            else if (input.contains(String.valueOf(letterCounts.get(6))))
                return 5;
            else
                return 3;
        } else if (distinctCharacters == 6) {
            if (!input.contains(String.valueOf(letterCounts.get(4))))
                return 9;
            else if (lettersOfOne.stream().allMatch(letter -> input.contains(String.valueOf(letter))))
                return 0;
            else
                return 6;
        }
        else if (distinctCharacters == 7) return 8;

        return 0;
    }
}

/*
0 == 6
1 == 2
2 == 5
3 == 5
4 == 4
5 == 5
6 == 6
7 == 3
8 == 7
9 == 6

0, 6, 9
9 -> contains all letters of 1, 6 not

0 -> a, b, c, e, f, g  --> if it contains all letters of 1 (c, f)
6 -> a, b, d, e, f, g  --> otherwise
9 -> a, b, c, d, f, g  --> if it doesn't contain e

2, 3, 5
3 contains all letters of 1

2 -> a, c, d, e, g    --> if it contains e
3 -> a, c, d, f, g    --> otherwise
5 -> a, b, d, f, g    --> if it contains b

a = 8
b = 6
c = 8
d = 7
e = 4
f = 9
g = 7

- the 10 signal patterns are the 10 unique combinations
 */
