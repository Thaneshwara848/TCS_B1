package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BathcDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsbatch1", "root", "root");
			Statement stmt=con.createStatement();
			stmt.addBatch("insert into employee values(654,'ABCD',25,50000,'CLERK')");
			stmt.addBatch("insert into employee values(1343,'ABCD',25,50000,'CLERK')");
			stmt.addBatch("insert into employee values(1353,'ABCD',25,50000,'CLERK')");
			stmt.addBatch("insert into employee values(2213,'ABCD',25,50000,'CLERK')");
			stmt.addBatch("insert into employee values(642,'ABCD',25,50000,'CLERK')");
			
			stmt.executeBatch();
			con.setAutoCommit(true);
			
			System.out.println("DONE ");
					
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
