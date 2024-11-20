package com.danillo.customer.service;

import com.danillo.customer.entity.Customer;
import com.danillo.customer.exception.CustomerNotFoundException;
import com.danillo.customer.mapper.EntityMapper;
import com.danillo.customer.model.CustomerDTO;
import com.danillo.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final EntityMapper entityMapper;

    public CustomerDTO getCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        return entityMapper.toCustomerDTO(customer);
    }
}