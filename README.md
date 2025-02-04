# String Calculator TDD Kata

This project implements a String Calculator using Test-Driven Development (TDD) principles. The calculator can add numbers provided as a string input, supporting various delimiters and handling special cases.

## Project Overview

- **Language**: Java 17
- **Build Tool**: Maven
- **Testing Framework**: JUnit Jupiter 5.9.2

## Features

The String Calculator supports the following features:

1. Empty string input returns 0
2. Single number returns its value
3. Two numbers separated by comma returns their sum
4. Multiple numbers separated by comma returns their sum
5. New line character as an alternative delimiter
6. Custom delimiter support (format: "//[delimiter]\n[numbers]")
7. Negative numbers detection and error reporting

## Test Cases

The project follows TDD with the following test scenarios:

1. `whenEmptyStringProvidedReturnsZero()`
   - Input: ""
   - Expected: 0

2. `whenSingleNumberProvidedReturnsSameNumber()`
   - Input: "1" or "5"
   - Expected: Same number (1 or 5)

3. `whenTwoNumbersProvidedReturnsSum()`
   - Input: "1,2" or "4,5"
   - Expected: Sum (3 or 9)

4. `whenMultipleNumbersProvidedReturnsSum()`
   - Input: "1,2,3,4" or "5,5,5"
   - Expected: Sum (10 or 15)

5. `whenNewlineAsDelimiterReturnsSum()`
   - Input: "1\n2,3"
   - Expected: 6

6. `whenCustomDelimiterReturnsSum()`
   - Input: "//;\n1;2"
   - Expected: 3

7. `whenNegativeNumbersProvidedThrowException()`
   - Input: "1,-2,-3,4"
   - Expected: IllegalArgumentException with message "negative numbers not allowed: -2, -3"

## Project Structure