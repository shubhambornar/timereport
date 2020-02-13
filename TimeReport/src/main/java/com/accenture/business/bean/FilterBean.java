	package com.accenture.business.bean;

public class FilterBean {
	private Integer year;
	private String quarter;
	private String du;
	private Integer employeeId;
	private boolean isCount;
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getDu() {
		return du;
	}
	public void setDu(String du) {
		this.du = du;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public boolean getIsCount() {
		return isCount;
	}
	public void setIsCount(boolean isCount) {
		this.isCount = isCount;
	}
	@Override
	public String toString() {
		return "FilterBean [year=" + year + ", quarter=" + quarter + ", du=" + du + ", employeeId=" + employeeId
				+ ", isCount=" + isCount + "]";
	}
	
	
	
}
