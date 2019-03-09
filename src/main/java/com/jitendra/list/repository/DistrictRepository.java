package com.jitendra.list.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jitendra.list.model.District;
@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
	
	@Query("SELECT D FROM District D WHERE D.stateCode = :stateCode")
	public List<District> getDistrictByState(@Param("stateCode") String stateCode);

}
