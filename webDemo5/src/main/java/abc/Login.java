package abc;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("username");
		String desig= request.getParameter("desig");
		PrintWriter out=response.getWriter();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javabackend", "root","root");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from employee");
		while(rs.next())
		{
			if(name.equalsIgnoreCase(rs.getString(2)) && desig.equalsIgnoreCase(rs.getString(5)))
			{
				RequestDispatcher rd = request.getRequestDispatcher("Homepage.html");
				rd.forward(request, response);
				
			}
			else
			{
				out.print("<h3 style='color:red'>Invalid Credentials ....! Please try Once again  ...!</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
			
		}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
