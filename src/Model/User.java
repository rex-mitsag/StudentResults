package Model;

public class User {
	private String id;
	private String password;
	private String email;
	private String name;
	private String utype;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	@Override
	public String toString() {
		String retur = id+";"+password+";"+email+";"+name+";"+utype;
		return retur;
	}
	public User(String argss) {
		super();
		String[] args = argss.split(";");
		id = args[0];
		password = args[1];
		email = args[2];
		name = args[3];
		utype = args[4];
	}
	public User() {
		super();
	}
}
