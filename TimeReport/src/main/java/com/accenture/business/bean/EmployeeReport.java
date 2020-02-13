package com.accenture.business.bean;

public class EmployeeReport {
	private Integer employeeId;
	private long count;
	private String employeeName;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@Override
	public String toString() {
		return "EmployeeReport [employeeId=" + employeeId + ", count=" + count + ", employeeName=" + employeeName + "]";
	}
	
	
}

