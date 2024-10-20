/*
  Name:Shivam Gawande
  Task Assign Date Date:27-09-24
  Task Completion Date:01-10-24
  Creating filter JD using Team and all
 */
package com.login.service;

import com.login.dto.JobDescriptionDTO;
import com.login.entity.JobDescription;
import com.login.entity.Recruiter;
import com.login.entity.TeamLeader;

import java.util.List;

public interface JDService {
    String saveJobDescription(JobDescriptionDTO jobDescriptionDTO, TeamLeader teamLeader);

    List<JobDescription> jobsWhereVisibityIsTeam(Integer teamLeader_Id);

    List<JobDescription> getJobsForRecruiter(String visibility,Integer recruiter_Id);

}
