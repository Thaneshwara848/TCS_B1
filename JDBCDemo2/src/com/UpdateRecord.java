package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateRecord {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsbatch1", "root", "root");
	
	PreparedStatement stmt=con.prepareStatement("update employee set salary= ? where id= ?");
	Scanner sc= new Scanner(System.in);

	System.out.print("Enter ID :");int id=sc.nextInt();
	System.out.print("Enter SALARY :");int salary=sc.nextInt();
	
	stmt.setInt(1, salary);
	stmt.setInt(2, id);
	stmt.execute();
	
	System.out.println("Data Updated  Succesfully...!");
	
	} catch (Exception e) {
		System.out.println(e);
	}


	}
}
