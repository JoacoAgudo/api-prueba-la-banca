package com.prueba.labanca.apipruebalabanca.infraestructure.application.service.impl;

import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.input.dto.FibonacciResponseDto;
import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.entity.FibonacciResultsEntity;
import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.repository.FibonacciQueryStatisticsRepository;
import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.repository.FibonacciResultRepository;
import com.prueba.labanca.apipruebalabanca.infraestructure.application.services.impl.FibonacciServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FibonacciServiceImplTest {
    @InjectMocks
    FibonacciServiceImpl fibonacciService;
    @Mock
    private FibonacciResultRepository fibonacciResultRepository;

    @Mock
    private FibonacciQueryStatisticsRepository queryStatisticsRepository;

    @Test
    void shouldReturnCachedValueWhenExists() {
        int n = 10;
        FibonacciResultsEntity cachedResult = new FibonacciResultsEntity();
        cachedResult.setN(n);
        cachedResult.setValue("55");
        when(fibonacciResultRepository.findFirstByN(n)).thenReturn(cachedResult);

        FibonacciResponseDto response = fibonacciService.calculateFibonacci(n);

        assertNotNull(response);
        assertEquals(55, response.getValue());
        assertEquals("Cached Value: 55", response.getMessage());
    }

    @Test
    void shouldCalculateAndStoreFibonacciWhenNotCached() {
        int n = 5;
        when(fibonacciResultRepository.findFirstByN(n)).thenReturn(null);

        FibonacciResponseDto response = fibonacciService.calculateFibonacci(n);

        assertNotNull(response);
        assertEquals(5, response.getValue());
        assertEquals("Number retrieved is: 5", response.getMessage());
    }

    @Test
    void shouldReturnCorrectMessageAndValueWhenNIsLessThanOrEqualToOne() {
        int n = 0;
        FibonacciResponseDto response = fibonacciService.calculateFibonacci(n);

        assertNotNull(response);
        assertEquals(0, response.getValue());
        assertEquals("Number retrieved is: 0", response.getMessage());

        n = 1;
        response = fibonacciService.calculateFibonacci(n);

        assertNotNull(response);
        assertEquals(1, response.getValue());
        assertEquals("Number retrieved is: 1", response.getMessage());
    }


}
