package com.student.service;

import java.util.List;

import com.student.dto.DepartmentDTO;
import com.student.entity.Department;

public interface DepartmentService {
	 List<Department> getAllDepartments();
	 String saveDepartment(DepartmentDTO dto);
	 String updateDepartment(Integer id, DepartmentDTO dto);
	 String deleteDepartment(Integer id);
}
