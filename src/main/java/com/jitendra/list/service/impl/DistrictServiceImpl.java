package com.jitendra.list.service.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.list.model.District;
import com.jitendra.list.repository.DistrictRepository;
import com.jitendra.list.service.DistrictService;
import com.opencsv.CSVReader;

@Service
public class DistrictServiceImpl implements DistrictService<DistrictRepository> {

	@Autowired
	private DistrictRepository repository;

	@Override
	public DistrictRepository repository() {
		return repository;
	}

	public Boolean loadDistrict(String filepath) {
		CSVReader csvReader = null;
		try {

			List<District> districts = new ArrayList<>();
			// Create an object of filereader
			// class with CSV file as a parameter.

			InputStream in = this.getClass().getResourceAsStream("/district.csv");

			FileReader filereader = new FileReader(filepath);

			// create csvReader object passing
			// file reader as a parameter
			csvReader = new CSVReader(new InputStreamReader(in));
			String[] nextRecord;
			Long id = 10001l;
			String code = "";
			// we are going to read data line by line
			while ((nextRecord = csvReader.readNext()) != null) {

				if (StringUtils.contains(nextRecord[1].toString(), "State")) {
					String name = nextRecord[0];

					if (StringUtils.contains(name.toString(), "(") && StringUtils.contains(name.toString(), ")")) {
						code = name.substring(name.indexOf("(") + 1, name.indexOf("(") + 3);

						System.out.print(code + "\t");
						System.out.println();
					}
				} else {
					// Long id, String code, String name, String headquarter, String popullation,
					// String area,
					// String density
					District district = new District(id++, nextRecord[0], nextRecord[1], nextRecord[2], nextRecord[3],
							nextRecord[4], nextRecord[5], code);
					districts.add(district);

				}
			}

			repository.saveAll(districts);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (csvReader != null)
					csvReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return Boolean.TRUE;
	}

}
