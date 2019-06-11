package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QueryDAO;
import Model.User;

/**
 * Servlet implementation class ResultsController
 */
@WebServlet("/ResultsController")
public class ShowResultsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowResultsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
		rd.include(request, response);
		PrintWriter writer = response.getWriter();
		if(user!=null) {
			int getSem = Integer.parseInt(request.getParameter("sem"));
			ResultSet rs = null;
			String sql = "SELECT results.Subject_ID, Subject_Name, results.Exam_Type, Marks_Obtained, Max_Marks FROM results JOIN subjects JOIN maxmarks WHERE S_ID='"+user.getId()+"' AND Semester_Available="+getSem+" AND maxmarks.Subject_ID=subjects.Subject_ID AND maxmarks.Exam_Type=results.Exam_Type ORDER BY Subject_ID;";
			try {
				System.out.println(sql);
				rs = QueryDAO.getOutput(sql);
				writer.println("<table><tr><th>Subject ID</th><th>Subject Name</th><th>Exam Type</th><th>Marks Obtained</th><th>Max Marks</th>");
				while(rs.next()) {
					writer.println("<tr><td>"+rs.getString("Subject_ID")+"<td>"+rs.getString("Subject_Name")+"</td><td>"+rs.getString("Exam_Type")+"</td><td>"+rs.getFloat("Marks_Obtained")+"</td><td>"+rs.getFloat("Max_marks")+"</td>");
				}
				writer.println("</table>");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
