package aaa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LOGIN
 */
public class LOGIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LOGIN() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// it will pass the info through the URL 
		// ony lmimited data we can  pass 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("uname");
		String pass = request.getParameter("upass");
		PrintWriter out= response.getWriter();
		out.print("<body bgColor='cyan'>");
		out.print("Hi Mr !"+ name +" your Password is :"+ pass);
		out.print("</body>");
		// will not pas throug URL ? pass throgy BODY 
		// more data we can pass 	
	}
}
// diff b/w do GET  and do Post

