package ihs.com.trade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ihs.com.trade.model.User;
import ihs.com.trade.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	 public User validateUser(User user) {
	       if(user != null) { 
		       User repoUser = loginRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		       if(repoUser != null) {
		    	   return repoUser;
		       }
	       }
	       return null;
	    }
}
