/*
  Name:Shivam Gawande
  Task Assign Date Date:27-09-24
  Task Completion Date:01-10-24
  Creating filter JD using Team and all
 */
package com.login.repo;

import com.login.entity.JobDescription;
import com.login.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobDescriptionRepo extends JpaRepository<JobDescription, Integer> {

    List<JobDescription> findByVisibilityIgnoreCaseAndTeamLeaderId(String visibility, Integer teamLeaderId);

    List<JobDescription> findByVisibilityIgnoreCase(String visibility);

}

