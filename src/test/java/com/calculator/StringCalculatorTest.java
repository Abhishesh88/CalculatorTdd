package com.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
        System.out.println("\n----- Starting new test -----");
    }

    @Test
    void whenEmptyStringProvidedReturnsZero() {
        int result = calculator.add("");
        System.out.println("Empty string test: expected=0, actual=" + result);
        assertEquals(0, result);
    }

    @Test
    void whenSingleNumberProvidedReturnsSameNumber() {
        int result1 = calculator.add("1");
        System.out.println("Single number test 1: expected=1, actual=" + result1);
        assertEquals(1, result1);

        int result2 = calculator.add("5");
        System.out.println("Single number test 2: expected=5, actual=" + result2);
        assertEquals(5, result2);
    }

    @Test
    void whenTwoNumbersProvidedReturnsSum() {
        int result1 = calculator.add("1,2");
        System.out.println("Two numbers test 1: expected=3, actual=" + result1);
        assertEquals(3, result1);

        int result2 = calculator.add("4,5");
        System.out.println("Two numbers test 2: expected=9, actual=" + result2);
        assertEquals(9, result2);
    }
    
    @Test
    void whenMultipleNumbersProvidedReturnsSum() {
        int result1 = calculator.add("1,2,3,4");
        System.out.println("Multiple numbers test 1: expected=10, actual=" + result1);
        assertEquals(10, result1);

        int result2 = calculator.add("5,5,5");
        System.out.println("Multiple numbers test 2: expected=15, actual=" + result2);
        assertEquals(15, result2);
    }
    
    @Test
    void whenNewlineAsDelimiterReturnsSum() {
        int result = calculator.add("1\n2,3");
        System.out.println("Newline as delimiter test: expected=6, actual=" + result);
        assertEquals(6, result);
    }

    
} 