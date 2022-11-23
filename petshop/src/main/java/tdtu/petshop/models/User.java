package tdtu.petshop.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String username;
	private String password;
<<<<<<< Updated upstream
	private int role;
=======
	@Type(type = "numeric_boolean")
	private boolean enable;
	private String role;
>>>>>>> Stashed changes
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
<<<<<<< Updated upstream
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
=======
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
>>>>>>> Stashed changes
		this.role = role;
	}
	
	@Override
	public String toString() {
<<<<<<< Updated upstream
		return "User [username=" + username + ", password=" + password + ", role=" + role + "]";
=======
		return "User [username=" + username + ", password=" + password + ", enable=" + enable + ", role=" + role + "]";
>>>>>>> Stashed changes
	}
}
