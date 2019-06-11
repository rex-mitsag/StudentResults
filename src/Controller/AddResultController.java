package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QueryDAO;
import Model.User;

/**
 * Servlet implementation class AddResultController
 */
@WebServlet("/AddResultController")
public class AddResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null && user.getUtype().equals("Faculty")) {
		String studentid = request.getParameter("studentid");
		String subjectid = request.getParameter("subjectid");
		String examtype = request.getParameter("examtype");
		float maxmarks = Float.parseFloat(request.getParameter("maxmarks"));
		float marks = Float.parseFloat(request.getParameter("marks"));
		
		String sql = "INSERT INTO results VALUES('"+studentid+"', '"+examtype+"', '"+subjectid+"', "+marks+");";
		String sql2 = "INSERT INTO maxmarks VALUES('"+subjectid+"', '"+examtype+"', '"+maxmarks+"');";
		System.out.println(sql);
		int status=100;
		try {
			status = QueryDAO.insertUpdate(sql);
			QueryDAO.insertUpdate(sql2);			
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(status);
		} else {
			response.sendRedirect("Login.jsp");
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
