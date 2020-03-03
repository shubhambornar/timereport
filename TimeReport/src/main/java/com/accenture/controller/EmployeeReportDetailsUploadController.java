package com.accenture.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.text.html.parser.Entity;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.entity.EmployeeDetails;
import com.accenture.entity.EmployeeEntity;
import com.accenture.repository.EmployeeReportUploadWraper;
import com.accenture.repository.EmployeeWrapper;

@RestController
//@Scope("session")
@RequestMapping(value = "/accenture",method = { RequestMethod.GET, RequestMethod.POST })
@SessionAttributes(value = "emInsertList")
@MultipartConfig
public class EmployeeReportDetailsUploadController {
	
	@Autowired
	private EmployeeWrapper employeeWrapper;
	
	@Autowired
	private EmployeeReportUploadWraper employeeReportUploadWraper;
	
	@RequestMapping(value = "/upload", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView showUpload() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insert");
		return modelAndView;
	}
	@RequestMapping(value = "/insert", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView insert(@RequestParam(name = "fileToUpload") Part  file, HttpSession session) throws IOException, ParseException {
		
		Integer itr=13,count=0;
		List<EmployeeEntity> emInsertList = new ArrayList<EmployeeEntity>();
		List<EmployeeEntity> emRejectList = new ArrayList<EmployeeEntity>();

	
		    String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		    InputStream fileContent = file.getInputStream();
		    System.out.println(fileName);
		
				XSSFWorkbook workbook = new XSSFWorkbook(fileContent);
				XSSFSheet sheet = workbook.getSheetAt(0);
				Iterator<Row> ite = sheet.rowIterator();
				ite.next();
		/*
		 * while(ite.hasNext()){ Row row = ite.next(); Iterator<Cell> cite =
		 * row.cellIterator(); while(cite.hasNext()){ Cell c = cite.next();
		 * System.out.print(c.toString() +"  "); } System.out.println(); }
		 */
				
				while(ite.hasNext()){
					count++;
					
					
					Row row = ite.next();
					if(count<15)
						continue;
					//Iterator<Cell> cite = row.cellIterator();
					//4 brid
					String brid = row.getCell(4).toString();
					System.out.println(row.getCell(4)+":");
					
					EmployeeDetails employeeDetails = employeeReportUploadWraper.getBasedOnBRID(brid);

					
					//13 date
					itr=13;
					while(row.getCell(itr) != null){
						
						if(!row.getCell(itr).toString().equals("On Time")) {
							EmployeeEntity emEntity = new EmployeeEntity();

							LocalDate date = sheet.getRow(0).getCell(itr).getLocalDateTimeCellValue().toLocalDate(); 
							Date period = java.sql.Date.valueOf(date);
							
					
							emEntity.setBRID(brid);
							emEntity.setPeriod(period);
							//emEntity.setEmployeeName(employeeDetails.getEmployeeName());
							
							if(brid.equals("G01061958"))        //CHANGE THIS
							emEntity.setDU(employeeDetails.getDU());
							//emEntity.setAccentureEmailId(employeeDetails.getAccentureEmailId());
							//role
							//level
							
							//System.out.println("calliing check function"+ employeeWrapper.checkIfRecordWithGivenBridAndPeriodAvailable(brid, period));
							if(employeeWrapper.checkIfRecordWithGivenBridAndPeriodAvailable(brid, period)) {
								emRejectList.add(emEntity);
							}
							else {
								emInsertList.add(emEntity);

							}
							//System.out.println("Getting employeedetails: "+employeeReportUploadWraper.getBasedOnBRID("G01061958"));
							//fetch employee id from eployeedetails
							
							//emEntity.setEmployeeId(employeeId);
						}
						itr++;
					}
					System.out.println();
					
					if(count==19)   //CHANGE THIS
						break;
					
				}
				
				fileContent.close();
				
				
		//session.setAttribute("sInsertList", emInsertList);
		//session.setAttribute("sRejectList", emRejectList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("emInsertList", emInsertList);
		modelAndView.addObject("emRejectList", emRejectList);
		modelAndView.setViewName("insertReport");
		return modelAndView;
	}
	
	@RequestMapping(value = "/insertConfirm", method = RequestMethod.GET)
	public ModelAndView insertConfirm( @SessionAttribute("emInsertList")List<EmployeeEntity> emInsertList) {
		//HttpSession session
		System.out.println("In insertconfirm to save records");
		//List<EmployeeEntity> list = (List<EmployeeEntity>) session.getAttribute("emInsertList");
		//System.out.println(emInsertList);
		
		employeeWrapper.insertList(emInsertList);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("upload");
		return modelAndView;
	}
}
