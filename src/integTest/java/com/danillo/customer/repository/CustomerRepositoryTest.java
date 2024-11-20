package com.danillo.customer.repository;

import com.danillo.customer.IntegrationTestBase;
import com.danillo.customer.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerRepositoryTest extends IntegrationTestBase {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testSaveAndFindCustomer() {
        Customer customer = new Customer();
        customer.setName("Test Customer");
        customer.setVip(true);
        Customer savedProduct = customerRepository.save(customer);

        assertThat(savedProduct.getId()).isNotNull();
        assertThat(savedProduct.getName()).isEqualTo("Test Customer");

        Optional<Customer> foundProduct = customerRepository.findById(1L);
        assertThat(foundProduct).isPresent();
        assertThat(foundProduct.get().getName()).isEqualTo("Test Customer");
    }
}
