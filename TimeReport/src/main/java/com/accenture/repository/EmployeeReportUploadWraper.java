package com.accenture.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.accenture.entity.EmployeeDetails;
@Repository
public class EmployeeReportUploadWraper {
	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public EmployeeDetails getBasedOnBRID(String bridId) {
		return employeeDetailsRepository.getBasedOnBRID(bridId);
	}

}
