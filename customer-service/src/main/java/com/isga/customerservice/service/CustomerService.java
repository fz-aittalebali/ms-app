package com.isga.customerservice.service;

import com.isga.customerservice.dtos.CustomerRequestDTO;
import com.isga.customerservice.dtos.CustomerResponseDTO;
import com.isga.customerservice.entities.Customer;
import com.isga.customerservice.mappers.CustomerMapper;
import com.isga.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerResponseDTO> getAllCustomers(){
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::mapEntityToResponseDTO)
                .toList();
    }

    public CustomerResponseDTO findCustomerById(Long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));
        return customerMapper.mapEntityToResponseDTO(customer);
    }

    public CustomerResponseDTO saveCustomer(CustomerRequestDTO requestDTO){
        Customer customer = customerMapper.mapRequestDTOToEntity(requestDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.mapEntityToResponseDTO(savedCustomer);
    }
}
