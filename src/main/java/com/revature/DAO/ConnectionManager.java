package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

		private static Connection bConnection;

		private static String 
		connectionString = "url",
				username = "username",
				password = "password";

		public static Connection getConnection() {
			try {
				if (bConnection == null || bConnection.isClosed()) {

					Class.forName("org.postgresql.Driver");
					bConnection = DriverManager.getConnection(connectionString, username, password);
				}

				return bConnection;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
		}
}
