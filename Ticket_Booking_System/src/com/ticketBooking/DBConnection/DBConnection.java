package com.ticketBooking.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection() {
		try {
			String username = "root";
			String password = "rcpit";
			String url = "jdbc:mysql://localhost:3306/ticket_system";
			
			return DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
