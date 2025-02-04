package com.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void whenEmptyStringProvidedReturnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void whenSingleNumberProvidedReturnsSameNumber() {
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("5"));
    }
    
} 