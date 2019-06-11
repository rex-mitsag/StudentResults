package Model;

public class Login {
	public Login(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	private String id;
	private String password;
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
	
}
