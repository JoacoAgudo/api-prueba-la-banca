package com.prueba.labanca.apipruebalabanca.infraestructure.application.services;

import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.input.dto.FibonacciResponseDto;

public interface FibonacciService {
    FibonacciResponseDto calculateFibonacci(int n);
}
