/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 * @author Try
 *
 */
import com.personalincomeexpense.personalincomeexpense.model.UserLogin;

@Repository
public interface UserLoginRepository extends CrudRepository<UserLogin, Long> {
	@Query("SELECT u FROM UserLogin u WHERE u.user_name = :username OR u.email = :email")
	UserLogin findByUserAndEmail(@Param("username") String username, @Param("email") String email);
	
	@Query("SELECT u FROM UserLogin u WHERE (u.email = :username OR u.user_name = :username) AND u.password = :password")
	UserLogin getUserLogin(@Param("username") String username, @Param("password") String password);
	
	@Query("SELECT u FROM UserLogin u WHERE u.user_name = :username OR u.email = :username")
	UserLogin findByUserOrEmail(@Param("username") String username);
}
