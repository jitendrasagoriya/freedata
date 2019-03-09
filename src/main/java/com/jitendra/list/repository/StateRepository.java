package com.jitendra.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jitendra.list.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
	
	@Query("SELECT S FROM State S WHERE S.name = :name")
	public State getStateByName(@Param("name") String stateName);
	
	@Query("SELECT S FROM State S WHERE S.abbr = :abbr")
	public State getStateByAbbr(@Param("abbr") String abbr);

}
