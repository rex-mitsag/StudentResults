package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import Model.Login;
import Model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("username");
		String password = request.getParameter("password");
		Login login = new Login(id, password);
		User user = null;
		try {
			user = UserDAO.validateUser(login);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*30);
		response.getWriter().println(user+"<br>");
		if(user!=null) {
			session.setAttribute("user", user);
			if(user.getUtype().equals("Student")) {
				view = request.getRequestDispatcher("StudentView.jsp");
			}
			else {
				view = request.getRequestDispatcher("FacultyView.jsp");
			}
		} else {
			request.setAttribute("error", "Incorrect username or password!");
			view = request.getRequestDispatcher("Login.jsp");
		}
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
