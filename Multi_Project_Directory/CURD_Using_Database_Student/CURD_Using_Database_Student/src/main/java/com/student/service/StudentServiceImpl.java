package com.student.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.StudentDTO;
import com.student.entity.Department;
import com.student.entity.Student;
import com.student.repo.DepartmentRepo;
import com.student.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Override
	public List<StudentDTO> getAllStudents() {
		
		return studentRepo.findAll().stream()
				.map(student -> new StudentDTO(student.getStudentName(), student.getStudentNumber(), student.getStudentAge(), student.getDepartment().getDepartmentName()))
				.collect(Collectors.toList());
	}

	@Override
	public StudentDTO getStudentById(Integer id) {
		return studentRepo.findById(id).map(student -> new StudentDTO(student.getStudentName(), student.getStudentNumber(), student.getStudentAge(), student.getDepartment().getDepartmentName()))
			   .orElseThrow(()->new RuntimeException("Student not found"));
	}

	@Override
	public String saveStudent(StudentDTO dto) {
		
		Student student = new Student();
		student.setStudentAge(dto.getStudentAge());
		student.setStudentName(dto.getStudentName());
		student.setStudentNumber(dto.getStudentNumber());
		
		Optional<Department> department = departmentRepo.findByDepartmentName(dto.getDepartmentName());
		if(department.isPresent()) {
			student.setDepartment(department.get());
			studentRepo.save(student);
			return student.getStudentName()+ "Registration Successful";
		}else {
			throw new RuntimeException("Department not found");
		}
		
	}

	@Override
	public String updateStudent(Integer id, StudentDTO dTO) {
	    Optional<Student> studentOptional = studentRepo.findById(id);
	    if (studentOptional.isPresent()) {
	        Student student = studentOptional.get();
	        
	        if (dTO.getStudentAge() != null && dTO.getStudentAge() > 0) {
	            student.setStudentAge(dTO.getStudentAge());
	        }
	        
	        if (dTO.getStudentName() != null && !dTO.getStudentName().trim().isEmpty()) {
	            student.setStudentName(dTO.getStudentName());
	        }
	        
	        if (dTO.getStudentNumber() != null && dTO.getStudentNumber() > 0) {
	            student.setStudentNumber(dTO.getStudentNumber());
	        }

	        Optional<Department> departmentOpt = departmentRepo.findByDepartmentName(dTO.getDepartmentName());
	        if (departmentOpt.isPresent()) {
	            student.setDepartment(departmentOpt.get());
	        } else {
	            throw new RuntimeException("Department not found");
	        }

	        studentRepo.save(student);
	        return "Student updated successfully";
	    } else {
	        throw new RuntimeException("Student not found");
	    }
	}

	@Override
	public String deletStudent(Integer id) {
		if(studentRepo.findById(id).isPresent()) {
			studentRepo.deleteById(id);
			return "Student deleted successfully ";
		}else {
			return "Student Id not found";
		}
	}

}
