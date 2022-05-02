package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

		private static Connection bConnection;

		private static String 
		connectionString = "jdbc:postgresql://salt.db.elephantsql.com:5432/xpigjzrq",
				username = "xpigjzrq",
				password = "uKNkrd-CoDlUkXyY_8tnsCjlQUlpVJ-5";

		public static Connection getConnection() {
			try {
				if (bConnection == null || bConnection.isClosed()) {

					Class.forName("org.postgresql.Driver");
					bConnection = DriverManager.getConnection(connectionString, username, password);
				}

				return bConnection;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}
}
