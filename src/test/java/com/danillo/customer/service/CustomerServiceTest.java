package com.danillo.customer.service;

import com.danillo.customer.entity.Customer;
import com.danillo.customer.exception.CustomerNotFoundException;
import com.danillo.customer.mapper.EntityMapper;
import com.danillo.customer.model.CustomerDTO;
import com.danillo.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private EntityMapper entityMapper;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void getCustomer_CustomerNotFound() {
        Long customerId = 1L;
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomer(customerId));
    }

    @Test
    void getCustomer_Success() {
        Long customerId = 1L;
        Customer customer = new Customer();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerId);

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(entityMapper.toCustomerDTO(customer)).thenReturn(customerDTO);

        CustomerDTO result = customerService.getCustomer(customerId);

        assertEquals(customerDTO, result);
    }
}