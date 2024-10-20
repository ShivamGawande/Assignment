/*
  Name:Shivam Gawande
  Creation Date:26-09-24
  Register(Password encrypted or hashing) and login
 */
package com.login.controllor;

import com.login.dto.EmployeeDTO;
import com.login.dto.EmployeeLoginDTO;
import com.login.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Login {

    @Autowired
    private EmployeeService employee;

    @PostMapping("/login")
    public String login(@RequestBody EmployeeLoginDTO dto){
        return employee.login(dto);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO dto){
        return employee.createEmployee(dto);
    }
}
