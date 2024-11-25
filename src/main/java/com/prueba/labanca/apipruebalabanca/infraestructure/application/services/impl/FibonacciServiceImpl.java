package com.prueba.labanca.apipruebalabanca.infraestructure.application.services.impl;

import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.input.dto.FibonacciResponseDto;
import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.entity.FibonacciQueryStatistics;
import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.entity.FibonacciResultsEntity;
import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.repository.FibonacciQueryStatisticsRepository;
import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.repository.FibonacciResultRepository;
import com.prueba.labanca.apipruebalabanca.infraestructure.application.services.FibonacciService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;

@Slf4j
@Service
@RequiredArgsConstructor
public class FibonacciServiceImpl implements FibonacciService {
    @Autowired
    private FibonacciResultRepository fibonacciResultRepository;
    @Autowired
    private FibonacciQueryStatisticsRepository fibonacciQueryStatisticsRepository;

    @Override
    @Cacheable(value = "fibonacciCache", key = "#n")
    public FibonacciResponseDto calculateFibonacci(int n) {
        FibonacciResultsEntity existingResult = fibonacciResultRepository.findFirstByN(n);

        if (existingResult != null) {
            log.info("FibonacciServiceImpl - Returning cached value for n = {}", n);
            incrementQueryCount(n);
            FibonacciResponseDto response = new FibonacciResponseDto();
            response.setMessage("Cached Value: " + existingResult.getValue());
            response.setValue(Long.parseLong(existingResult.getValue()));
            return response;
        }

        log.info("FibonacciServiceImpl - Starting calculate fibonacci number for n = {}", n);
        FibonacciResponseDto response = new FibonacciResponseDto();
        long a = 0, b = 1, c = 0;

        if (n <= 1) {
            response.setMessage("Number retrieved is: " + n);
            response.setValue(n);
        } else {
            for (int i = 2; i < n; i++) {
                c = a + b;
                a = b;
                b = c;

                FibonacciResultsEntity intermediateResult = new FibonacciResultsEntity();
                intermediateResult.setN(i);
                intermediateResult.setCreatedAt(LocalDateTime.now());
                intermediateResult.setUpdatedAt(LocalDateTime.now());
                intermediateResult.setValue(String.valueOf(c));
                fibonacciResultRepository.save(intermediateResult);
                log.info("FibonacciServiceImpl - Stored intermediate result for n = {}: {}", i, c);
            }
            c = a + b;
            response.setMessage("Number retrieved is: " + c);
            response.setValue(c);

            FibonacciResultsEntity result = new FibonacciResultsEntity();
            result.setN(n);
            result.setCreatedAt(LocalDateTime.now());
            result.setUpdatedAt(LocalDateTime.now());
            result.setValue(String.valueOf(c));
            fibonacciResultRepository.save(result);
            log.info("FibonacciServiceImpl - Stored final result in database for n = {}: {}", n, c);
        }

        log.info("FibonacciServiceImpl - Finished calculate fibonacci number for n = {} with value: {}", n, response.getValue());
        incrementQueryCount(n);
        return response;
    }

    private void incrementQueryCount(int n) {
        Optional<FibonacciQueryStatistics> existingStats = fibonacciQueryStatisticsRepository.findByN(n);

        FibonacciQueryStatistics stats;
        if (existingStats.isPresent()) {
            stats = existingStats.get();
            stats.setQueryCount(stats.getQueryCount() + 1);
        } else {
            stats = new FibonacciQueryStatistics();
            stats.setN(n);
            stats.setQueryCount(1);
            stats.setCreatedAt(LocalDateTime.now());
        }
        stats.setUpdatedAt(LocalDateTime.now());
        fibonacciQueryStatisticsRepository.save(stats);
    }
}
