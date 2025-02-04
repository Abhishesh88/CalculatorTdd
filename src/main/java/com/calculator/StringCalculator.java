package com.calculator;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A string calculator that adds numbers provided in string format.
 * Supports multiple delimiters and validates against negative numbers.
 */
public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|\n";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");

    /**
     * Adds numbers provided in a string format.
     *
     * @param numbers String containing numbers to add, can be empty
     * @return sum of the numbers
     * @throws IllegalArgumentException if negative numbers are found
     */
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        String numbersToProcess = numbers;

        if (numbers.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            DelimiterParseResult parseResult = parseCustomDelimiter(numbers);
            delimiter = parseResult.delimiter();
            numbersToProcess = parseResult.numbers();
        }

        return calculateSum(numbersToProcess.split(delimiter));
    }

    private DelimiterParseResult parseCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.matches()) {
            return new DelimiterParseResult(
                Pattern.quote(matcher.group(1)),
                matcher.group(2)
            );
        }
        return new DelimiterParseResult(DEFAULT_DELIMITER, input);
    }

    private int calculateSum(String[] numbers) {
        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;

        for (String num : numbers) {
            int value = Integer.parseInt(num);
            if (value < 0) {
                negativeNumbers.add(value);
            }
            sum += value;
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed: " + 
                String.join(", ", negativeNumbers.stream()
                    .map(String::valueOf)
                    .toList()));
        }

        return sum;
    }

    private record DelimiterParseResult(String delimiter, String numbers) {}
}
