/*
  Name:Shivam Gawande
  Task Assign Date Date:27-09-24
  Task Completion Date:01-10-24
  Creating filter JD using Team and all
 */
package com.login.service;

import com.login.dto.TeamLeaderDTO;
import com.login.entity.Recruiter;
import com.login.entity.TeamLeader;

import java.util.List;
import java.util.Set;

public interface TLeaderService {
    TeamLeaderDTO createTeamLeader(TeamLeaderDTO teamLeaderDTO);
    Set<Recruiter> getRecruiter(Integer id);

    TeamLeader findById(Integer id);


}
