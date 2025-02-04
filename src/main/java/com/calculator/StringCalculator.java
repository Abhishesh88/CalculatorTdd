package com.calculator;

import java.util.regex.*;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbers = matcher.group(2);
            }
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;
        StringBuilder negatives = new StringBuilder();

        for (String num : parts) {
            int value = Integer.parseInt(num);
            if (value < 0) {
                if (negatives.length() > 0) {
                    negatives.append(", ");
                }
                negatives.append(value);
            }
            sum += value;
        }

        if (negatives.length() > 0) {
            throw new IllegalArgumentException("negative numbers not allowed: " + negatives.toString().trim());
        }

        return sum;
    }
}
