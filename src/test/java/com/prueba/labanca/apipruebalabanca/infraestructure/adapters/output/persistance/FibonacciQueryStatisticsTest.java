package com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance;

import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.entity.FibonacciQueryStatistics;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FibonacciQueryStatisticsTest {

    @Test
    void testNoArgsConstructor() {
        FibonacciQueryStatistics entity = new FibonacciQueryStatistics();
        assertNotNull(entity);
        assertNull(entity.getId());
        assertEquals(0, entity.getN());
        assertEquals(0, entity.getQueryCount());
        assertNull(entity.getCreatedAt());
        assertNull(entity.getUpdatedAt());
    }

    @Test
    void testAllArgsConstructor() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciQueryStatistics entity = new FibonacciQueryStatistics(1L, 10, 5, now, now);

        assertEquals(1L, entity.getId());
        assertEquals(10, entity.getN());
        assertEquals(5, entity.getQueryCount());
        assertEquals(now, entity.getCreatedAt());
        assertEquals(now, entity.getUpdatedAt());
    }

    @Test
    void testBuilder() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciQueryStatistics entity = FibonacciQueryStatistics.builder()
                .id(1L)
                .n(10)
                .queryCount(5)
                .createdAt(now)
                .updatedAt(now)
                .build();

        assertEquals(1L, entity.getId());
        assertEquals(10, entity.getN());
        assertEquals(5, entity.getQueryCount());
        assertEquals(now, entity.getCreatedAt());
        assertEquals(now, entity.getUpdatedAt());
    }

    @Test
    void testEqualsAndHashCode() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciQueryStatistics entity1 = new FibonacciQueryStatistics(1L, 10, 5, now, now);
        FibonacciQueryStatistics entity2 = new FibonacciQueryStatistics(1L, 10, 5, now, now);

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());

        entity2.setQueryCount(10);
        assertNotEquals(entity1, entity2);
        assertNotEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    void testEqualsWithNullAndDifferentClass() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciQueryStatistics entity = new FibonacciQueryStatistics(1L, 10, 5, now, now);

        assertNotEquals(entity, null);
        assertNotEquals(entity, "Not an Entity");
    }

    @Test
    void testHashCodeWithNullProperties() {
        FibonacciQueryStatistics entity = new FibonacciQueryStatistics(null, 0, 0, null, null);

        int hashCode = entity.hashCode();
        assertNotNull(hashCode);
    }

    @Test
    void testToString() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciQueryStatistics entity = FibonacciQueryStatistics.builder()
                .id(1L)
                .n(10)
                .queryCount(5)
                .createdAt(now)
                .updatedAt(now)
                .build();

        String toString = entity.toString();
        assertTrue(toString.contains("FibonacciQueryStatistics"));
    }

    @Test
    void testEqualsDifferentFields() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciQueryStatistics entity1 = new FibonacciQueryStatistics(1L, 10, 5, now, now);
        FibonacciQueryStatistics entity2 = new FibonacciQueryStatistics(2L, 20, 10, now.minusDays(1), now.minusDays(1));

        assertNotEquals(entity1, entity2);
        entity2.setId(1L);
        assertNotEquals(entity1, entity2);
        entity2.setN(10);
        assertNotEquals(entity1, entity2);
        entity2.setQueryCount(5);
        assertNotEquals(entity1, entity2);
        entity2.setCreatedAt(now);
        assertNotEquals(entity1, entity2);
        entity2.setUpdatedAt(now);
        assertEquals(entity1, entity2);
    }

    @Test
    void testHashCodeDifferentFields() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciQueryStatistics entity1 = new FibonacciQueryStatistics(1L, 10, 5, now, now);
        FibonacciQueryStatistics entity2 = new FibonacciQueryStatistics(2L, 20, 10, now.minusDays(1), now.minusDays(1));

        assertNotEquals(entity1.hashCode(), entity2.hashCode());
        entity2.setId(1L);
        entity2.setN(10);
        entity2.setQueryCount(5);
        entity2.setCreatedAt(now);
        entity2.setUpdatedAt(now);
        assertEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    void testToStringWithNullFields() {
        FibonacciQueryStatistics entity = new FibonacciQueryStatistics(null, 0, 0, null, null);

        String toString = entity.toString();
        assertTrue(toString.contains("FibonacciQueryStatistics"));
        assertTrue(toString.contains("id=null"));
        assertTrue(toString.contains("n=0"));
        assertTrue(toString.contains("queryCount=0"));
        assertTrue(toString.contains("createdAt=null"));
        assertTrue(toString.contains("updatedAt=null"));
    }

    @Test
    void testBuilderPartialValues() {
        FibonacciQueryStatistics entity = FibonacciQueryStatistics.builder()
                .n(20)
                .queryCount(15)
                .build();

        assertNull(entity.getId());
        assertEquals(20, entity.getN());
        assertEquals(15, entity.getQueryCount());
        assertNull(entity.getCreatedAt());
        assertNull(entity.getUpdatedAt());
    }

    @Test
    void testEqualsConsistency() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciQueryStatistics entity1 = new FibonacciQueryStatistics(1L, 10, 5, now, now);
        FibonacciQueryStatistics entity2 = new FibonacciQueryStatistics(1L, 10, 5, now, now);
        FibonacciQueryStatistics entity3 = new FibonacciQueryStatistics(1L, 10, 5, now, now);

        assertEquals(entity1, entity1);

        assertEquals(entity1, entity2);
        assertEquals(entity2, entity1);
        assertEquals(entity1, entity2);
        assertEquals(entity2, entity3);
        assertEquals(entity1, entity3);

        assertEquals(entity1, entity2);
        assertEquals(entity1, entity2);
    }

    @Test
    void testSpecialCaseForN() {
        FibonacciQueryStatistics entity = FibonacciQueryStatistics.builder().n(0).build();
        assertEquals(0, entity.getN());
    }

    @Test
    void testEqualsReflexive() {
        FibonacciQueryStatistics entity = new FibonacciQueryStatistics(1L, 10, 5, LocalDateTime.now(), LocalDateTime.now());
        assertEquals(entity, entity);
    }

    @Test
    void testEqualsWithNullAttributes() {
        FibonacciQueryStatistics entity1 = new FibonacciQueryStatistics(1L, 10, 5, null, null);
        FibonacciQueryStatistics entity2 = new FibonacciQueryStatistics(1L, 10, 5, null, null);

        assertEquals(entity1, entity2);
    }

    @Test
    void testEqualsWithNullId() {
        FibonacciQueryStatistics entity1 = new FibonacciQueryStatistics(null, 10, 5, null, null);
        FibonacciQueryStatistics entity2 = new FibonacciQueryStatistics(null, 10, 5, null, null);

        assertEquals(entity1, entity2);
    }

    @Test
    void testEqualsWithDifferentClass() {
        FibonacciQueryStatistics entity = new FibonacciQueryStatistics(1L, 10, 5, LocalDateTime.now(), LocalDateTime.now());
        assertNotEquals(entity, new Object());
    }

    @Test
    void testEqualsWithDifferentTimes() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime differentTime = now.plusMinutes(1);
        FibonacciQueryStatistics entity1 = new FibonacciQueryStatistics(1L, 10, 5, now, now);
        FibonacciQueryStatistics entity2 = new FibonacciQueryStatistics(1L, 10, 5, differentTime, differentTime);

        assertNotEquals(entity1, entity2);
    }

    @Test
    void testEqualsSingleFieldChange() {
        FibonacciQueryStatistics entity1 = new FibonacciQueryStatistics(1L, 10, 5, LocalDateTime.now(), LocalDateTime.now());
        FibonacciQueryStatistics entity2 = new FibonacciQueryStatistics(1L, 10, 6, LocalDateTime.now(), LocalDateTime.now());  // Solo cambia `queryCount`

        assertNotEquals(entity1, entity2);
    }

    @Test
    void testEqualsAfterChangingAttributes() {
        FibonacciQueryStatistics entity1 = new FibonacciQueryStatistics(1L, 10, 5, null, null);
        FibonacciQueryStatistics entity2 = new FibonacciQueryStatistics(1L, 10, 5, null,null);

        assertEquals(entity1, entity2);

        entity1.setQueryCount(10);
        assertNotEquals(entity1, entity2);
    }







}


