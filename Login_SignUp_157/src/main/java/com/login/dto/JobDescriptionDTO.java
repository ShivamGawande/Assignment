/*
  Name:Shivam Gawande
  Task Assign Date Date:27-09-24
  Task Completion Date:01-10-24
  Creating filter JD using Team and all
 */


package com.login.dto;

import lombok.Data;

@Data
public class JobDescriptionDTO {
    private String companyName;
    private String designation;
    private int position;
    private String qualification;
    private String field;
    private String passYear;
    private String visibility;  // "team" or "all"
}
