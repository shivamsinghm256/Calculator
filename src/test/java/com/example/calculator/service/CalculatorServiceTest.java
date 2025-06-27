package com.example.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(8, calculatorService.add(5, 3));
        assertEquals(-2, calculatorService.add(-5, 3));
        assertEquals(0, calculatorService.add(0, 0));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calculatorService.subtract(5, 3));
        assertEquals(-8, calculatorService.subtract(-5, 3));
        assertEquals(0, calculatorService.subtract(0, 0));
    }

    @Test
    void testMultiply() {
        assertEquals(15, calculatorService.multiply(5, 3));
        assertEquals(-15, calculatorService.multiply(-5, 3));
        assertEquals(0, calculatorService.multiply(0, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculatorService.divide(6, 3));
        assertEquals(-2, calculatorService.divide(-6, 3));
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(6, 0));
    }

    @Test
    void testModulus() {
        assertEquals(2, calculatorService.modulus(5, 3));
        assertEquals(-2, calculatorService.modulus(-5, 3));
        assertThrows(ArithmeticException.class, () -> calculatorService.modulus(5, 0));
    }

    @Test
    void testPercentage() {
        assertEquals(30, calculatorService.percentage(200, 15));
        assertEquals(0, calculatorService.percentage(0, 15));
        assertEquals(0, calculatorService.percentage(200, 0));
    }

    @Test
    void testBitwiseAnd() {
        assertEquals(1, calculatorService.bitwiseAnd(5, 3));
        assertEquals(0, calculatorService.bitwiseAnd(0, 3));
        assertEquals(5, calculatorService.bitwiseAnd(5, 7));
    }

    @Test
    void testBitwiseOr() {
        assertEquals(7, calculatorService.bitwiseOr(5, 3));
        assertEquals(3, calculatorService.bitwiseOr(0, 3));
        assertEquals(7, calculatorService.bitwiseOr(5, 7));
    }
}