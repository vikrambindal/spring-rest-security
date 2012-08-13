package demo.vikram.springrest.controller.security;

public class RestCredentials {

	private String userName;
	private String pwd;
	
	public RestCredentials(String userName, String pwd) {
		this.userName = userName;
		this.pwd = pwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
