package com.jitendra.list.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.jitendra.list.model.State;

@Service
public interface StateService<R> extends BaseSerivce<R> {	
	public Map<Integer, Integer> loadState(String jsonFilePath);
	
	public State getStateByName(String stateName);
}
