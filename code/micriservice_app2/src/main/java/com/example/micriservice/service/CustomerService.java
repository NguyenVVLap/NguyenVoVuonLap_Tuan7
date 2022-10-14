package com.example.micriservice.service;

import com.example.micriservice.model.Customer;
import org.springframework.context.annotation.Bean;

import java.util.List;
public interface CustomerService {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
}
