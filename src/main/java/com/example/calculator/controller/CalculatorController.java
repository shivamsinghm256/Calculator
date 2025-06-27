package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) {
        return calculatorService.add(a, b);
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
        return calculatorService.subtract(a, b);
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
        return calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double a, @RequestParam double b) {
        return calculatorService.divide(a, b);
    }

    @GetMapping("/modulus")
    public double modulus(@RequestParam double a, @RequestParam double b) {
        return calculatorService.modulus(a, b);
    }

    @GetMapping("/percentage")
    public double percentage(@RequestParam double total, @RequestParam double percentage) {
        return calculatorService.percentage(total, percentage);
    }

    @GetMapping("/bitwise-and")
    public int bitwiseAnd(@RequestParam int a, @RequestParam int b) {
        return calculatorService.bitwiseAnd(a, b);
    }

    @GetMapping("/bitwise-or")
    public int bitwiseOr(@RequestParam int a, @RequestParam int b) {
        return calculatorService.bitwiseOr(a, b);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}