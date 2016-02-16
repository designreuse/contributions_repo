package org.tracsystems.apps.brokerage.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.tracsystems.apps.brokerage.auth.model.UserRole;

public interface UserRolesRepository extends JpaRepository<UserRole, Long> {

	@Query("select a.role from UserRole a where a.user.username = ?1")
	public List<String> findRoleByUserName(String username);
	
}
