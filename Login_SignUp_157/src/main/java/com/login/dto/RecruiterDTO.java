/*
  Name:Shivam Gawande
  Task Assign Date Date:27-09-24
  Task Completion Date:01-10-24
  Creating filter JD using Team and all
 */
package com.login.dto;

import lombok.Data;

@Data
public class RecruiterDTO {
    private int employeeId;
    private String employeeName;
    private String userName;
    private String designation;
    private String department;
    private String officialMail;
    private String employeeEmail;
    private long officialContactNumber;
    private String gender;

    // Reference to TeamLeaderDTO
    private TeamLeaderDTO teamLeader;
}

