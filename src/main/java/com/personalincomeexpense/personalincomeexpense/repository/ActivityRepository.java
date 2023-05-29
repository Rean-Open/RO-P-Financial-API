/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personalincomeexpense.personalincomeexpense.model.Activity;

/**
 * @author Try
 *
 */
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>, JpaSpecificationExecutor<Activity> {
	@Query("SELECT a FROM Activity a WHERE a.user_id = :user_id AND a.activity_type_id = :activity_type_id")
	List<Activity> getActivityList(@Param("user_id") Long user_id, @Param("activity_type_id") Long activity_type_id);
	
	@Query("SELECT a FROM Activity a WHERE a.created_date BETWEEN :startDate AND :endDate AND a.user_id = :userId AND a.activity_type_id = :activityTypeId "
			+ "ORDER BY a.created_date ASC")
	List<Activity> getActivityReportByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("userId") Long userId, @Param("activityTypeId") Long activityTypeId);
	
	//List<Activity> findByCreatedDateBetween(Date startDate, Date endDate); //For create abstract method without Query
	
	@Query(value = "SELECT SUM(t.income) AS income, SUM(t.expense) AS expense, SUM(t.income) - SUM(t.expense) AS balance FROM "
			+ "(SELECT SUM(amount) AS income, 0 AS expense FROM activity WHERE activity_type_id = 1 AND user_id = ?1 "
			+ "UNION "
			+ "SELECT 0 AS income, SUM(amount) AS expense FROM activity WHERE activity_type_id = 2 AND user_id = ?1) t", nativeQuery = true)
    Map<String, BigDecimal> getTotalAmountByActivityType(Long userId);
    
	@Query(value = "SELECT SUM(t.income) AS income, SUM(t.expense) AS expense, SUM(t.income) - SUM(t.expense) AS balance FROM "
			+ "(SELECT SUM(amount) AS income, 0 AS expense FROM activity WHERE activity_type_id = 1 AND created_date BETWEEN ?1 AND ?2 AND user_id = ?3 "
			+ "UNION "
			+ "SELECT 0 AS income, SUM(amount) AS expense FROM activity WHERE activity_type_id = 2 AND created_date BETWEEN ?1 AND ?2 AND user_id = ?3) t", nativeQuery = true)
    List<Map<String, BigDecimal>> getTotalAmountBySummaryType(Date startDate, Date endDate, Long userId);
}
