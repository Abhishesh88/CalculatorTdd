package com.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("String Calculator")
class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
        System.out.println("\n----- Starting new test -----");
    }

    @Nested
    @DisplayName("Basic Operations")
    class BasicOperations {
        @Test
        @DisplayName("Empty string returns zero")
        void whenEmptyStringProvidedReturnsZero() {
            int result = calculator.add("");
            System.out.println("Empty string test: expected=0, actual=" + result);
            assertEquals(0, result);
        }

        @Test
        @DisplayName("Single number returns the number itself")
        void whenSingleNumberProvidedReturnsSameNumber() {
            int result1 = calculator.add("1");
            System.out.println("Single number test 1: expected=1, actual=" + result1);
            assertEquals(1, result1);

            int result2 = calculator.add("5");
            System.out.println("Single number test 2: expected=5, actual=" + result2);
            assertEquals(5, result2);
        }
    }

    @Nested
    @DisplayName("Multiple Numbers")
    class MultipleNumbers {
        @Test
        @DisplayName("Two numbers return their sum")
        void whenTwoNumbersProvidedReturnsSum() {
            int result1 = calculator.add("1,2");
            System.out.println("Two numbers test 1: expected=3, actual=" + result1);
            assertEquals(3, result1);

            int result2 = calculator.add("4,5");
            System.out.println("Two numbers test 2: expected=9, actual=" + result2);
            assertEquals(9, result2);
        }

        @Test
        @DisplayName("Multiple numbers return their sum")
        void whenMultipleNumbersProvidedReturnsSum() {
            int result1 = calculator.add("1,2,3,4");
            System.out.println("Multiple numbers test 1: expected=10, actual=" + result1);
            assertEquals(10, result1);

            int result2 = calculator.add("5,5,5");
            System.out.println("Multiple numbers test 2: expected=15, actual=" + result2);
            assertEquals(15, result2);
        }
    }

    @Nested
    @DisplayName("Delimiter Handling")
    class DelimiterHandling {
        @Test
        @DisplayName("Newline as delimiter returns sum")
        void whenNewlineAsDelimiterReturnsSum() {
            int result = calculator.add("1\n2,3");
            System.out.println("Newline as delimiter test: expected=6, actual=" + result);
            assertEquals(6, result);
        }

        @Test
        @DisplayName("Custom delimiter returns sum")
        void whenCustomDelimiterReturnsSum() {
            int result = calculator.add("//;\n1;2");
            System.out.println("Custom delimiter test: expected=3, actual=" + result);
            assertEquals(3, result);
        }
    }

    @Nested
    @DisplayName("Error Handling")
    class ErrorHandling {
        @Test
        @DisplayName("Negative numbers throw exception")
        void whenNegativeNumbersProvidedThrowException() {
            Exception exception = assertThrows(IllegalArgumentException.class, 
                () -> calculator.add("1,-2,-3,4"));
            String expectedMessage = "negative numbers not allowed: -2, -3";
            System.out.println("Negative numbers test: expected='" + expectedMessage + 
                "', actual='" + exception.getMessage() + "'");
            assertEquals(expectedMessage, exception.getMessage());
        }
    }
} 