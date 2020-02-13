package com.accenture.entity;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "employee_time_data")
public class EmployeeEntity {

	@Id
	private String _id;
	private Integer employeeId;
	private String employeeName;
	private Integer level;
	private String accentureEmailId;
	private String DU;
	private String BRID;
	private String status;
	private String role;
	private Date period;

	public String getId() {
		return _id;
	}
	public void setId(String _id) {
		this._id = _id;
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
	public String getDU() {
		return DU;
	}
	public void setDU(String dU) {
		DU = dU;
	}
	public String getBRID() {
		return BRID;
	}
	public void setBRID(String bRID) {
		BRID = bRID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [_id=" + _id + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", level=" + level + ", accentureEmailId=" + accentureEmailId + ", DU=" + DU + ", BRID=" + BRID
				+ ", status=" + status + ", role=" + role + ", period=" + period + "]";
	}
	
}
