package com.danillo.customer.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    void handleCustomerNotFoundException_ReturnsNotFoundStatus() {
        CustomerNotFoundException ex = new CustomerNotFoundException("Customer not found");
        WebRequest request = mock(WebRequest.class);

        ResponseEntity<Object> response = globalExceptionHandler.handleCustomerNotFoundException(ex, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Customer not found", response.getBody());
    }

    @Test
    void handleGlobalException_ReturnsInternalServerErrorStatus() {
        Exception ex = new Exception("Internal error");
        WebRequest request = mock(WebRequest.class);

        ResponseEntity<Object> response = globalExceptionHandler.handleGlobalException(ex, request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal Server Error", response.getBody());
    }

}