package com.gbk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gbk.entity.TravelPlan;

public interface ITravlePlanRepo extends JpaRepository<TravelPlan, Integer> {

}
