package com.jitendra.list.endpoint;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jitendra.list.model.District;
import com.jitendra.list.model.State;
import com.jitendra.list.service.impl.DistrictServiceImpl;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/district/")
public class DistrictEndpoint {

	@Autowired
	private DistrictServiceImpl service;

	@GetMapping("load")
	public ResponseEntity<?> load(@RequestParam("file") String jsonFilePath) {
		try {
			return new ResponseEntity<Boolean>(service.loadDistrict(jsonFilePath), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("")
	public ResponseEntity<?> get() {
		try {
			return new ResponseEntity<List<District>>(service.repository().findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("state/{code}")
	public ResponseEntity<?> getByState(@PathVariable String code) {
		try {
			return new ResponseEntity<List<District>>(service.repository().getDistrictByState(code), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
