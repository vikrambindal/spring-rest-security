package demo.vikram.springrest.controller.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class RestAuthenticatonFilter extends AbstractAuthenticationProcessingFilter{

	private static final String REQ_API_KEY = "apiKey";
    private static final String REQ_ID = "id";
    private static final String REQ_HASH_PWD = "signature";
    
	protected RestAuthenticatonFilter(String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException,
			IOException, ServletException {
		
		String apiKey = obtainReqValue(REQ_API_KEY, request);
		String uName = obtainReqValue(REQ_ID, request);
		String encPwd = obtainReqValue(REQ_HASH_PWD, request);
		
		RestCredentials restCredentials = new RestCredentials(uName, encPwd);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(apiKey, restCredentials);
		return this.getAuthenticationManager().authenticate(token);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}
	
	public String obtainReqValue(String reqParam, HttpServletRequest request){
		return (request.getParameter(reqParam) == null ? null: request.getParameter(reqParam));
	}
	
	/**
     * Because we require the API client to send credentials with every request, we must authenticate on every request
     */
	@Override
	protected boolean requiresAuthentication(HttpServletRequest request,
			HttpServletResponse response) {
		return true;
	}
}
