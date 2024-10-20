package com.student.dto;

public class DepartmentDTO {
	
	private String DepartmentName;

	public DepartmentDTO(String departmentName) {
		super();
		DepartmentName = departmentName;
	}

	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	
}
