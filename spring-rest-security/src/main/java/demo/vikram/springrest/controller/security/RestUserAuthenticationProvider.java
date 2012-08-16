package demo.vikram.springrest.controller.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import demo.vikram.springrest.service.UserSecurityService;

public class RestUserAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	private UserSecurityService userSecurityService;
	
	private PasswordEncoder passwordEncoder;
	
	private static final Logger logger = LoggerFactory.getLogger(RestUserAuthenticationProvider.class);

	@Override
	protected UserDetails retrieveUser(String apiKey, UsernamePasswordAuthenticationToken token)throws AuthenticationException {
		
		logger.debug("retrieveUser, (apiKey={})", new Object[]{apiKey});
		
		UserDetails userDetails;
		try{
			userDetails = userSecurityService.findUserDetailsByApiKey(apiKey);
		}catch(UsernameNotFoundException usernameNotFoundException){
			throw usernameNotFoundException;
		}
		
		if(userDetails == null){
			throw new AuthenticationServiceException("Service return null authentication, breach of contract");
		}
		
		return userDetails;
	}
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken token)
			throws AuthenticationException {
		
		logger.debug("additionalAuthenticationCheck");
		if(token != null){
			
			RestCredentials restCredentials = (RestCredentials) token.getCredentials();
			if(restCredentials == null){
				throw new BadCredentialsException("Data missing for authentication");
			}
			
			if(!passwordEncoder.isPasswordValid(restCredentials.getPwd(), userDetails.getPassword(), restCredentials.getUserName())){
				throw new BadCredentialsException("Password does not match");
			}
			
		}else{
			throw new AuthenticationCredentialsNotFoundException("No Authentication Credentials could be found");
		}
	}
	
	public UserSecurityService getUserSecurityService() {
		return userSecurityService;
	}

	public void setUserSecurityService(UserSecurityService userSecurityService) {
		this.userSecurityService = userSecurityService;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
}
