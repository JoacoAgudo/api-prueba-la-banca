package com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance;

import com.prueba.labanca.apipruebalabanca.infraestructure.adapters.output.persistance.entity.FibonacciResultsEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FibonacciResultsEntityTest {
    @Test
    void testNoArgsConstructor() {
        FibonacciResultsEntity entity = new FibonacciResultsEntity();
        assertNotNull(entity);
        assertNull(entity.getId());
    }

    @Test
    void testAllArgsConstructor() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity = new FibonacciResultsEntity(1L, 10, "55", now, now);
        assertEquals(1L, entity.getId());
        assertEquals(10, entity.getN());
        assertEquals("55", entity.getValue());
        assertEquals(now, entity.getCreatedAt());
        assertEquals(now, entity.getUpdatedAt());
    }

    @Test
    void testBuilder() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity = FibonacciResultsEntity.builder()
                .id(1L)
                .n(10)
                .value("55")
                .createdAt(now)
                .updatedAt(now)
                .build();

        assertEquals(1L, entity.getId());
        assertEquals(10, entity.getN());
        assertEquals("55", entity.getValue());
        assertEquals(now, entity.getCreatedAt());
        assertEquals(now, entity.getUpdatedAt());
    }

    @Test
    void testEqualsAndHashCode() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(1L, 10, "55", now, now);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(1L, 10, "55", now, now);

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());

        entity2.setN(20);
        assertNotEquals(entity1, entity2);
        assertNotEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    void testToString() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity = FibonacciResultsEntity.builder()
                .id(1L)
                .n(10)
                .value("55")
                .createdAt(now)
                .updatedAt(now)
                .build();

        String toString = entity.toString();
        assertTrue(toString.contains("FibonacciResultsEntity"));
        assertTrue(toString.contains("id=1"));
        assertTrue(toString.contains("n=10"));
        assertTrue(toString.contains("value=55"));
        assertTrue(toString.contains("createdAt="));
        assertTrue(toString.contains("updatedAt="));
    }

    @Test
    void testEqualsWithNullAndDifferentClass() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity = new FibonacciResultsEntity(1L, 10, "55", now, now);

        assertNotEquals(entity, null);
        assertNotEquals(entity, "Not an Entity");
    }

    @Test
    void testHashCodeWithNullProperties() {
        FibonacciResultsEntity entity = new FibonacciResultsEntity(null, 0, null, null, null);

        int hashCode = entity.hashCode();
        assertNotNull(hashCode);
    }

    @Test
    void testEqualsAndHashCodeConsistency() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(1L, 10, "55", now, now);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(1L, 10, "55", now, now);

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    void testBuilderWithExtremeValues() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity = FibonacciResultsEntity.builder()
                .id(Long.MAX_VALUE)
                .n(Integer.MAX_VALUE)
                .value("A very large Fibonacci number")
                .createdAt(now)
                .updatedAt(now)
                .build();

        assertEquals(Long.MAX_VALUE, entity.getId());
        assertEquals(Integer.MAX_VALUE, entity.getN());
        assertEquals("A very large Fibonacci number", entity.getValue());
    }

    @Test
    void testSetters() {
        FibonacciResultsEntity entity = new FibonacciResultsEntity();
        LocalDateTime now = LocalDateTime.now();

        entity.setId(2L);
        entity.setN(20);
        entity.setValue("610");
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);

        assertEquals(2L, entity.getId());
        assertEquals(20, entity.getN());
        assertEquals("610", entity.getValue());
        assertEquals(now, entity.getCreatedAt());
        assertEquals(now, entity.getUpdatedAt());
    }

    @Test
    void testEqualsWithNullProperties() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(null, 10, "55", now, now);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(null, 10, "55", now, now);

        assertEquals(entity1, entity2);

        entity2.setN(20);
        assertNotEquals(entity1, entity2);
    }

    @Test
    void testEqualsWithMixedProperties() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(1L, 10, "55", now, now);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(null, 10, "55", now, now);

        assertNotEquals(entity1, entity2);
    }

    @Test
    void testHashCodeConsistencyAfterChange() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity = new FibonacciResultsEntity(1L, 10, "55", now, now);

        int originalHashCode = entity.hashCode();
        entity.setN(20);
        int newHashCode = entity.hashCode();

        assertNotEquals(originalHashCode, newHashCode);
    }

    @Test
    void testToStringWithNullProperties() {
        FibonacciResultsEntity entity = new FibonacciResultsEntity(null, 0, null, null, null);

        String toString = entity.toString();
        assertTrue(toString.contains("FibonacciResultsEntity"));
        assertTrue(toString.contains("id=null"));
        assertTrue(toString.contains("n=0"));
        assertTrue(toString.contains("value=null"));
        assertTrue(toString.contains("createdAt=null"));
        assertTrue(toString.contains("updatedAt=null"));
    }

    @Test
    void testBuilderWithNullValues() {
        FibonacciResultsEntity entity = FibonacciResultsEntity.builder()
                .id(null)
                .n(0)
                .value(null)
                .createdAt(null)
                .updatedAt(null)
                .build();

        assertNull(entity.getId());
        assertEquals(0, entity.getN());
        assertNull(entity.getValue());
        assertNull(entity.getCreatedAt());
        assertNull(entity.getUpdatedAt());
    }

    @Test
    void testEqualsWithDifferentId() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(1L, 10, "55", now, now);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(2L, 10, "55", now, now);

        assertNotEquals(entity1, entity2);
    }

    @Test
    void testEqualsWithNullFields() {
        FibonacciResultsEntity entity = new FibonacciResultsEntity(null, 0, null, null, null);
        assertNotEquals(entity, null);
        assertNotEquals(entity, "Not an Entity");
    }

    @Test
    void testHashCodeConsistencyWithNullProperties() {
        FibonacciResultsEntity entity = new FibonacciResultsEntity(null, 0, null, null, null);
        int hashCode = entity.hashCode();
        assertNotNull(hashCode);
    }

    @Test
    void testHashCodeConsistencyWithChangedProperties() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity = new FibonacciResultsEntity(1L, 10, "55", now, now);

        int originalHashCode = entity.hashCode();
        entity.setValue("100");
        int newHashCode = entity.hashCode();

        assertNotEquals(originalHashCode, newHashCode);
    }

    @Test
    void testBuilderWithNullValues2() {
        FibonacciResultsEntity entity = FibonacciResultsEntity.builder()
                .id(null)
                .n(0)
                .value(null)
                .createdAt(null)
                .updatedAt(null)
                .build();

        assertNull(entity.getId());
        assertEquals(0, entity.getN());
        assertNull(entity.getValue());
        assertNull(entity.getCreatedAt());
        assertNull(entity.getUpdatedAt());
    }

    @Test
    void testBuilderWithEmptyString() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity = FibonacciResultsEntity.builder()
                .id(2L)
                .n(5)
                .value("")
                .createdAt(now)
                .updatedAt(now)
                .build();

        assertEquals(2L, entity.getId());
        assertEquals(5, entity.getN());
        assertEquals("", entity.getValue());
    }

    @Test
    void testEqualsAndHashCodeWithEmptyString() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(1L, 10, "55", now, now);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(1L, 10, "55", now, now);

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());

        entity2.setValue("100");
        assertNotEquals(entity1, entity2);
        assertNotEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    void testEqualsSameObject() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity = new FibonacciResultsEntity(1L, 10, "55", now, now);

        assertEquals(entity, entity);
    }

    @Test
    void testEqualsNull() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity = new FibonacciResultsEntity(1L, 10, "55", now, now);

        assertNotEquals(entity, null);
    }

    @Test
    void testEqualsDifferentClass() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity = new FibonacciResultsEntity(1L, 10, "55", now, now);

        assertNotEquals(entity, new Object());
    }

    @Test
    void testEqualsDifferentId() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(1L, 10, "55", now, now);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(2L, 10, "55", now, now);

        assertNotEquals(entity1, entity2);
    }

    @Test
    void testEqualsDifferentN() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(1L, 10, "55", now, now);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(1L, 20, "55", now, now);

        assertNotEquals(entity1, entity2);
    }

    @Test
    void testEqualsDifferentValue() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(1L, 10, "55", now, now);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(1L, 10, "100", now, now);

        assertNotEquals(entity1, entity2);
    }

    @Test
    void testEqualsDifferentCreatedAt() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime differentTime = now.minusDays(1);
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(1L, 10, "55", now, now);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(1L, 10, "55", differentTime, now);

        assertNotEquals(entity1, entity2);
    }

    @Test
    void testEqualsDifferentUpdatedAt() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime differentTime = now.minusDays(1);
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(1L, 10, "55", now, now);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(1L, 10, "55", now, differentTime);

        assertNotEquals(entity1, entity2);
    }

    @Test
    void testEqualsAllPropertiesEqual() {
        LocalDateTime now = LocalDateTime.now();
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(1L, 10, "55", now, now);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(1L, 10, "55", now, now);

        assertEquals(entity1, entity2);
    }

    @Test
    void testEqualsWithNullProperties2() {
        FibonacciResultsEntity entity1 = new FibonacciResultsEntity(null, 10, "55", null, null);
        FibonacciResultsEntity entity2 = new FibonacciResultsEntity(null, 10, "55", null, null);

        assertEquals(entity1, entity2);
    }





}
