package com.gbk.service;



import java.util.List;
import java.util.Map;

import com.gbk.entity.TravelPlan;

public interface ITravelPlanMgmtService {

	public String registorTravelPlan(TravelPlan plan);// save operation
	public Map<Integer, String> getTravelPlanCategories();//for selection(view of category) operation
	public List<TravelPlan> showAllTravelPlan();//for selection (viewing all plan details)
	public TravelPlan showTravelPlanById(Integer planId);//for showing the existing record for edit operation
	public String updateTravelPlan(TravelPlan plan);//for final edit submission
	public String deleteTravelPlan(Integer planId);//for hard delete (permanent deletion)
	public String changeTravelPlanStatus(Integer planId,String status);//for soft delete

	

}
