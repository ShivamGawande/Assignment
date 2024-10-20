package com.student.dto;

import java.util.Set;

public class StudentDTO {
	
	private String studentName;
	private Long studentNumber;
	private Integer studentAge;
	private String departmentName;
	public StudentDTO(String studentName, Long studentNumber, Integer studentAge, String departmentName) {
		super();
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		this.studentAge = studentAge;
		this.departmentName = departmentName;
	}
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Long getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(Long studentNumber) {
		this.studentNumber = studentNumber;
	}
	public Integer getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
