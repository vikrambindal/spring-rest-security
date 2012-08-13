package demo.vikram.springrest.service;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import demo.vikram.springrest.domain.RestUser;

@Service("fakeUserSecurityService")
public class FakeUserSecurityServiceImpl implements UserSecurityService {

	private RestUser simulateFetch(){
		return new RestUser("vikram", "spring", "123456789-987654321-01031982", new ArrayList<GrantedAuthority>());
	}
	@Override
	public UserDetails findUserDetailsByApiKey(String apiKey)throws UsernameNotFoundException {
		//Here we could actually be loading from DB, but just simulating the behaviour
		RestUser restUser = simulateFetch();
		if(restUser.getApiKey().equals(apiKey)){
			return restUser;
		}else{
			throw new UsernameNotFoundException("Illegal API Key");
		}
	}

}
