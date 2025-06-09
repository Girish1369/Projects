package com.girish.service;

import java.util.List;

import com.girish.entity.IPLTeam;

public interface IIPLTeamService {

	public String registerIPLTeam(IPLTeam team);
	public List<IPLTeam> getAllTeam();
	public IPLTeam getTeamById(Integer id);
}
