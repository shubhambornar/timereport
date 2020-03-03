package com.accenture.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;


import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.accenture.business.bean.EmployeeBean;
import com.accenture.business.bean.EmployeeReport;
import com.accenture.entity.EmployeeEntity;
import com.mongodb.client.DistinctIterable;

@Repository
public class EmployeeWrapper {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<EmployeeEntity> getAll() {
		return employeeRepository.findAll();
	}

	/**
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public List<EmployeeEntity> getBasedOnYear(Integer date) throws ParseException {

		/*
		 * Query query = new Query();
		 */		Integer st = date-1;
		 Integer en = date+1;
		 /*
		  * Date from = new Date("2020-01-01"); Date to = new Date("2020-12-12");
		  * query.addCriteria(Criteria.where("period").lt(from).gt(to));
		  * List<EmployeeEntity> ls = mongoTemplate.find(query, EmployeeEntity.class);
		  */
		 System.out.println("Calleing @query in repository");
		 List<EmployeeEntity> list =employeeRepository.getBasedOnYear(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31"), new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01"));
		 /*
		  * DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd"); DateFormat
		  * outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss-SSSS");
		  * 
		  * 
		  * Date startDate = outputFormat.parse("2020-01-01"); Date endDate =
		  * outputFormat.parse("2021-01-01");
		  * 
		  * 
		  * 
		  * Criteria c = new
		  * Criteria().andOperator(Criteria.where("period").gte(outputFormat.format(
		  * startDate)), Criteria.where("period").lte(outputFormat.format(endDate)));
		  */
		 /*
		  * String startDate = outputFormat.format(inputFormat.parse("2020-01-01"));
		  * String endDate = outputFormat.format(inputFormat.parse("2021-01-01"));
		  * 
		  * Criteria c = new
		  * Criteria().andOperator(Criteria.where("period").gte(startDate),
		  * Criteria.where("period").lte(endDate)); query.addCriteria(c);
		  */
		 /* mongoTemplate.find(query, EmployeeEntity.class); */
		 System.out.println(list);
		 return list;

		 /*
		  * System.out.println("In filter"); System.out.println(ls); return ls;
		  */

	}

	public List<EmployeeEntity> getBasedOnYearAndDU(Integer year, String DU) throws ParseException{
		Integer st = year-1;
		Integer en = year+1;
		List<EmployeeEntity> list =employeeRepository.getBasedOnYearAndDU(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31"), new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01"), DU );
		System.out.println(list);
		return list;
	}

	public List<EmployeeEntity> getBassedOnYearandQuarter(Integer year, String quarter) throws ParseException{
		Integer st = year-1;
		Integer en = year+1;
		List<EmployeeEntity> list = null;

		if(quarter.equalsIgnoreCase("q1")) {
			list =employeeRepository.getBasedOnYear(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-04-01"));
		}
		else if(quarter.equalsIgnoreCase("q2")) {
			list =employeeRepository.getBasedOnYear(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-03-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-07-01"));
		}
		else if(quarter.equalsIgnoreCase("q3")) {
			list =employeeRepository.getBasedOnYear(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-06-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-10-01"));
		}
		else if(quarter.equalsIgnoreCase("q4")) {
			list =employeeRepository.getBasedOnYear(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-09-31"), new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01"));

		}

		return list;
	}

	public List<EmployeeEntity> getBasedOnYearAndQuarterAndDU(Integer year, String quarter, String DU) throws ParseException{
		Integer st = year-1;
		Integer en = year+1;
		List<EmployeeEntity> list = null;

		if(quarter.equalsIgnoreCase("q1")) {
			list =employeeRepository.getBasedOnYearAndDU(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-04-01"), DU );
		}
		else if(quarter.equalsIgnoreCase("q2")) {
			list =employeeRepository.getBasedOnYearAndDU(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-03-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-07-01"), DU );
		}
		else if(quarter.equalsIgnoreCase("q3")) {
			list =employeeRepository.getBasedOnYearAndDU(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-06-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-10-01"), DU );
		}
		else if(quarter.equalsIgnoreCase("q4")) {
			list =employeeRepository.getBasedOnYearAndDU(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-09-31"), new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01"), DU );

		}

		return list;

	}

	public DistinctIterable<Date> getDistinctPeriod() {
		return mongoTemplate.getCollection("employee_time_data").distinct("period", Date.class);
	}

	public static EmployeeBean convertEmployeeEntityToBean(EmployeeEntity employeeEntity) {
		EmployeeBean employeeBean = new EmployeeBean();
		BeanUtils.copyProperties(employeeEntity, employeeBean);
		return employeeBean;
	}

	public static EmployeeEntity convertEmployeeBeanToEntity(EmployeeBean employeeBean) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeBean, employeeEntity);
		return employeeEntity;
	}


	//year and employee id

	public List<EmployeeEntity> getBasedOnYearAndId(Integer year, Integer employeeId) throws ParseException {
		Integer st = year-1;
		Integer en = year+1;
		List<EmployeeEntity> list =employeeRepository.getBasedOnYearAndId(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31"), new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01"), employeeId);
		return list;
	}

	//quarter and employeeid

	public List<EmployeeEntity> getBasedOnYearAndQuarterAndId(Integer year,String quarter, Integer employeeId) throws ParseException{
		Integer st = year-1;
		Integer en = year+1;
		List<EmployeeEntity> list = null;

		if(quarter.equalsIgnoreCase("q1")) {
			list =employeeRepository.getBasedOnYearAndId(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-04-01"), employeeId);
		}
		else if(quarter.equalsIgnoreCase("q2")) {
			list =employeeRepository.getBasedOnYearAndId(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-03-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-07-01"), employeeId);
		}
		else if(quarter.equalsIgnoreCase("q3")) {
			list =employeeRepository.getBasedOnYearAndId(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-06-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-10-01"), employeeId);
		}
		else if(quarter.equalsIgnoreCase("q4")) {
			list =employeeRepository.getBasedOnYearAndId(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-09-31"), new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01"), employeeId);

		}

		return list;

	}

	//only employeeid

	public List<EmployeeEntity> getBasedOnEmployeeId(Integer employeeId){
		List<EmployeeEntity> list =employeeRepository.getBasedOnEmployeeId(employeeId);
		return list;
	}

/////////////////////////////////////////////////////////////////////////////////////////
////// Get records based on count ////////////////////////	
	
	public List<EmployeeReport> getCountBasedOnYear(Integer year) throws ParseException{ 

		Integer st = year-1;
		Integer en = year+1;
		// Query query = new Query();
		// query.addCriteria(new Criteria().andOperator(Criteria.where("period").gte(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31")), Criteria.where("period").lte(new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01"))));

		/*query.addCriteria(Criteria.where("period").gte(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31")));
		    query.addCriteria(Criteria.where("period").lte(new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01")));*/

		// query.addCriteria(Criteria.where("employeeId").is(212));
		//  long count = mongoTemplate.count(query, EmployeeEntity.class);
		//  System.out.println("count: "+count);

		//Aggregation

		/*
		 * Aggregation agg = newAggregation( match(Criteria.where("period").gte(new
		 * SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31"))),
		 * group("employeeId").count().as("count"),
		 * project("count").and("employeeId").previousOperation() );
		 */


		Aggregation agg = newAggregation( 
				match(Criteria.where("period").gte(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31")).lte(new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01"))),
				group("employeeId","employeeName").count().as("count"),
				project().andExpression("employeeId").as("employeeId").andExpression("count").as("count").andExpression("employeeName").as("employeeName"));


		AggregationResults<EmployeeReport> result = mongoTemplate.aggregate(agg, EmployeeEntity.class, EmployeeReport.class);
		List<EmployeeReport> finalList = result.getMappedResults();
		System.out.println("Printing countdoc list");
		System.out.println(finalList);
		return finalList;
	}
	
	
	
	public List<EmployeeReport> getCountBasedOnYearAndDU(Integer year, String DU) throws ParseException{
		
		Integer st = year - 1 ;
		Integer en = year + 1 ;
		// match(Criteria.where("period").gte(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31")))
		Aggregation agg = newAggregation( 
				match(new Criteria().and("period").gte(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31")).lte(new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01")).and("DU").is(DU)),
				group("employeeId","employeeName").count().as("count"),
				project().andExpression("employeeId").as("employeeId").andExpression("count").as("count").andExpression("employeeName").as("employeeName"));


		AggregationResults<EmployeeReport> result = mongoTemplate.aggregate(agg, EmployeeEntity.class, EmployeeReport.class);
		List<EmployeeReport> finalList = result.getMappedResults();
		System.out.println("Printing countdoc list");
		System.out.println(finalList);
		
		return finalList;
	}

	
	//generalized function to get call fron getcount based on year and quarter
	
public List<EmployeeReport> generalizedGetCountBasedOnYearAndQuarter(Date st, Date en) throws ParseException{
		
		// match(Criteria.where("period").gte(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31")))
		Aggregation agg = newAggregation( 
				match(new Criteria().and("period").gte(st).lte(en)),
				group("employeeId","employeeName").count().as("count"),
				project().andExpression("employeeId").as("employeeId").andExpression("count").as("count").andExpression("employeeName").as("employeeName"));


		AggregationResults<EmployeeReport> result = mongoTemplate.aggregate(agg, EmployeeEntity.class, EmployeeReport.class);
		List<EmployeeReport> finalList = result.getMappedResults();
		System.out.println("Printing countdoc list");
		System.out.println(finalList);
		
		return finalList;
	}
	
	
	public List<EmployeeReport> getCountBasedOnYearandQuarter(Integer year, String quarter) throws ParseException{
		Integer st = year-1;
		Integer en = year+1;
		
		List<EmployeeReport> list = null;

		if(quarter.equalsIgnoreCase("q1")) {
			list = generalizedGetCountBasedOnYearAndQuarter(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-04-01"));
		}
		else if(quarter.equalsIgnoreCase("q2")) {
			list =generalizedGetCountBasedOnYearAndQuarter(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-03-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-07-01"));
		}
		else if(quarter.equalsIgnoreCase("q3")) {
			list =generalizedGetCountBasedOnYearAndQuarter(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-06-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-10-01"));
		}
		else if(quarter.equalsIgnoreCase("q4")) {
			list =generalizedGetCountBasedOnYearAndQuarter(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-09-31"), new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01"));

		}
		
		return list;
	}
	
	
public List<EmployeeReport> generalizedGetCountBasedOnYearAndQuarterAndDU(Date st, Date en, String du) throws ParseException{
		
		// match(Criteria.where("period").gte(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31")))
		Aggregation agg = newAggregation( 
				match(new Criteria().and("period").gte(st).lte(en).and("DU").is(du)),
				group("employeeId","employeeName").count().as("count"),
				project().andExpression("employeeId").as("employeeId").andExpression("count").as("count").andExpression("employeeName").as("employeeName"));


		AggregationResults<EmployeeReport> result = mongoTemplate.aggregate(agg, EmployeeEntity.class, EmployeeReport.class);
		List<EmployeeReport> finalList = result.getMappedResults();
		System.out.println("Printing countdoc list");
		System.out.println(finalList);
		
		return finalList;
	}
	
	
	
	public List<EmployeeReport> getCountBasedOnYearAndQuarterAndDU(Integer year, String quarter, String DU) throws ParseException{
		
		
		Integer st = year-1;
		Integer en = year+1;
		
		List<EmployeeReport> list = null;

		if(quarter.equalsIgnoreCase("q1")) {
			list = generalizedGetCountBasedOnYearAndQuarterAndDU(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-04-01"), DU);
		}
		else if(quarter.equalsIgnoreCase("q2")) {
			list =generalizedGetCountBasedOnYearAndQuarterAndDU(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-03-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-07-01"), DU);
		}
		else if(quarter.equalsIgnoreCase("q3")) {
			list =generalizedGetCountBasedOnYearAndQuarterAndDU(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-06-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-10-01"), DU);
		}
		else if(quarter.equalsIgnoreCase("q4")) {
			list =generalizedGetCountBasedOnYearAndQuarterAndDU(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-09-31"), new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01"), DU);

		}

		return list;
	}
	
	//count -----> year and employee id

		public List<EmployeeReport> getCountBasedOnYearAndId(Integer year, Integer employeeId) throws ParseException {
			Integer st = year-1;
			Integer en = year+1;
			//List<EmployeeEntity> list =employeeRepository.getBasedOnYearAndId(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31"), new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01"), employeeId);
//			return list;
			
			Aggregation agg = newAggregation( 
					match(new Criteria().and("period").gte(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31")).lte(new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01")).and("employeeId").is(employeeId)),
					group("employeeId","employeeName").count().as("count"),
					project().andExpression("employeeId").as("employeeId").andExpression("count").as("count").andExpression("employeeName").as("employeeName"));


			AggregationResults<EmployeeReport> result = mongoTemplate.aggregate(agg, EmployeeEntity.class, EmployeeReport.class);
			List<EmployeeReport> finalList = result.getMappedResults();
			System.out.println("Printing countdoc list");
			System.out.println(finalList);
			
			return finalList;
			
		}

		
		//generalized function called from getbasedon year quarter and id
		
		public List<EmployeeReport> generalizedGetCountBasedOnYearAndQuarterAndId(Date st, Date en, Integer id) throws ParseException{
			
			// match(Criteria.where("period").gte(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31")))
			Aggregation agg = newAggregation( 
					match(new Criteria().and("period").gte(st).lte(en).and("employeeId").is(id)),
					group("employeeId","employeeName").count().as("count"),
					project().andExpression("employeeId").as("employeeId").andExpression("count").as("count").andExpression("employeeName").as("employeeName"));


			AggregationResults<EmployeeReport> result = mongoTemplate.aggregate(agg, EmployeeEntity.class, EmployeeReport.class);
			List<EmployeeReport> finalList = result.getMappedResults();
			System.out.println("Printing countdoc list");
			System.out.println(finalList);
			
			return finalList;
		}
		
		
		//quarter and employeeid

		public List<EmployeeReport> getCountBasedOnYearAndQuarterAndId(Integer year,String quarter, Integer employeeId) throws ParseException{
			Integer st = year-1;
			Integer en = year+1;
			List<EmployeeReport> list = null;

			if(quarter.equalsIgnoreCase("q1")) {
				list =generalizedGetCountBasedOnYearAndQuarterAndId(new SimpleDateFormat("yyyy-MM-dd").parse(st.toString()+"-12-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-04-01"), employeeId);
			}
			else if(quarter.equalsIgnoreCase("q2")) {
				list =generalizedGetCountBasedOnYearAndQuarterAndId(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-03-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-07-01"), employeeId);
			}
			else if(quarter.equalsIgnoreCase("q3")) {
				list =generalizedGetCountBasedOnYearAndQuarterAndId(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-06-31"), new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-10-01"), employeeId);
			}
			else if(quarter.equalsIgnoreCase("q4")) {
				list =generalizedGetCountBasedOnYearAndQuarterAndId(new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-09-31"), new SimpleDateFormat("yyyy-MM-dd").parse(en.toString()+"-01-01"), employeeId);

			}

			return list;

		}

		//only employeeid

		public List<EmployeeReport> getCountBasedOnEmployeeId(Integer employeeId){
			Aggregation agg = newAggregation( 
					match(new Criteria().and("employeeId").is(employeeId)),
					group("employeeId","employeeName").count().as("count"),
					project().andExpression("employeeId").as("employeeId").andExpression("count").as("count").andExpression("employeeName").as("employeeName"));


			AggregationResults<EmployeeReport> result = mongoTemplate.aggregate(agg, EmployeeEntity.class, EmployeeReport.class);
			List<EmployeeReport> finalList = result.getMappedResults();
			System.out.println("Printing countdoc list");
			System.out.println(finalList);
			
			return finalList;
		}
		
		public List<EmployeeReport> getCountAll(){
			Aggregation agg = newAggregation( 
					group("employeeId","employeeName").count().as("count"),
					project().andExpression("employeeId").as("employeeId").andExpression("count").as("count").andExpression("employeeName").as("employeeName"));


			AggregationResults<EmployeeReport> result = mongoTemplate.aggregate(agg, EmployeeEntity.class, EmployeeReport.class);
			List<EmployeeReport> finalList = result.getMappedResults();
			System.out.println("Printing countdoc list");
			System.out.println(finalList);
			
			return finalList;
		}

		public List<EmployeeReport> getCountBasedOnDu(String du){
			Aggregation agg = newAggregation( 
					match(new Criteria().and("DU").is(du)),
					group("employeeId","employeeName").count().as("count"),
					project().andExpression("employeeId").as("employeeId").andExpression("count").as("count").andExpression("employeeName").as("employeeName"));


			AggregationResults<EmployeeReport> result = mongoTemplate.aggregate(agg, EmployeeEntity.class, EmployeeReport.class);
			List<EmployeeReport> finalList = result.getMappedResults();
			System.out.println("Printing countdoc list");
			System.out.println(finalList);
			
			return finalList;
		}

		public List<EmployeeEntity> getBasedOnDu(String du) throws ParseException {
			
			List<EmployeeEntity> list = employeeRepository.getBasedOnDu(du);
			return list;
		}
		public boolean checkIfRecordWithGivenBridAndPeriodAvailable(String brid, Date period) {
			if(employeeRepository.checkIfRecordWithGivenBridAndPeriodAvailable(brid, period)!=null)
				return true;
			else
				return false;
		}
		public void insertList(List<EmployeeEntity> emInsertList) {
			employeeRepository.saveAll(emInsertList);
		}

}