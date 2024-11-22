package com.prueba.labanca.apipruebalabanca.infraestructure.adapters.input.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.input.dto.FibonacciResponseDto;
import com.prueba.labanca.apipruebalabanca.infraestructure.application.services.FibonacciService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FibonacciController.class)
public class FibonacciControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FibonacciService fibonacciService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetFibonacciSuccess() throws Exception {
        FibonacciResponseDto mockResponse = new FibonacciResponseDto();
        mockResponse.setMessage("Fibonacci number calculated successfully");
        mockResponse.setValue(55L);
        Mockito.when(fibonacciService.calculateFibonacci(10)).thenReturn(mockResponse);

        mockMvc.perform(get("/api/fibonacci/10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Fibonacci number calculated successfully"))
                .andExpect(jsonPath("$.value").value(55));
    }

    @Test
    void testLogging() throws Exception {
        FibonacciResponseDto mockResponse = new FibonacciResponseDto();
        mockResponse.setMessage("Fibonacci number calculated successfully");
        mockResponse.setValue(89);
        Mockito.when(fibonacciService.calculateFibonacci(11)).thenReturn(mockResponse);

        mockMvc.perform(get("/api/fibonacci/11")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(fibonacciService, Mockito.times(1)).calculateFibonacci(11);
    }
}
