package com.gbk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbk.entity.TravelPlan;
import com.gbk.service.ITravelPlanMgmtService;

@RestController
@RequestMapping("/TravelPlan/api")//global path(optional)
public class TravelPlanOperationController {
	@Autowired
	private ITravelPlanMgmtService planService;
	
	@GetMapping("/categories")
	public ResponseEntity<?> showTravelPlanCategories(){
		try {
			Map<Integer, String> mapCategories=  planService.getTravelPlanCategories();
			return new ResponseEntity<Map<Integer,String>>(mapCategories, HttpStatus.OK);
			
		}catch(Exception e) {
			e.getStackTrace();
			return new ResponseEntity <String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/registor")
	public ResponseEntity<?> saveTourPlan(@RequestBody TravelPlan plan){
		try {
			String msg = planService.registorTravelPlan(plan);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
			
		}catch(Exception e) {
			e.getStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAllTravelPlans(){
		try {
			List<TravelPlan> showAllTravelPlanlist = planService.showAllTravelPlan();
			return new ResponseEntity<List<TravelPlan>>(showAllTravelPlanlist,HttpStatus.OK);
			
		}catch(Exception e) {
			e.getStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{planId}")
	public ResponseEntity<?> getTravelPlansbyId(@PathVariable Integer planId){
		try {
			TravelPlan planById = planService.showTravelPlanById(planId);
			return new ResponseEntity<TravelPlan>(planById,HttpStatus.OK);
			
		}catch(Exception e) {
			e.getStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateTravelPlan(@RequestBody TravelPlan plan){
			try {
				String updateTravelPlan = planService.updateTravelPlan(plan);
				
				return new ResponseEntity<String>(updateTravelPlan,HttpStatus.OK);
			}catch(Exception e) {
				e.getStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	@DeleteMapping("/delete/{planId}")
	public ResponseEntity<String> deleteTravelPlan(@RequestBody Integer planId){
		try {
			String deleteTravelPlan = planService.deleteTravelPlan(planId);
			return new ResponseEntity<String>(deleteTravelPlan,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<?> changeStatus(@PathVariable Integer planId,@PathVariable String status){
		try {
			String changeTravelPlanStatus = planService.changeTravelPlanStatus(planId, status);
			return new ResponseEntity<String>(changeTravelPlanStatus,HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		}
	}
	
}
