package com.accenture.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.business.bean.EmployeeReport;
import com.accenture.business.bean.FilterBean;
import com.accenture.entity.EmployeeEntity;
import com.accenture.repository.EmployeeWrapper;
import com.mongodb.client.DistinctIterable;



@RestController
@RequestMapping(value = "/accenture",method = { RequestMethod.GET, RequestMethod.POST })
@SessionAttributes(value = "filterObj")
public class EmployeeController {
	@Autowired
	private EmployeeWrapper employeeWrapper;
	

	/*
	 * @Autowired private EmpRepo emprepo;
	 */

	/* @RequestMapping(method = "GET", value = "/getAll") */
	/*
	 * @PostMapping(value = "/getAll")
	 */	
	@RequestMapping(value = "/timereport", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getAll(FilterBean filterObj) throws ParseException, IOException {


		
		
		System.out.println("In getAll controller");
		System.out.println(filterObj);
		if(filterObj.getYear()==null)
			filterObj.setYear(0);
		if(filterObj.getQuarter()==null)
			filterObj.setQuarter("all");
		if(filterObj.getDu()==null)
			filterObj.setDu("all");
		System.out.println(filterObj);
		//	System.out.println(emprepo.findDistinctPeriod());
		ModelAndView modelAndView = new ModelAndView();
		
		List<EmployeeEntity> documentList = null;
		List<EmployeeReport> employeeReportList = null;
		
		if(filterObj.getIsCount()==false) {
			if(filterObj.getYear()!=0 && filterObj.getQuarter()=="all" && filterObj.getEmployeeId()!=null) {
				// Selected ->Year and employeeID

				documentList = employeeWrapper.getBasedOnYearAndId(filterObj.getYear(), filterObj.getEmployeeId());

			}
			else if(filterObj.getYear()!=0 && filterObj.getQuarter()!="all" && filterObj.getEmployeeId()!=null) {
				// Selected -> Year, Quarter and EmployeeId
				documentList = employeeWrapper.getBasedOnYearAndQuarterAndId(filterObj.getYear(), filterObj.getQuarter(), filterObj.getEmployeeId());

			}
			else if(filterObj.getYear()==0 && filterObj.getQuarter()=="all" && filterObj.getEmployeeId()!=null)
			{
				// Selected only user ID
				documentList = employeeWrapper.getBasedOnEmployeeId(filterObj.getEmployeeId());
			}

			else if ( filterObj.getDu()=="all" && filterObj.getQuarter()=="all" && filterObj.getYear()!=0)
			{

				//selected - > year
				try {
					documentList =	employeeWrapper.getBasedOnYear(filterObj.getYear());
				} catch (ParseException e) {	
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(filterObj.getDu()=="all" && filterObj.getQuarter()!="all" && filterObj.getYear()!=0)
			{
				//selected - > year and quarter
				documentList = employeeWrapper.getBassedOnYearandQuarter(filterObj.getYear(), filterObj.getQuarter());
			}
			else if(filterObj.getDu()!="all" && filterObj.getQuarter()=="all"  && filterObj.getYear()!=0) {

				//selected -> year and du
				documentList =	employeeWrapper.getBasedOnYearAndDU(filterObj.getYear(), filterObj.getDu());
			}
			else if(filterObj.getDu()!="all" && filterObj.getQuarter()=="all"  && filterObj.getYear()==0) {
					documentList = employeeWrapper.getBasedOnDu(filterObj.getDu());
			}
			else if(filterObj.getDu()!="all" && filterObj.getQuarter()!="all" && filterObj.getYear()!=0) {

				//selected - > year du and quarter
				documentList = employeeWrapper.getBasedOnYearAndQuarterAndDU(filterObj.getYear(), filterObj.getQuarter(), filterObj.getDu());
			}
			else
				documentList = employeeWrapper.getAll();
		}
		else {
			// this is else to display employee with count on basis of various criteria
			///////////
			//////////
			//////////
			System.out.println("In else");
			if(filterObj.getYear()!=0 && filterObj.getQuarter()=="all" && filterObj.getEmployeeId()!=null) {
				// Selected ->Year and employeeID

				employeeReportList = employeeWrapper.getCountBasedOnYearAndId(filterObj.getYear(), filterObj.getEmployeeId());

			}
			else if(filterObj.getYear()!=0 && filterObj.getQuarter()!="all" && filterObj.getEmployeeId()!=null) {
				// Selected -> Year, Quarter and EmployeeId
				employeeReportList = employeeWrapper.getCountBasedOnYearAndQuarterAndId(filterObj.getYear(), filterObj.getQuarter(), filterObj.getEmployeeId());

			}
			else if(filterObj.getYear()==0 && filterObj.getQuarter()=="all" && filterObj.getEmployeeId()!=null)
			{
				// Selected only user ID
				employeeReportList = employeeWrapper.getCountBasedOnEmployeeId(filterObj.getEmployeeId());
			}

			else if ( filterObj.getDu()=="all" && filterObj.getQuarter()=="all" && filterObj.getYear()!=0)
			{

				//selected - > year
				try {
					employeeReportList =	employeeWrapper.getCountBasedOnYear(filterObj.getYear());
				} catch (ParseException e) {	
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(filterObj.getDu()=="all" && filterObj.getQuarter()!="all" && filterObj.getYear()!=0)
			{
				//selected - > year and quarter
				employeeReportList = employeeWrapper.getCountBasedOnYearandQuarter(filterObj.getYear(), filterObj.getQuarter());
			}
			else if(filterObj.getDu()!="all" && filterObj.getQuarter()=="all"  && filterObj.getYear()!=0) {

				//selected -> year and du
				employeeReportList =	employeeWrapper.getCountBasedOnYearAndDU(filterObj.getYear(), filterObj.getDu());
			}
			else if(filterObj.getDu()!="all" && filterObj.getQuarter()=="all"  && filterObj.getYear()==0) {
					employeeReportList = employeeWrapper.getCountBasedOnDu(filterObj.getDu());
			}
			else if(filterObj.getDu()!="all" && filterObj.getQuarter()!="all" && filterObj.getYear()!=0) {

				//selected - > year du and quarter
				employeeReportList = employeeWrapper.getCountBasedOnYearAndQuarterAndDU(filterObj.getYear(), filterObj.getQuarter(), filterObj.getDu());
			}
			else
				employeeReportList = employeeWrapper.getCountAll();
			
			System.out.println("Printing employee Report List: "+employeeReportList);
		}
		modelAndView.addObject("list", documentList );
		modelAndView.addObject("reportList", employeeReportList);
		modelAndView.addObject("filterObj", filterObj);
		modelAndView.setViewName("report");

		return modelAndView;
	}


	@ModelAttribute(value="filterObj")
	public FilterBean getFilterBean() {
		return new FilterBean();
	}
	
	@ModelAttribute(value="yearObj")
	public List<Integer> getYearList(){
		List<Integer> list = new ArrayList<>();
		list.add(2018);
		list.add(2019);
		list.add(2020);
		list.add(2021);
		System.out.println("Returning list of dates");
		return list;
	}
	
	@ModelAttribute(value="quarterList")
	public List<String> getQuarterList(){
		List<String> list = new ArrayList<>();
		list.add("Q1");
		list.add("Q2");
		list.add("Q3");
		list.add("Q4");
		System.out.println("Returning list of quarters");
		return list;
	}
	
	
	@ModelAttribute(value="duList")
	public List<String> getDuList(){
		List<String> list = new ArrayList<>();
		list.add("FSBBAR01");
		list.add("FSBBAR02");
		list.add("FSBBAR03");
		list.add("FSBBAR04");
		System.out.println("Returning list of years");
		return list;
	}
	
	/*	
	 * @ModelAttribute(value = "dateList") public DistinctIterable<Date>
	 * getAllDateList(){ DistinctIterable<Date>
	 * list=employeeWrapper.getDistinctPeriod() ;
	 * System.out.println(list.first().toString()); return list; }
	 */

	@ModelAttribute(value = "filterObj") 
	public FilterBean getAllDateList(){
		FilterBean bean = new FilterBean();
		System.out.println("after crearing bean");
		return bean; 
	}


	@RequestMapping(value = "/upload", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView showUpload() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insert");
		return modelAndView;
	}
	@RequestMapping(value = "/insert", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView insert(@RequestParam(name = "fileToUpload") MultipartFile  file) throws IOException {
		
		
		//read excel
			System.out.println("in insert"+file.getOriginalFilename());
		
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	                    System.out.println(fileName);
	                    
			FileInputStream fis = new FileInputStream(new File(fileName));
				
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheetAt(0);
				Iterator<Row> ite = sheet.rowIterator();
				while(ite.hasNext()){
					Row row = ite.next();
					Iterator<Cell> cite = row.cellIterator();
					while(cite.hasNext()){
						Cell c = cite.next();
						System.out.print(c.toString() +"  ");
					}
					System.out.println();
				}
				fis.close();
				
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insert");
		return modelAndView;
	}

}
