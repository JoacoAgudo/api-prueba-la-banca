package com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.repository;

import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.entity.FibonacciQueryStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FibonacciQueryStatisticsRepository extends JpaRepository<FibonacciQueryStatistics, Long> {
    Optional<FibonacciQueryStatistics> findByN(int n);
}
