package com.danillo.customer.mapper;

import com.danillo.customer.entity.Customer;
import com.danillo.customer.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    CustomerDTO toCustomerDTO(Customer customer);

}
