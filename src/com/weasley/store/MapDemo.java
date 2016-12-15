package com.weasley.store;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		// Map implementations include:
		// Hashtable - thread safe classic hashtable
		// HashMap - unthread-safe hashtable
		// TreeMap - HashMap with internal sorting (implements SortedMap)
		Map<String, Customer> customerMap = new HashMap<>();
		customerMap.put("Potter,Harry", new Customer("Harry", "Potter"));
		customerMap.put("Weasley,Ron", new Customer("Ron", "Weasley"));
		customerMap.put("Granger,Hermione", new Customer("Hermione", "Granger"));
		customerMap.put("Longbottom,Neville", new Customer("Neville", "Longbottom"));
		customerMap.put("Finnegan,Seamus", new Customer("Seamus", "Finnegan"));
		customerMap.put("Thomas,Dean", new Customer("Dean", "Thomas"));
		customerMap.put("Weasley,Ginny", new Customer("Ginny", "Weasley"));
		
		// Set guarantees uniqueness (no duplicates, no ordering
		// 	(uniqueness determined by hashCode)
		//	(no indexing)
		// List guarantees ordering, can have duplicates
		
		Customer ginny = customerMap.get("Weasley,Ginny");
		System.out.println(ginny);
		
		System.out.println("***");
		for (Customer c : customerMap.values()) {
			System.out.println(c);
		}
		
		System.out.println("***");
		for (String key : customerMap.keySet()) {
			Customer c = customerMap.get(key);
			System.out.println(c);
		}
		
		System.out.println("***");
		for (Map.Entry<String, Customer> linkage : customerMap.entrySet()) {
			System.out.println(linkage.getKey() + "\t" + linkage.getValue());
		}
	}
}
