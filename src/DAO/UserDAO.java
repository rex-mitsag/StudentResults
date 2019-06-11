package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import Model.Login;
import Model.User;

public class UserDAO {
	public static User validateUser(Login login) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT * FROM users WHERE ID='"+login.getId()+"' AND Password='"+login.getPassword()+"'";
		System.out.println(sql);
		ResultSet rs = QueryDAO.getOutput(sql);
		List<User> users = new ArrayList<User>();
		while(rs.next()) {
			User temp = new User();
			temp.setId(rs.getString("ID"));
			temp.setEmail(rs.getString("Email"));
			temp.setName(rs.getString("Name"));
			temp.setPassword(rs.getString("Password"));
			temp.setUtype(rs.getString("User_Type"));
			users.add(temp);
		}
		return users.size() > 0 ? users.get(0): null;
	}
}
