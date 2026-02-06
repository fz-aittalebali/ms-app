package com.isga.customerservice.mappers;

import com.isga.customerservice.dtos.CustomerRequestDTO;
import com.isga.customerservice.dtos.CustomerResponseDTO;
import com.isga.customerservice.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public CustomerResponseDTO mapEntityToResponseDTO(Customer customer) {
        CustomerResponseDTO responseDTO = new CustomerResponseDTO();
        BeanUtils.copyProperties(customer, responseDTO);
        return responseDTO;
    }

    public Customer mapRequestDTOToEntity(CustomerRequestDTO requestDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(requestDTO, customer);
        return customer;
    }
}