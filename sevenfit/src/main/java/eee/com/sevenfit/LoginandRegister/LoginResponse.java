package eee.com.sevenfit.LoginandRegister;

import lombok.Data;

@Data
public class LoginResponse {
	
	private String token;
	
	public LoginResponse(String token2) {
		
		this.token=token;
		
	}
	
	

}
