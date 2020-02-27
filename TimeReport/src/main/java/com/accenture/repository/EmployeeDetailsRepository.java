package com.accenture.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.accenture.entity.EmployeeDetails;


public interface EmployeeDetailsRepository extends MongoRepository<EmployeeDetails, String>{
	@Query("{'BRID' : ?0  }")
	public EmployeeDetails getBasedOnBRID(String bridId);
}
