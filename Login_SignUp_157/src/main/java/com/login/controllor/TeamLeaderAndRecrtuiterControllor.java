/*
  Name:Shivam Gawande
  Task Assign Date Date:27-09-24
  Task Completion Date:01-10-24
  Creating filter JD using Team and all
 */

package com.login.controllor;

import com.login.dto.TeamLeaderDTO;
import com.login.entity.Recruiter;
import com.login.service.RecruiterService;
import com.login.service.TLeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class TeamLeaderAndRecrtuiterControllor {

    @Autowired
    private TLeaderService teamLeaderService;
    @Autowired
    private RecruiterService recruiterService;

    @PostMapping("/createTeamLeader")
    public ResponseEntity<TeamLeaderDTO> createTeamLeader(@RequestBody TeamLeaderDTO teamLeaderDTO) {
        TeamLeaderDTO createdTeamLeader = teamLeaderService.createTeamLeader(teamLeaderDTO);
        return new ResponseEntity<>(createdTeamLeader, HttpStatus.CREATED);
    }

    @GetMapping("/getbyid/{id}")
    public Set<Recruiter> getTeamLeadersRecruiters(@PathVariable Integer id){
        return teamLeaderService.getRecruiter(id);
    }

}
