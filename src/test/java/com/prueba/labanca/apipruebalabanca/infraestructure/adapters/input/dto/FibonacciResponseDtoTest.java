package com.prueba.labanca.apipruebalabanca.infraestructure.adapters.input.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FibonacciResponseDtoTest {

    @Test
    void testNoArgsConstructor() {
        FibonacciResponseDto dto = new FibonacciResponseDto();
        assertNotNull(dto);
        assertNull(dto.getMessage());
        assertEquals(0L, dto.getValue());
    }

    @Test
    void testAllArgsConstructor() {
        FibonacciResponseDto dto = new FibonacciResponseDto();
        dto.setMessage("Success");
        dto.setValue(55L);

        assertEquals("Success", dto.getMessage());
        assertEquals(55L, dto.getValue());
    }

    @Test
    void testSettersAndGetters() {
        FibonacciResponseDto dto = new FibonacciResponseDto();
        dto.setMessage("Success");
        dto.setValue(144L);

        assertEquals("Success", dto.getMessage());
        assertEquals(144L, dto.getValue());
    }

    @Test
    void testEqualsAndHashCode() {
        FibonacciResponseDto dto1 = new FibonacciResponseDto();
        FibonacciResponseDto dto2 = new FibonacciResponseDto();
        dto1.setMessage("Success");
        dto1.setValue(55L);
        dto2.setMessage("Success");
        dto2.setValue(55L);
        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());

        dto2.setValue(89L);
        assertNotEquals(dto1, dto2);
        assertNotEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void testEqualsWithNullAndDifferentClass() {
        FibonacciResponseDto dto = new FibonacciResponseDto();
        dto.setMessage("Success");
        dto.setValue(55L);
        assertNotEquals(dto, null);
        assertNotEquals(dto, "Not a DTO");
    }

    @Test
    void testHashCodeWithDefaultValues() {
        FibonacciResponseDto dto = new FibonacciResponseDto();
        int hashCode = dto.hashCode();
        assertNotNull(hashCode);
    }

    @Test
    void testToString() {
        FibonacciResponseDto dto = new FibonacciResponseDto();
        dto.setMessage("Success");
        dto.setValue(55L);
        String toString = dto.toString();
        assertTrue(toString.contains("FibonacciResponseDto"));
        assertTrue(toString.contains("message=Success"));
        assertTrue(toString.contains("value=55"));
    }

    @Test
    void testBuilder() {
        FibonacciResponseDto dto = new FibonacciResponseDto();
        dto.setMessage("Success");
        dto.setValue(233L);

        assertEquals("Success", dto.getMessage());
        assertEquals(233L, dto.getValue());
    }

    @Test
    void testBuilderWithNullMessage() {
        FibonacciResponseDto dto = new FibonacciResponseDto();
        dto.setMessage(null);
        dto.setValue(144L);

        assertNull(dto.getMessage());
        assertEquals(144L, dto.getValue());
    }
}
