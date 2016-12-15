package com.weasley.store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class CustomerMockDAO implements CustomerDAO {
	private Map<Long, Customer> customersById = new HashMap<>();
	private static long lastCustomerId = 0;
	
	@Override
	public Customer insert(Customer c) {
		c.setCustomerId(++lastCustomerId);
		customersById.put(lastCustomerId, c);
		return c;
	}

	@Override
	public Customer delete(Customer c) {
		return customersById.remove(c.getCustomerId());
	}

	@Override
	public Customer update(Customer c) {
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
		List<Customer> results = new Vector<>();
		for (Customer c : findAll()) {
			if (c.getLastName().equalsIgnoreCase(lastName)) {
				results.add(c);
			}
		}
  		return results;
	}

	@Override
	public List<Customer> findByEmail(String email) {
		List<Customer> results = new Vector<>();
		for (Customer c : findAll()) {
			if (c.getEmail().equalsIgnoreCase(email)) {
				results.add(c);
			}
		}
		return results;
	}

}
