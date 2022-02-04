package ihs.com.trade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ihs.com.trade.model.User;

@Repository
public interface LoginRepository extends CrudRepository<User, Long>{
	
	User findUserByUsernameAndPassword(String username, String password);
}
