/*
  Name:Shivam Gawande
  Creation Date:26-09-24
  Register(Password encrypted or hashing) and login
 */
package com.login.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeDTO {
    private int id;
    private String name;
    private String username;
    private String email;
    private String pass;
}
