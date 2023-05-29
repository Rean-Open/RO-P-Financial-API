/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.personalincomeexpense.personalincomeexpense.model.Activity;
import com.personalincomeexpense.personalincomeexpense.repository.ActivityRepository;

@Service
public class ActivityService {
	@Autowired
	ActivityRepository activityRepository;

	public enum SummaryType {
		Daily, Weekly, Monthly, Yearly
	}

	private Date startDate;
	private Date endDate;
	private Calendar calendar;

	public String insertActivity(Activity model) {
		if (model != null) {
			activityRepository.save(model);
			return "success";
		}
		return "fail";
	}

	public List<Activity> getActivityList(Long userId, Long activityTypeId) {
		return activityRepository.getActivityList(userId, activityTypeId);
	}

	public Activity getActivity(Long id) {
		return activityRepository.findById(id).get();
	}
	
	/*
	 * public List<Activity> getActivity(Date startDate, Date endDate) {
	 * List<Activity> activities = activityRepository.findAll(new
	 * Specification<Activity>() {
	 * 
	 * @Override public Predicate toPredicate(Root<Activity> root, CriteriaQuery<?>
	 * query, CriteriaBuilder criteriaBuilder) { List<Predicate> predicates = new
	 * ArrayList<>(); if (startDate != null) {
	 * predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.
	 * get("created_date"), startDate))); } if (endDate != null) {
	 * predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get
	 * ("created_date"), endDate))); }
	 * 
	 * return criteriaBuilder.and(predicates.toArray(new
	 * Predicate[predicates.size()])); } }); return activities; }
	 */

	public String updateActivity(Activity model) {
		if (model != null) {
			Activity activity = activityRepository.findById(model.getId()).get();
			if (activity != null) {
				activity.setAmount(model.getAmount());
				activity.setDescription(model.getDescription());
				activity.setCategory_id(model.getCategory_id());
				activity.setPayment_method_id(model.getPayment_method_id());
				activity.setCreated_date(model.getCreated_date());
				activity.setRemark(model.getRemark());
				activity.setReference(model.getReference());
				activity.setTag(model.getTag());
				activityRepository.save(activity);
				return "success";
			}
		}
		return "fail";
	}

	public String deleteActivity(Long id) {
		if (id != null) {
			activityRepository.deleteById(id);
			return "success";
		}
		return "false";
	}

	public List<Activity> getActivityReportByDate(Date startDate, Date endDate, Long userId, Long activityTypeId) {
		return activityRepository.getActivityReportByDate(startDate, endDate, userId, activityTypeId);
	}

	public List<Activity> getActivityReportSummary(SummaryType summaryType, Long userId, Long activityTypeId) {
		GetSummaryDate(summaryType);
		return activityRepository.getActivityReportByDate(startDate, endDate, userId, activityTypeId);
	}

	/*
	 * public List<Activity> getActivityReportByDate(Date startDate, Date endDate){
	 * return activityRepository.findByCreatedDateBetween(startDate, endDate); }
	 */

	public Map<String, BigDecimal> getTotalAmountByActivityType(Long userId) {
		return activityRepository.getTotalAmountByActivityType(userId);
	}

	public List<Map<String, BigDecimal>> getTotalAmountBySummaryType(SummaryType summaryType, Long userId) {
		GetSummaryDate(summaryType);
		return activityRepository.getTotalAmountBySummaryType(startDate, endDate, userId);
	}

	private void GetSummaryDate(SummaryType summaryType) {
		calendar = Calendar.getInstance();
		switch (summaryType) {
		case Weekly:
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			startDate = calendar.getTime();
			calendar.add(Calendar.DATE, 6);
			endDate = calendar.getTime();
			break;
		case Monthly:
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			startDate = calendar.getTime();
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DATE, -1);
			endDate = calendar.getTime();
			break;
		case Yearly:
			calendar.set(Calendar.DAY_OF_YEAR, 1);
			startDate = calendar.getTime();
			calendar.add(Calendar.YEAR, 1);
			calendar.add(Calendar.DATE, -1);
			endDate = calendar.getTime();
			break;
		default:
			LocalDate date = LocalDate.now();
			LocalDateTime startOfDay = date.atStartOfDay();
			LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
			Timestamp startOfTimestamp = Timestamp.valueOf(startOfDay);
			Timestamp endOfTimestamp = Timestamp.valueOf(endOfDay);
			startDate = new Date(startOfTimestamp.getTime());
			endDate = new Date(endOfTimestamp.getTime());
			break;
		}
	}
}
