package com.gbk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbk.config.AppConfigProperties;
import com.gbk.constant.TravelPlanConstatns;
import com.gbk.entity.PlanCategory;
import com.gbk.entity.TravelPlan;
import com.gbk.repository.IPlanCategoryRepo;
import com.gbk.repository.ITravlePlanRepo;

@Service
public class TravelPlanMgmtServiceImpl implements ITravelPlanMgmtService {

	@Autowired
	private IPlanCategoryRepo plancategoryrepo;
	
	@Autowired
	private ITravlePlanRepo travelplanrepo;
	
	private Map<String,String> message;
	
	@Autowired
	public TravelPlanMgmtServiceImpl(AppConfigProperties properties) {
		message=properties.getMessage();
	}
	
	@Override
	public String registorTravelPlan(TravelPlan plan) {
		//save object
		TravelPlan saved=travelplanrepo.save(plan);
		
		return saved.getPlan_id()!=null?TravelPlanConstatns.SAVE_SUCCESS+saved.getPlan_id(): TravelPlanConstatns.SAVE_FAILURE;
	}

	@Override
	public Map<Integer, String> getTravelPlanCategories() {
		List<PlanCategory> list=plancategoryrepo.findAll();
		Map<Integer, String> categoriesMap=new HashMap<Integer,String>();
		list.forEach(categories->categoriesMap.put(categories.getCategory_id(), categories.getCategory_name()));
		return categoriesMap;
	}

	@Override
	public List<TravelPlan> showAllTravelPlan() {
		// TODO Auto-generated method stub
		return travelplanrepo.findAll();
	}

	@Override
	public TravelPlan showTravelPlanById(Integer planId) {
		return travelplanrepo.findById(planId).orElseThrow();
//		Optional<TravelPlan> opt=travelplanrepo.findById(planId);
//		if(opt.isPresent())
//			return opt.get();
//		else
//			throw new IllegalArgumentException("plan id not found");
//		
		
		
	}

	@Override
	public String updateTravelPlan(TravelPlan plan) {
//		TravelPlan updated=travelplanrepo.save(plan);
//		return updated.getPlan_id() +"plan updated";
		Optional<TravelPlan> opt=travelplanrepo.findById(plan.getPlan_id());
		if(opt.isPresent()) {
			travelplanrepo.save(plan);
			return plan.getPlan_id()+TravelPlanConstatns.UPDATE_SUCCESS;
		}else {
			return plan.getPlan_id()+TravelPlanConstatns.UPDATE_FAILURE;
					
		}
	}

	@Override
	public String deleteTravelPlan(Integer planId) {
		Optional<TravelPlan> opt=travelplanrepo.findById(planId);
		if(opt.isPresent()) {
			travelplanrepo.deleteById(planId);
			return TravelPlanConstatns.DELETE_SUCCESS;
		}else {
			return planId+TravelPlanConstatns.DELETE_FAILURE;
					
		}
	}

	@Override
	public String changeTravelPlanStatus(Integer planId, String status) {
		Optional<TravelPlan> opt=travelplanrepo.findById(planId);
		if(opt.isPresent()) {
			TravelPlan plan=opt.get();
			plan.setActive_sw(status);
			return planId+TravelPlanConstatns.STATUS_CHANGE_SUCCESS;
			
		}else {
			return planId+TravelPlanConstatns.STATUS_CHANGE_FAILURE;
		}
		
	}

	

}
