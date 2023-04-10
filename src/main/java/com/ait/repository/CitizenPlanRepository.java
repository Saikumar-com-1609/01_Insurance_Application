package com.ait.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ait.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan,Integer> {

	@Query("select distinct(PLAN_NAME) from CitizenPlan")
	public List<String> getPlanNames();
	
	@Query("select distinct(PLAN_STATUS) from CitizenPlan")
	public List<String> getPlanStatuses();
}
