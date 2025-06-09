package com.girish.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.girish.entity.IPLTeam;


@FeignClient("IPLTeamService")
public interface IPLTeamServicedMSClient {
	
	@GetMapping("team-api/find/{id}")
	public IPLTeam findTeamById(@PathVariable Integer id);

}
