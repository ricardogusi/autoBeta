package gusi.springframework.springdata.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


public class LoginForm {

	private String user;
	private String password;
	
	
	public void setUser(String user) {
		this.user = user;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	
	
	public UsernamePasswordAuthenticationToken convert() {
		
		return new UsernamePasswordAuthenticationToken(user, password);
	}
	
	
}
	
	

