package com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "fibonacci_query_statistics")
@NoArgsConstructor
@AllArgsConstructor
public class FibonacciQueryStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "n", unique = true, nullable = false)
    private int n;

    @Column(name = "query_count", nullable = false)
    private int queryCount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
