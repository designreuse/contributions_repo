package org.tracsystems.apps.brokerage.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tracsystems.apps.brokerage.auth.model.User;
import java.lang.String;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

	public User findByUsername(String username);
	
}
