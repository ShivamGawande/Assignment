package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.DepartmentDTO;
import com.student.entity.Department;
import com.student.repo.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public List<Department> getAllDepartments() {
		
		return departmentRepo.findAll();
	}

	@Override
	public String saveDepartment(DepartmentDTO dto) {
		Department department = new Department();
		department.setDepartmentName(dto.getDepartmentName());
		departmentRepo.save(department);
		return "Department added successfully";
	}

	@Override
	public String updateDepartment(Integer id, DepartmentDTO dto) {
		Optional<Department> existingDepartmentOpt = departmentRepo.findById(id);
        if (existingDepartmentOpt.isPresent()) {
            Department existingDepartment = existingDepartmentOpt.get();
            existingDepartment.setDepartmentName(dto.getDepartmentName());
            departmentRepo.save(existingDepartment);
            return "Department updated successfully"; 
        } else {
            throw new RuntimeException("Department not found");
        }
	}

	@Override
	public String deleteDepartment(Integer id) {
		departmentRepo.deleteById(id);
		return "department Successfully";
		
	}
}
