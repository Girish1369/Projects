package com.girish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.girish.entity.IPLPlayer;

@Repository
public interface IIPLPlayerRepository extends JpaRepository<IPLPlayer, Integer> {

}
