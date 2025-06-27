package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void testAddEndpoint() throws Exception {
        when(calculatorService.add(5, 3)).thenReturn(8.0);

        mockMvc.perform(get("/api/calculator/add")
                .param("a", "5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8.0"));
    }

    @Test
    void testSubtractEndpoint() throws Exception {
        when(calculatorService.subtract(5, 3)).thenReturn(2.0);

        mockMvc.perform(get("/api/calculator/subtract")
                .param("a", "5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void testMultiplyEndpoint() throws Exception {
        when(calculatorService.multiply(5, 3)).thenReturn(15.0);

        mockMvc.perform(get("/api/calculator/multiply")
                .param("a", "5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("15.0"));
    }

    @Test
    void testDivideEndpoint() throws Exception {
        when(calculatorService.divide(6, 3)).thenReturn(2.0);

        mockMvc.perform(get("/api/calculator/divide")
                .param("a", "6")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void testDivideByZeroEndpoint() throws Exception {
        when(calculatorService.divide(6, 0)).thenThrow(new IllegalArgumentException("Division by zero is not allowed."));

        mockMvc.perform(get("/api/calculator/divide")
                .param("a", "6")
                .param("b", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Division by zero is not allowed."));
    }

    @Test
    void testModulusEndpoint() throws Exception {
        when(calculatorService.modulus(5, 3)).thenReturn(2.0);

        mockMvc.perform(get("/api/calculator/modulus")
                .param("a", "5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void testPercentageEndpoint() throws Exception {
        when(calculatorService.percentage(200, 15)).thenReturn(30.0);

        mockMvc.perform(get("/api/calculator/percentage")
                .param("total", "200")
                .param("percentage", "15"))
                .andExpect(status().isOk())
                .andExpect(content().string("30.0"));
    }

    @Test
    void testBitwiseAndEndpoint() throws Exception {
        when(calculatorService.bitwiseAnd(5, 3)).thenReturn(1);

        mockMvc.perform(get("/api/calculator/bitwise-and")
                .param("a", "5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void testBitwiseOrEndpoint() throws Exception {
        when(calculatorService.bitwiseOr(5, 3)).thenReturn(7);

        mockMvc.perform(get("/api/calculator/bitwise-or")
                .param("a", "5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("7"));
    }
}