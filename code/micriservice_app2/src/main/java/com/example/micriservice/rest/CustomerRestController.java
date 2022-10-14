package com.example.micriservice.rest;

import java.util.List;

import com.example.micriservice.model.Customer;
import com.example.micriservice.service.CustomerService;
import com.example.micriservice.service.CustomerServiceRestClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private CustomerService customerService = new CustomerServiceRestClientImpl();

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomer(customerId);
		if (theCustomer == null) {
			return null;
		}
		return theCustomer;
	}

	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}

	@DeleteMapping("/customers/{customerId}")
	public Customer deleteCustomer(@PathVariable int customerId) {
		Customer tempCustomer = customerService.getCustomer(customerId);
		if (tempCustomer == null) {
			return null;
		}
		customerService.deleteCustomer(customerId);
		return tempCustomer;
	}
}
