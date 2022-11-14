package com;

import java.sql.*;

public class ReadRecord {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsbatch1", "root", "root");
			Statement stmt=con.createStatement();
			ResultSet rs =stmt.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" : "+rs.getString("name")+": "+rs.getInt(3)+" :"+rs.getString("Desig"));
			}		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
