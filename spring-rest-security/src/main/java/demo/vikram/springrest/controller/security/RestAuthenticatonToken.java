package demo.vikram.springrest.controller.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class RestAuthenticatonToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -1460597118876406004L;

	public RestAuthenticatonToken(Object principal, Object credentials) {
		super(principal, credentials);
	}

	public RestAuthenticatonToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
	
}
