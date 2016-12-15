package com.weasley.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class WeasleyCustomerManagement {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerMockDAO(); 
		List<Customer> customers = dao.findAll();
		boolean done = false;
		while (!done) {
			String lastName = JOptionPane.showInputDialog("Find By LastName: ");
			if (lastName == null || lastName.trim().equals("")) {
				done = true;
				continue;
			}
			List<Customer> results = dao.findByLastName(lastName);
			for(Customer c : results) {
				System.out.println(c);
			}
		}
		System.out.println("Thanks for playing!");
		
		try {
			PrintWriter dumpFile = new PrintWriter(new FileWriter(new File("customers.dump.txt")));
			for (Customer c : customers) {
				dumpFile.println(c);
			}
			dumpFile.flush();
			dumpFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
