package com.weasley.store;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface MyDatabaseInterface {

	void createTable(Statement stmt);

	void populateTable(List<Customer> imported, Statement stmt) throws SQLException;

	void findAll(Statement stmt, List<Customer> customers) throws SQLException;

}