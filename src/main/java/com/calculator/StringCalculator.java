package com.calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.contains(",")) {
            String[] parts = numbers.split(",");
            return Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
        }
        return Integer.parseInt(numbers);
    }
}
