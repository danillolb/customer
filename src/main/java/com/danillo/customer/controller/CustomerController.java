package com.danillo.customer.controller;

import com.danillo.customer.api.CustomerAPI;
import com.danillo.customer.model.CustomerDTO;
import com.danillo.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController implements CustomerAPI {

    private final CustomerService customerService;

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerService.getCustomer(id);
    }
}
