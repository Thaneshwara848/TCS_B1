package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class Emp
{
	static void insert()
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsbatch1", "root", "root");
	
	PreparedStatement stmt=con.prepareStatement("insert into employee value(?,?,?,?,?)");
	Scanner sc= new Scanner(System.in);
	
		
	System.out.print("Enter ID :");int id=sc.nextInt();
	System.out.print("Enter NAME  :");String name= sc.next();
	System.out.print("Enter AGE  :");int age=sc.nextInt();
	System.out.print("Enter SALARY :");int salary=sc.nextInt();
	System.out.print("Enter DESIG :");String desig=sc.next();
	
	stmt.setInt(1, id);
	stmt.setString(2, name);
	stmt.setInt(3, age);
	stmt.setInt(4, salary);
	stmt.setString(5, desig);
	
	stmt.execute();
	System.out.println("Data Inserted Succesfully...!");
	
	} catch (Exception e) {
		System.out.println(e);
	}
	}
	static void display()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsbatch1", "root", "root");
			Statement stmt=con.createStatement();
			ResultSet rs =stmt.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" : "+rs.getString("name")+": "+rs.getInt(3)+" :"+
			rs.getString("Desig")+" : "+rs.getInt(4));
			}		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	static void update()
	{
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
	static void delete()
	{	
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
	}	}
}
public class JDBCProject {

	public static void main(String[] args) {
		int ch;
		do {
			Scanner sc= new Scanner(System.in);
			System.out.println("1 ) Insert ");
			System.out.println("2 ) DISPLAY ");
			System.out.println("3 ) Update  ");
			System.out.println("4 ) Delete ");
			System.out.println("5 ) EXIT   ");
			System.out.println("Enter the choice :");
			ch=sc.nextInt();
			if(ch==1)
			{
				Emp.insert();
			}
			if(ch==2)
			{
				Emp.display();
			}
			if(ch==3)
			{
				Emp.update();
			}
			if(ch==4)
			{
				Emp.delete();
			}
			if(ch>=5)
			{
				System.exit(0);
				System.out.println("Thank you ");
			}
		
	}while(ch<=5);
		
	}
}
