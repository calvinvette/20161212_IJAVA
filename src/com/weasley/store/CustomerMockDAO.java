package com.weasley.store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class CustomerMockDAO implements CustomerDAO {
	private Map<Long, Customer> customersById = new HashMap<>();
	private Map<String, List<Customer>> customersByLastName = new HashMap<>();
	private Map<String, List<Customer>> customersByEmail = new HashMap<>();
	private static long lastCustomerId = 0;
	
	@Override
	public Customer insert(Customer c) {
		c.setCustomerId(++lastCustomerId);
		customersById.put(lastCustomerId, c);
		List<Customer> withLastName = customersByLastName.get(c.getLastName());
		if (withLastName == null) {
			withLastName = new Vector<>();
		}
		withLastName.add(c);
		customersByLastName.put(c.getLastName(), withLastName);
		List<Customer> withEmail = customersByEmail.get(c.getEmail());
		if (withEmail == null) {
			withEmail = new Vector<>();
		}
		withEmail.add(c);
		customersByEmail.put(c.getEmail(), withEmail);
		return c;
	}

	@Override
	public Customer delete(Customer c) {
		// TODO - update indexes for customersByEmail and customersByLastName
		return customersById.remove(c.getCustomerId());
	}

	@Override
	public Customer update(Customer c) {
		// TODO - update indexes for customersByEmail and customersByLastName
		return customersById.put(c.getCustomerId(), c);
	}

	@Override
	public List<Customer> findAll() {
		return new Vector<>(customersById.values());
	}

	@Override
	public Customer findById(Long customerId) {
		return customersById.get(customerId);
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
//		List<Customer> results = new Vector<>();
//		for (Customer c : findAll()) {
//			if (c.getLastName().equalsIgnoreCase(lastName)) {
//				results.add(c);
//			}
//		}
//  		return results;
		return customersByLastName.get(lastName);
	}

	@Override
	public List<Customer> findByEmail(String email) {
//		List<Customer> results = new Vector<>();
//		for (Customer c : findAll()) {
//			if (c.getEmail().equalsIgnoreCase(email)) {
//				results.add(c);
//			}
//		}
//		return results;
		return customersByEmail.get(email);
	}

}
