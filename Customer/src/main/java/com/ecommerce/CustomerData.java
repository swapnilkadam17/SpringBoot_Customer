package com.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerData {

	@Autowired
	private CustomerRepository repo;

	public List<Customer> listAll() {
		return repo.findAll();
	}

	public void save(Customer customer) {
		repo.save(customer);
	}

	public Customer get(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

}
