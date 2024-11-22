package com.prueba.labanca.apipruebalabanca.infraestructure.adapters.input.rest.controllers;

import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.input.dto.FibonacciResponseDto;
import com.prueba.labanca.apipruebalabanca.infraestructure.application.services.FibonacciService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/fibonacci")
@RequiredArgsConstructor
@Slf4j
public class FibonacciController {
    private final FibonacciService fibonacciService;

    @GetMapping("/{n}")
    public ResponseEntity<FibonacciResponseDto> getFibonacci(@PathVariable int n){
        log.info("FibonacciController - getFibonacci - Start getFibonacci method");
        if(n < 0 ){
            throw new IllegalArgumentException("The value must be greater or equals than 0");
        }
        FibonacciResponseDto response = fibonacciService.calculateFibonacci(n);
        log.info("FibonacciController - getFibonacci - Finish getFibonacci method with value: {}",n);
        return ResponseEntity.ok().body(response);
    }
}
