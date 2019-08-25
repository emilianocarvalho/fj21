package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21?useSSL=false","root","D3vpr0c0n@");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
