package com.girish.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girish.entity.IPLPlayer;
import com.girish.repository.IIPLPlayerRepository;

@Service("IPlPlayerService")
public class IPLPlayerServiceImplementation implements IIPLPlayerService {
private static final Logger log=LoggerFactory.getLogger(IPLPlayerServiceImplementation.class);
	@Autowired
	private IIPLPlayerRepository repo;
	@Override
	public String registerIplPlayer(IPLPlayer player) {
		log.info("registerIplPlayer--method");
		IPLPlayer saved = repo.save(player);
		return "player saved by id::"+saved.getpId();
	}

	@Override
	public IPLPlayer getIplPlayerById(Integer Id) {
		log.info("getIplPlayerById--method");
		return repo.findById(Id).orElseThrow(()->new IllegalArgumentException("No player by id::"+Id));
	}

	@Override
	public List<IPLPlayer> allPlayer() {
		log.info("allPlayer--method");
		return repo.findAll();
	}

}
