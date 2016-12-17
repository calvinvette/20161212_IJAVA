package com.weasley.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class CustomerJDBCDAO implements CustomerDAO {
	private static Connection conn = null;
	private static PreparedStatement insertStatement;
	private static PreparedStatement updateStatement;
	private static PreparedStatement deleteStatement;
	private static PreparedStatement findByIdStatement;
	private static PreparedStatement findByLastNameStatement;
	private static PreparedStatement findByEmailStatement;
	private static PreparedStatement findAllStatement;

	static {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/weasley;create=true");
			insertStatement = conn.prepareStatement(
					"INSERT INTO customer (firstName, lastName, phoneNumber) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			updateStatement = conn.prepareStatement(
					"UPDATE CUSTOMER set firstName = ?, lastName = ?, phoneNumber = ?, email = ? WHERE customerId = ?");
			deleteStatement = conn.prepareStatement("DELETE FROM CUSTOMER WHERE customerId = ?");
			findByIdStatement = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE customerId = ?");
			findByLastNameStatement = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE lastName LIKE ?");
			findByEmailStatement = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE email = ?");
			findAllStatement = conn.prepareStatement("SELECT * FROM customer");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Customer findById(Long customerId) {
		try {
			findByIdStatement.setLong(1, customerId);
			ResultSet rs = findByIdStatement.executeQuery();
			if (rs.next()) {
				return rowToCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new Vector<>();
		try {
			ResultSet rs = findAllStatement.executeQuery();
			while (rs.next()) {
				Customer c = rowToCustomer(rs);
				customers.add(c);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public List<Customer> findByEmail(String email) {
		List<Customer> found = new Vector<>();
		try {
			findByEmailStatement.setString(1, email);
			ResultSet rs = findByEmailStatement.executeQuery();
			while (rs.next()) {
				Customer c = rowToCustomer(rs);
				found.add(c);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		List<Customer> found = new Vector<>();
		try {
			findByLastNameStatement.setString(1, "%" + lastName + "%");
			ResultSet rs = findByLastNameStatement.executeQuery();
			while (rs.next()) {
				Customer c = rowToCustomer(rs);
				found.add(c);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	private static Customer rowToCustomer(ResultSet rs) throws SQLException {
		Long customerId = rs.getLong("customerId");
		String firstName = rs.getString("firstName");
		String lastName = rs.getString("lastName");
		String phoneNumber = rs.getString("phoneNumber");
		String email = rs.getString("email");
		Customer c = new Customer(firstName, lastName);
		c.setCustomerId(customerId);
		c.setPhoneNumber(phoneNumber);
		c.setEmail(email);
		return c;
	}

	@Override
	public Customer update(Customer c) {
		try {
			conn.setAutoCommit(true);
			updateStatement.setString(1, c.getFirstName());
			updateStatement.setString(2, c.getLastName());
			updateStatement.setString(3, c.getPhoneNumber());
			updateStatement.setString(4, c.getEmail());
			updateStatement.setLong(5, c.getCustomerId());
			int rows = updateStatement.executeUpdate();
			System.out.println("Updated " + rows + " rows.");
			conn.commit();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Customer delete(Customer c) {
		try {
			deleteStatement.setLong(1, c.getCustomerId());
			deleteStatement.executeUpdate();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Customer insert(Customer c) {
		try {
			insertStatement.setString(1, c.getFirstName());
			insertStatement.setString(2, c.getLastName());
			insertStatement.setString(3, c.getPhoneNumber());
			insertStatement.executeUpdate();
			ResultSet rsGenKeys = insertStatement.getGeneratedKeys();
			if (rsGenKeys.next()) {
				c.setCustomerId(rsGenKeys.getLong(1));
			}
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void populateTable(List<Customer> imported) {
		for (Customer importedCust : imported) {
			insert(importedCust);
		}
		System.out.println("Populated customer table.");
	}

	public boolean dropTable(Statement stmt) {
		try {
			stmt.execute("DROP TABLE customer");
			System.out.println("Dropped customer table.");
			return true;
		} catch (Exception e) {
			System.out.println("Failed to delete customer table... " + e.getMessage());
			return false;
		}
	}

	public boolean createTable(Statement stmt) {
		try {
			stmt.execute("CREATE TABLE customer (" + "customerId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,"
					+ "firstName VARCHAR(24)," + "lastName VARCHAR(24)," + "phoneNumber VARCHAR(24),"
					+ "email VARCHAR(24)" + ")");
			System.out.println("Created customer table.");
			return true;
		} catch (Exception e) {
			System.out.println("Failed to create customer table... " + e.getMessage());
			return false;
		}
	}

}
