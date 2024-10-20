package com.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
	Optional<Department> findByDepartmentName(String name);
}
