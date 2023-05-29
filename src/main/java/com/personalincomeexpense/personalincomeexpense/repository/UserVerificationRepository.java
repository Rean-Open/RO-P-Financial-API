/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personalincomeexpense.personalincomeexpense.model.UserVerification;

/**
 * @author Try
 *
 */
@Repository
public interface UserVerificationRepository extends CrudRepository<UserVerification, Long> {
	@Query("SELECT e FROM UserVerification e WHERE e.verify_status_id = 1 AND e.user_id = :user_id AND e.verify_code = :verify_code AND e.verify_type_id = :verify_type_id")
    UserVerification getVerification(@Param("user_id") Long user_id, @Param("verify_code") String verify_code, @Param("verify_type_id") Long verify_type_id);
}
