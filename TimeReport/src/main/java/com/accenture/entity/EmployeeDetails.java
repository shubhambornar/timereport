package com.accenture.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "employee_details")
public class EmployeeDetails {
	@Id
	private String _id;
	private Integer employeeId;
	private String employeeName;
	private Integer level;
	private String accentureEmailId;
	private String DU;
	private String BRID;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getBRID() {
		return BRID;
	}
	public void setBRID(String bRID) {
		BRID = bRID;
	}
	public String getDU() {
		return DU;
	}
	public void setDU(String dU) {
		DU = dU;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getAccentureEmailId() {
		return accentureEmailId;
	}
	public void setAccentureEmailId(String accentureEmailId) {
		this.accentureEmailId = accentureEmailId;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [_id=" + _id + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", level=" + level + ", accentureEmailId=" + accentureEmailId + ", DU=" + DU + ", BRID=" + BRID + "]";
	}
	
}
