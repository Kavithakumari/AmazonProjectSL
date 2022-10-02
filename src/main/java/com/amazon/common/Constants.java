package com.amazon.common;

public class Constants {

	// test data variables

	public static final String baseUrl = "https://amazon.com/";
	public static final String searchUrl = baseUrl + "s";

	// DB Constants

	public static final String dbHost = "jdbc:mysql://testautomasi.cpxinzephrda.ap-southeast-1.rds.amazonaws.com:3306";
	public static final String dbUserName = "testautomasi";
	public static final String dbPassword = "testautomasi";

	// Starting Index of Names and Prices based on the Class in Amazon Web site
	public static final int nameStartIndex = 1;
	public static final int priceStartIndex = 7;
}
