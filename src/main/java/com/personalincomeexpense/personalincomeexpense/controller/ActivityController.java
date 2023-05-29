/**
 * 
 */
package com.personalincomeexpense.personalincomeexpense.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Try
 *
 */

import com.personalincomeexpense.personalincomeexpense.model.Activity;
import com.personalincomeexpense.personalincomeexpense.service.ActivityService;
import com.personalincomeexpense.personalincomeexpense.service.ActivityService.SummaryType;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/activity/")
public class ActivityController {
	@Autowired
	ActivityService activityService;
	
	@RequestMapping(value = "createActivity", method = RequestMethod.POST)
	public String createActivity(@RequestBody Activity model) {
		return activityService.insertActivity(model);
	}
	
	@RequestMapping(value = "getActivityList", method = RequestMethod.GET)
	public List<Activity> getActivityList(Long userId, Long activityTypeId){
		return activityService.getActivityList(userId, activityTypeId);
	}
	
	@RequestMapping(value = "getActivity", method = RequestMethod.GET)
	public Activity getActivity(Long id){
		return activityService.getActivity(id);
	}
	
	@RequestMapping(value = "updateActivity", method = RequestMethod.PUT)
	public String updateActivity(@RequestBody Activity model) {
		return activityService.updateActivity(model);
	}
	
	@RequestMapping(value = "deleteActivity", method = RequestMethod.DELETE)
	public String deleteActivity(Long id) {
		return activityService.deleteActivity(id);
	}
	
	@RequestMapping(value = "getActivityReportByDate", method = RequestMethod.GET)
	public List<Activity> getActivityReportByDate(Date startDate, Date endDate, Long userId, Long activityTypeId){
		return activityService.getActivityReportByDate(startDate, endDate, userId, activityTypeId);
	}
	
	@RequestMapping(value = "getActivityReportSummary", method = RequestMethod.GET)
	public List<Activity> getActivityReportSummary(SummaryType summaryType, Long userId, Long activityTypeId){
		return activityService.getActivityReportSummary(summaryType, userId, activityTypeId);
	}
	
//	  @RequestMapping(value = "getActivityReportByDate", method =
//	  RequestMethod.GET) public List<Activity> getActivityReportByDate(Date
//	  startDate, Date endDate){ return
//	  activityService.getActivityReportByDate(startDate, endDate); } 
	
	@RequestMapping(value = "getTotalAmountByActivityType", method = RequestMethod.GET)
	public Map<String, BigDecimal> getTotalAmountByActivityType(Long userId){
		return activityService.getTotalAmountByActivityType(userId);
	}
	
	@RequestMapping(value = "getTotalAmountBySummaryType", method = RequestMethod.GET)
	public List<Map<String, BigDecimal>> getTotalAmountBySummaryType(SummaryType summaryType, Long userId){
		return activityService.getTotalAmountBySummaryType(summaryType, userId);
	}
}
