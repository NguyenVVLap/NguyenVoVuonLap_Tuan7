package com.example.micriservice.service;

import java.util.List;

import com.example.micriservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CustomerServiceRestClientImpl implements CustomerService {
	private RestTemplate restTemplate;
	private String crmRestUrl = "http://localhost:8080/api/customers";

	public CustomerServiceRestClientImpl() {
		this.restTemplate = new RestTemplate();
	}

	@Override
	public List<Customer> getCustomers() {
		ResponseEntity<List<Customer>> responseEntity =
			restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Customer>>() {});
		List<Customer> customers = responseEntity.getBody();
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		int customerId = theCustomer.getId();
		if (customerId == 0) {
			restTemplate.postForObject(crmRestUrl, theCustomer, String.class);
		} else {
			restTemplate.put(crmRestUrl, theCustomer);
		}
	}

	@Override
	public Customer getCustomer(int theId) {
		Customer theCustomer = restTemplate.getForObject(crmRestUrl + "/" + theId, Customer.class);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		restTemplate.delete(crmRestUrl + "/" + theId);
		
	}

}
