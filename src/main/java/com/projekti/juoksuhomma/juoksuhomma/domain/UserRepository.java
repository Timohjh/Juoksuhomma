package com.projekti.juoksuhomma.juoksuhomma.domain;

//import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.projekti.juoksuhomma.juoksuhomma.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
