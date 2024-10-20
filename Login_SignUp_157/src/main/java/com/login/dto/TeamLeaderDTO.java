/*
  Name:Shivam Gawande
  Task Assign Date Date:27-09-24
  Task Completion Date:01-10-24
  Creating filter JD using Team and all
 */
package com.login.dto;

import lombok.Data;
import java.util.Set;

@Data
public class TeamLeaderDTO {
    private int teamLeaderId;
    private String teamLeaderName;
    private String userName;
    private String tlDepartment;
    private String tlOfficialMail;
    private String tlPersonalEmailId;
    private long tlOfficialContactNo;
    private String tlGender;

    private Set<RecruiterDTO> recruiters;
}
