package com.wipro.web;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionFactory {
	private static Driver d;
	private static Properties p = new Properties();
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {

		}
	}

	public static Connection getConnection(String url,String user,String pass) {
		try {
			return DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in creating the Connection"
					+ e.getMessage());
			return null;
		}
	}

}
