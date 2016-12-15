package com.weasley.store;

import java.util.List;

public interface CustomerDAO {
	public Customer insert(Customer c);
	public Customer delete(Customer c);
	public Customer update(Customer c);
	public List<Customer> findAll();
	public Customer findById(Long customerId);
	// Custom Finders for Customer
	public List<Customer> findByLastName(String lastName);
	public List<Customer> findByEmail(String email);
}
