package com.weasley.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class CustomerMockDAO implements CustomerDAO {
	private static Map<Long, Customer> customersById = new HashMap<>();
	private static Map<String, List<Customer>> customersByLastName = new HashMap<>();
	private static Map<String, List<Customer>> customersByEmail = new HashMap<>();
	private static long lastCustomerId = 0;
	
	public static List<Customer> importCustomers() {
		List<Customer> importedCusts = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("customers.txt")));
			String line;
			br.readLine(); // throw away the first line - it's the header row...
			while ((line = br.readLine()) != null) {
					String[] fields = line.split("\t");
					Customer c = new Customer(fields[1], fields[2]);
					c.setPhoneNumber(fields[3]);
					importedCusts.add(c);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return importedCusts;
	}
	
	static {
		CustomerMockDAO dao = new CustomerMockDAO();
		for (Customer c : importCustomers()) {
			dao.insert(c);
		}
	}
	
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
		return customersByLastName.get(lastName);
	}

	@Override
	public List<Customer> findByEmail(String email) {
		return customersByEmail.get(email);
	}

}
