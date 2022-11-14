package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteRecord {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsbatch1", "root", "root");
	PreparedStatement stmt=con.prepareStatement("delete from employee where id = ? ");
	Scanner sc= new Scanner(System.in);
	System.out.print("Enter ID :");int id=sc.nextInt();
	stmt.setInt(1, id);
	System.out.println("Hy Do you really wanmt to delete record ? y / n ");
	String op= sc.next();
	if(op.equalsIgnoreCase("yes") || op.equalsIgnoreCase("y"))
	{
		stmt.execute();	
		System.out.println("Data Deleted   Succesfully...!");
	}
	else
	{
		System.out.println("let him enjoy one more year ");
	}
	} catch (Exception e) {
		System.out.println(e);
	}
	}
}
