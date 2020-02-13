package com.accenture.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.accenture.entity.EmployeeEntity;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String>{
	//@Query(value = "SELECT k.period FROM EmployeeEntity k")
	/*
	 * public List<Date> findDistinctPeriod();
	 */

	@Query("{'period' : { $gte: ?0, $lte: ?1 } }")
	public List<EmployeeEntity> getBasedOnYear(Date from, Date to); 
	
	@Query("{'DU' : ?0 }")
	public List<EmployeeEntity> getBasedOnDu(String DU);

	@Query("{'period' : { $gte: ?0, $lte: ?1 } , 'DU' : ?2 }")
	public List<EmployeeEntity> getBasedOnYearAndDU(Date from, Date to, String DU);

	@Query("{'period' : { $gte: ?0, $lte: ?1 } , 'employeeId' : ?2 }")
	public List<EmployeeEntity> getBasedOnYearAndId(Date from, Date to, Integer employeeId);

	@Query("{'employeeId' : ?0  }")
	public List<EmployeeEntity> getBasedOnEmployeeId(Integer employeeId);

}