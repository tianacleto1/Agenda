package org.com.tests;

import java.sql.Connection;
import java.sql.SQLException;
import org.com.utils.ConnectionFactory;

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();

		System.out.println("Connection open...");
		connection.close();
	}
}
