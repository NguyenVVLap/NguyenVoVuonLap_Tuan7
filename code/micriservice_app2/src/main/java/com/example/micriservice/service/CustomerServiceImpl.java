package com.example.micriservice.service;

import java.util.List;
import java.util.Optional;

import com.example.micriservice.model.Customer;
import com.example.micriservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    // need to inject customer dao
    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);    }
 
    @Override
    public Customer getCustomer(int theId) {
        Optional<Customer> customer = customerRepository.findById(theId);
            return customer.get();   }
    @Override
    public void deleteCustomer(int theId) {
        customerRepository.deleteById(theId);   }
   
    @Override
    public List<Customer> getCustomers() {
            return customerRepository.findAll();
    }
    
}





