/*
  Name:Shivam Gawande
  Creation Date:26-09-24
  Register(Password encrypted or hashing) and login
 */
package com.login.service;
import com.login.dto.EmployeeDTO;
import  com.login.entity.Employee;
import com.login.dto.EmployeeLoginDTO;
import com.login.repo.EmployeeRepo;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@NoArgsConstructor
@Data
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String login(EmployeeLoginDTO dto) {
        Optional<Employee> empOptional = employeeRepo.findByUsernameOrEmail(dto.getUsernameOrEmail());

        if (empOptional.isPresent()) {
            Employee emp = empOptional.get();

            if (passwordEncoder.matches(dto.getPass(), emp.getPass())) {
                return "Login Success";
            }
        }

        return "Invalid credentials";
    }

    @Override
    public ResponseEntity<String> createEmployee(EmployeeDTO dto) {

        if ((employeeRepo.findByUsernameOrEmail(dto.getEmail()).isPresent())||employeeRepo.findByUsernameOrEmail(dto.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body("Email or Username already present");
        }

        String hashedPassword = passwordEncoder.encode(dto.getPass());

        Employee emp = Employee.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .username(dto.getUsername())
                .pass(hashedPassword)
                .build();


        employeeRepo.save(emp);

        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
    }
}
