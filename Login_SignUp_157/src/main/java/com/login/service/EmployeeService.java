/*
  Name:Shivam Gawande
  Creation Date:26-09-24
  Register(Password encrypted or hashing) and login
 */
package com.login.service;

import com.login.dto.EmployeeDTO;
import com.login.dto.EmployeeLoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmployeeService {
    String login(EmployeeLoginDTO dto);
    ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO dto);
}
