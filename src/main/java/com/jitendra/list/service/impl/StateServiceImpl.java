package com.jitendra.list.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.list.json.state.Result;
import com.jitendra.list.model.State;
import com.jitendra.list.repository.StateRepository;
import com.jitendra.list.service.StateService;
import com.jitendra.list.utils.JSONUtility;

@Service
public class StateServiceImpl implements StateService<StateRepository> {
	
	@Autowired
	private StateRepository stateRepository;

	@Override
	public StateRepository repository() {
		return stateRepository;
	}

	@Override
	public Map<Integer, Integer> loadState(String jsonFilePath) {
		com.jitendra.list.json.state.State response;
		List<Result> results;
		List<State> states = new ArrayList<>();
		State state = null;
		response = JSONUtility.getState();
		results = response.getRestResponse().getResult();
		 for (Result result : results) {
			 state = new State();
			 state.setAbbr(result.getAbbr());
			 state.setArea(result.getAbbr());
			 state.setCapital(result.getCapital());
			 state.setCountry(result.getCountry());
			 state.setId(Long.parseLong( ""+result.getId()));
			 state.setLargest_city(result.getLargestCity());
			 state.setName(result.getName());
			 System.out.println(state);
			 states.add(state);
		 }		
		
		try {
			stateRepository.saveAll(states);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public State getStateByName(String stateName) {
		 return stateRepository.getStateByName(stateName);
	}
	

}
