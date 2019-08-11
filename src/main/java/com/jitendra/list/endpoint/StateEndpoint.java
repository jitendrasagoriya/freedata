package com.jitendra.list.endpoint;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jitendra.list.model.District;
import com.jitendra.list.model.State;
import com.jitendra.list.service.impl.StateServiceImpl;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path="api/v1/state/")
public class StateEndpoint {
	
	@Autowired
	private StateServiceImpl service;
	
	@GetMapping("load")
	public ResponseEntity<?> load(@RequestParam("file") String jsonFilePath){
		try {
			return new ResponseEntity<Map<Integer,Integer>>(service.loadState(jsonFilePath), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("")
	public ResponseEntity<?> get(){
		try {
			List<State> states = service.repository().findAll();
			if(states!=null) {
				Collections.sort(states, new Comparator<State>() {
					@Override
					public int compare(State o1, State o2) {
						// TODO Auto-generated method stub
						return o1.getName().compareTo(o2.getName());
					}
				});
			}
			return new ResponseEntity<List<State>>(states, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	

}
