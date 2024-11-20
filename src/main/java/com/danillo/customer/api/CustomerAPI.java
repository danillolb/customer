package com.danillo.customer.api;

import com.danillo.customer.model.CustomerDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/customer")
public interface CustomerAPI {

    @GetMapping("/{id}")
    CustomerDTO getCustomerById(@PathVariable Long id);
}
