package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertMyRecord
 */
public class InsertMyRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMyRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid=request.getParameter("uid");
		String name= request.getParameter("uname");
		String age =request.getParameter("uage");
		String salary= request.getParameter("usalary");
		String desig= request.getParameter("udesig");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tcsbatch1", "root", "root");
	
	PreparedStatement stmt=con.prepareStatement("insert into employee value(?,?,?,?,?)");
	
	
	stmt.setString(1, uid);
	stmt.setString(2, name);
	stmt.setString(3, age);
	stmt.setString(4, salary);
	stmt.setString(5, desig);
	
	stmt.execute();
	System.out.println("Data Inserted Succesfully...!");
	
	} catch (Exception e) {
		System.out.println(e);
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
