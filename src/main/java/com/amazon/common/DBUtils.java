package com.amazon.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	static Connection mysqlConn;

	private static void createDBConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			mysqlConn = DriverManager.getConnection(Constants.dbHost, Constants.dbUserName, Constants.dbPassword);
			System.out.println("mysql connection was successfull.s");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void closeDBConnection() {

		try {
			mysqlConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static String readDataFromDB(String query) {

		String result = null;

		createDBConnection();

		try {
			Statement statement = mysqlConn.createStatement();

			ResultSet resultSet = statement.executeQuery(query);

			if (resultSet.next()) {
				result = resultSet.getString(1);
			}
			closeDBConnection();

		} catch (Exception e) {
			e.printStackTrace();
			closeDBConnection();
		}

		System.out.println("Result of Select Query:" + query + " is: " + result);
		return result;

	}

	public static void createDataInDB(String query) {

		createDBConnection();

		try {
			Statement statement = mysqlConn.createStatement();

			statement.executeUpdate(query);

			closeDBConnection();

		} catch (Exception e) {
			e.printStackTrace();
			closeDBConnection();
		}

		System.out.println("Result of insert Query:" + query + "is sucessful");

	}

	public static void updateDataInDB(String query) {

		createDBConnection();

		try {
			Statement statement = mysqlConn.createStatement();

			statement.executeUpdate(query);

			closeDBConnection();

		} catch (Exception e) {
			e.printStackTrace();
			closeDBConnection();
		}

		System.out.println("Result of update Query:" + query + "is sucessful");

	}

	public static void deleteDataInDB(String query) {

		createDBConnection();

		try {
			Statement statement = mysqlConn.createStatement();

			statement.executeUpdate(query);

			closeDBConnection();

		} catch (Exception e) {
			e.printStackTrace();
			closeDBConnection();
		}

		System.out.println("Result of delete Query:" + query + "is sucessful");

	}
}
