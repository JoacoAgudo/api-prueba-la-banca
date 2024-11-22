package com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.repository;

import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.entity.FibonacciResultsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FibonacciResultRepository extends JpaRepository<FibonacciResultsEntity, Long> {
    FibonacciResultsEntity findFirstByN(int n);
}

