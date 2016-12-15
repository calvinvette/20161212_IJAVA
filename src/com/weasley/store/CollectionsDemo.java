package com.weasley.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollectionsDemo {

	public static void main(String[] args) {
		Customer[] custArray = new Customer[3];
		custArray[0] = new HNICustomer("Harry", "Potter");
		custArray[1] = new Customer("Ron", "Weasley");
		custArray[2] = new Customer("Hermione", "Granger");
		
		Customer[] biggerArray = new Customer[custArray.length + 1];
		System.arraycopy(custArray, 0, biggerArray, 0, custArray.length);
		
		Runtime.getRuntime().gc(); // request GC to run...
		
		custArray = biggerArray;
		custArray[3] = new Customer("Neville", "Longbottom");
		
		dumpCustomers(Arrays.asList(custArray));
		
		
		List<Customer> custVector = new Vector<Customer>(1000, 10);
		custVector.add(new Customer("Dean", "Thomas"));
		custVector.add(new Customer("Seamus", "Finnegan"));
		custVector.add(new HNICustomer("Ginny", "Weasley-Potter"));

		
		dumpCustomers(custVector);
		
		System.out.println("***");
		System.out.println("custVector[1]: " + custVector.get(1));
		System.out.println("***");
		custVector.add(new Customer("Luna", "Lovegood"));
		
		System.out.println("# Customers in vector: " + custVector.size());

		dumpCustomers(custVector);

		List<Customer> custLL = new LinkedList<>();
		custLL.add(new HNICustomer("Fred", "Weasley"));
		custLL.add(new HNICustomer("George", "Weasley"));
		custLL.add(1, new Customer("Draco", "Malfoy"));
		
		dumpCustomers(custLL);
		
		custLL.remove(1); // custLL[1] - remove Draco at the second position; George will move up
		System.out.println("***");
		for (Customer c : custLL) {
			System.out.println(c);
		}
		
		System.out.println("***");
		System.out.println(custLL.get(1)); // Should now be George in position [1]
		
		List<Customer> custAL = new ArrayList<>();
		custAL.add(new Customer("Vincent", "Crabbe"));
		custAL.add(new Customer("Gregory", "Goyle"));
		custAL.add(new Customer("Blaise", "Zabini"));
		
		dumpCustomers(custAL);
		
		System.out.println("***");
		System.out.println(custAL.get(2)); // Should now be Blaise in position [2]
		
		// Convert List back in to an array
//		Customer[] custArrayFromArrayList = (Customer[]) custAL.toArray();
		
		Customer[] custArrayFromArrayList2 = new Customer[custAL.size()];
		custAL.toArray(custArrayFromArrayList2);
		
		
		List<Customer> finalList = new Vector<>(26, 5);
		finalList.addAll(Arrays.asList(custArray));
		finalList.addAll(custVector);
		finalList.addAll(custLL);
		finalList.addAll(custAL);
		dumpCustomers(finalList);
		
	}
	
	public static void dumpCustomers(List<Customer> customers) {
		System.out.println("***");
		System.out.println("# Customers in list: " + customers.size());
		//
		// customers.getClass(); // introspection & reflection
		for (Customer c : customers) {
			System.out.println(c);
		}
	}

}
