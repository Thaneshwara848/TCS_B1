package com;
import java.sql.*;
public class Demo2 {
	public static void main(String[] args) {	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsbatch1","root","root");
			Statement stmt=con.createStatement();
			stmt.execute("insert into employee values(777,'Shiva',55,90000,'Manager')");
			stmt.close();con.close();
			System.out.println("Data Inserted...");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}

