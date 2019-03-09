package com.jitendra.list.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jitendra.list.model.City;
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
	@Query("SELECT C FROM City C WHERE C.stateCode = :stateCode")
	public List<City> getCityByState(@Param("stateCode") String stateCode);

}
