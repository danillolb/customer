package com.danillo.customer.controller;

import com.danillo.customer.exception.CustomerNotFoundException;
import com.danillo.customer.model.CustomerDTO;
import com.danillo.customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void getCustomerById_ReturnsCustomer() throws Exception {
        Long customerId = 1L;
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        Mockito.when(customerService.getCustomer(customerId)).thenReturn(customerDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customer/{customerId}", customerId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(customerDTO.getId()));
    }

    @Test
    void getCustomerById_CustomerNotFound() throws Exception {
        Long customerId = 1L;
        Mockito.when(customerService.getCustomer(customerId)).thenThrow(new CustomerNotFoundException("Customer not found"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customer/{customerId}", customerId))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("Customer not found"));
    }
}