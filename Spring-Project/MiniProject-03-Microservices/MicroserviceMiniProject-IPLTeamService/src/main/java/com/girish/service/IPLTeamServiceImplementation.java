package com.girish.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girish.entity.IPLTeam;
import com.girish.repository.IPLTeamRepository;

@Service("IPLTeamService")
public class IPLTeamServiceImplementation implements IIPLTeamService {
private static final Logger log=LoggerFactory.getLogger(IPLTeamServiceImplementation.class);
	@Autowired 
	IPLTeamRepository repo;
	
	@Override
	public String registerIPLTeam(IPLTeam team) {
		log.info("registerIPLTeam() in IPLTeamServiceImplementation class");
		IPLTeam iplTeam = repo.save(team);
		Integer teamId = iplTeam.getTeamId();
		return "IPL team successfully by team id:: "+teamId;
	}

	@Override
	public List<IPLTeam> getAllTeam() {
		log.info("getAllTeam(service)");
		List<IPLTeam> list = repo.findAll();
		return list;
	}

	@Override
	public IPLTeam getTeamById(Integer id) {
		log.info("findById(service)");
		
		return repo.findById(id).orElseThrow(()->new IllegalArgumentException("no id found"));
	}

}
