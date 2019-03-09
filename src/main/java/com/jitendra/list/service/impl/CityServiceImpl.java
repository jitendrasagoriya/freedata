package com.jitendra.list.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.list.json.city.Cities;
import com.jitendra.list.json.city.City;
import com.jitendra.list.model.State;
import com.jitendra.list.repository.CityRepository;
import com.jitendra.list.repository.StateRepository;
import com.jitendra.list.service.CityService;
import com.jitendra.list.utils.JSONUtility;

@Service
public class CityServiceImpl implements CityService<CityRepository> {

	@Autowired
	private CityRepository repository;

	@Autowired
	private StateRepository stateRepository;

	@Override
	public CityRepository repository() {
		return repository;
	}

	@Override
	public Boolean loadCity() {
		Cities cities = null;
		List<City> list = new ArrayList<>();
		List<com.jitendra.list.model.City> result = new ArrayList<>();
		cities = JSONUtility.getCity();
		if (cities != null && cities.getCities() != null && !cities.getCities().isEmpty()) {
			for (City city : cities.getCities()) {
				try {
				State state = stateRepository.getStateByName(city.getState());
				result.add(new com.jitendra.list.model.City(Long.parseLong(city.getId()), city.getName(),
						city.getName(), state.getAbbr()));
				}catch (Exception e) {
					System.out.println( "city :"+city);
				}
			}
		}
		
		try {
			repository.saveAll(result);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}  
	}

}
