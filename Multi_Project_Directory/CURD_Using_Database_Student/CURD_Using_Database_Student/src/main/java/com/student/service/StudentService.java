package com.student.service;

import java.util.List;

import com.student.dto.StudentDTO;

public interface StudentService {
	public List<StudentDTO> getAllStudents();
	public StudentDTO getStudentById(Integer id);
	String saveStudent(StudentDTO dto);
	String updateStudent(Integer id, StudentDTO studentDTO);
	String deletStudent(Integer id);
}
