package com.girish.service;

import java.util.List;

import com.girish.entity.IPLPlayer;

public interface IIPLPlayerService {
	public String registerIplPlayer(IPLPlayer player);
	public IPLPlayer getIplPlayerById(Integer Id);
	public List<IPLPlayer> allPlayer();
}
