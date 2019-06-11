package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

public class QueryDAO extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static ResultSet getOutput(String sql) throws ClassNotFoundException, SQLException, NamingException {
		Context ctx = new InitialContext();
	    DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/srs");
		Connection con = ds.getConnection();
		Statement stmt = con.createStatement();
		return stmt.executeQuery(sql);
	}
	
	public static int insertUpdate(String sql) throws ClassNotFoundException, SQLException, NamingException {
		Context ctx = new InitialContext();
	    DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/srs");
		Connection con = ds.getConnection();
		Statement stmt = con.createStatement();
		return stmt.executeUpdate(sql);		
	}
}
