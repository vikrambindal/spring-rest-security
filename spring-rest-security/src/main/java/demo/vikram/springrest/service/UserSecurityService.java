package demo.vikram.springrest.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserSecurityService {

	UserDetails findUserDetailsByApiKey(String apiKey)throws UsernameNotFoundException;

}
