package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo1 {
	public static void main(String[] args) {
		// 5 steps 
		// Load the driver 
		// Create the connection 
		// Create the statement 
		// execute the query
		// close 
		try {
			Class.forName("com.mysql.jdbc.Driver");
Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsbatch1","root","root");
			Statement stmt=con.createStatement();
			stmt.execute("insert into employee values(888,'Punith',35,70000,'Manager')");
			stmt.close();con.close();
			System.out.println("Data Inserted Successfully....!");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}









