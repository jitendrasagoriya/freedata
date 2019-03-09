package com.jitendra.list.service;

import org.springframework.stereotype.Service;

@Service
public interface CityService<R> extends BaseSerivce<R> {
	public Boolean loadCity();
	
}
