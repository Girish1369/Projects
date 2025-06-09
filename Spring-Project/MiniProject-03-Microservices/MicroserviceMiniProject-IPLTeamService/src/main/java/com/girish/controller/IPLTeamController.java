package com.girish.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.girish.entity.IPLTeam;
import com.girish.service.IIPLTeamService;

@RestController
@RequestMapping("/team-api")
public class IPLTeamController {
	private static final Logger log=LoggerFactory.getLogger(IPLTeamController.class);
	
	@Autowired
	private IIPLTeamService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTeam(@RequestBody IPLTeam team){
		try {
			String registerIPLTeamMsg = service.registerIPLTeam(team);
			log.info("registerTeam()...controller");
			return new ResponseEntity<>(registerIPLTeamMsg,HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("problem in registerTeam method()..."+e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> findTeams(){
		try {
			List<IPLTeam> allTeam = service.getAllTeam();
			log.info("findTeams...controller");
			return new ResponseEntity<List<IPLTeam>>(allTeam,HttpStatus.OK);
		} catch (Exception e) {
			log.error("error in finding teams "+e.getMessage());
			return new ResponseEntity<String>("Error in finding teams",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findTeamById(@PathVariable Integer id){
		try {
			IPLTeam iplTeam = service.getTeamById(id);
			log.info("findTeamById()...controller");
			return new ResponseEntity<IPLTeam>(iplTeam,HttpStatus.OK);
		} catch (Exception e) {
			log.error("error in finding team by id"+e.getMessage());
			return new ResponseEntity<String>("error in finding team"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
