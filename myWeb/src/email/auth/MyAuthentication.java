package email.auth;

import javax.mail.PasswordAuthentication;

import javax.mail.Authenticator;
//[인증 부분]
public class MyAuthentication extends Authenticator {
	PasswordAuthentication pa; 
	
	public MyAuthentication() { 
		String userName = "hhhongso@gmail.com";
		String password = "plajus101!";
		
		pa = new PasswordAuthentication(userName, password);
				
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
	
	
}
