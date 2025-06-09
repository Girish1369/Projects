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

import com.girish.client.IPLTeamServicedMSClient;
import com.girish.entity.IPLPlayer;
import com.girish.entity.IPLTeam;
import com.girish.service.IIPLPlayerService;

@RestController
@RequestMapping("/player-api")
public class IPLPlayerController {
	private static final Logger log=LoggerFactory.getLogger(IPLPlayerController.class);
	
	@Autowired
	private IIPLPlayerService service;
	
	@Autowired
	private IPLTeamServicedMSClient client;
	
	@PostMapping("/save")
	public ResponseEntity<?> registerPlayer(@RequestBody IPLPlayer player){
		
		Integer teamId = player.getteam().getTeamId();
		IPLTeam teamById = client.findTeamById(teamId);
		player.setteam(teamById);
		try {
			String string = service.registerIplPlayer(player);
			log.info("registerPlayer()...controller");
			return new ResponseEntity<String>(string,HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("error in registerPlayer()...controller");
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/player/{id}")
	public ResponseEntity<?> getPlayerByid(@PathVariable Integer id){
		try {
			IPLPlayer iplPlayer = service.getIplPlayerById(id);
			log.info("getPlayerById()...controller");
			return new ResponseEntity<IPLPlayer>(iplPlayer,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("error in the getPlayerById()...controller");
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllPlayer(){
		try {
			List<IPLPlayer> allPlayer = service.allPlayer();
			log.info("getAllPlayer()...controller");
			return new ResponseEntity<List<IPLPlayer>>(allPlayer,HttpStatus.OK);
		} catch (Exception e) {  
			log.error("error in the getAllPlayer()..controller");
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
