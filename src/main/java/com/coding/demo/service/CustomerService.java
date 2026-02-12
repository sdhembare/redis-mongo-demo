package com.coding.demo.service;

import com.coding.demo.model.Customer;
import com.coding.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public Customer saveCustomer(Customer customer) {
        return customerRepository.insert(customer);
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

}
