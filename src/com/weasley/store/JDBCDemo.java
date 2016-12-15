package com.weasley.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class JDBCDemo {

	public static void main(String[] args) {
		List<Customer> imported = WeasleyCustomerManagement.importCustomers();
		Connection conn = null;
		Statement stmt = null;
		List<Customer> customers = new Vector<>();
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver"); // Vendor-specific class name to be dynamically loaded
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/weasley;create=true");
			stmt = conn.createStatement();
			try {
				stmt.execute("CREATE TABLE customer ("
						+ "customerId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,"
						+ "firstName VARCHAR(24),"
						+ "lastName VARCHAR(24),"
						+ "phoneNumber VARCHAR(24),"
						+ "email VARCHAR(24)"
						+ ")");
			} catch (Exception e) {
				System.out.println("customer table already existed...");
			}
			for(Customer importedCust : imported) {
				stmt.execute("INSERT INTO customer (firstName, lastName, phoneNumber) VALUES ('"
							+ importedCust.getFirstName() + "', '" 
							+ importedCust.getLastName() + "', '"
							+ importedCust.getPhoneNumber() + "')");
			}
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
			while (rs.next()) {
				Long customerId = rs.getLong("customerId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				Customer c = new Customer(firstName, lastName);
				c.setCustomerId(customerId);
				c.setPhoneNumber(phoneNumber);
				c.setEmail(email);
				customers.add(c);
			}
			rs.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Found Customers: ");
		for(Customer c : customers) {
			System.out.println(c);
		}

	}

}
