package com.gbk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gbk.entity.PlanCategory;

public interface IPlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
