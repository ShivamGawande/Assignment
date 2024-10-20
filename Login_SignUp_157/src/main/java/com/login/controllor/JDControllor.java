/*
  Name:Shivam Gawande
  Task Assign Date Date:27-09-24
  Task Completion Date:01-10-24
  Creating filter JD using Team and all
 */
package com.login.controllor;

import com.login.dto.JobDescriptionDTO;
import com.login.entity.JobDescription;
import com.login.entity.Recruiter;
import com.login.entity.TeamLeader;
import com.login.service.JDServiceImpl;
import com.login.service.TLeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JDControllor {

    @Autowired
    private TLeaderService teamLeaderService;

    @Autowired
    private JDServiceImpl jobDescriptionService;

    @PostMapping("/createJobDescription")
    public ResponseEntity<String> createJobDescription(@RequestBody JobDescriptionDTO jobDescriptionDTO, @RequestParam int teamLeaderId) {
        TeamLeader teamLeader = teamLeaderService.findById(teamLeaderId);  // Fetch the team leader by ID
        jobDescriptionService.saveJobDescription(jobDescriptionDTO, teamLeader);
        return new ResponseEntity<>("Job Description created successfully!", HttpStatus.CREATED);
    }

//    @GetMapping("/team")
//    public ResponseEntity<List<JobDescription>> findJobByTeam(@PathVariable Integer id){
//        List<JobDescription> team = jobDescriptionService.jobsWhereVisibityIsTeam(id);
//        return ResponseEntity.ok(team);
//    }

//    @GetMapping("/team/{teamLeaderId}")
//    public ResponseEntity<List<JobDescription>> findJobByTeamById(@PathVariable Integer teamLeaderId) {
//        List<JobDescription> teamJobs = jobDescriptionService.jobsWhereVisibityIsTeam(teamLeaderId);
//        return ResponseEntity.ok(teamJobs);
//    }

    @GetMapping("/teamjob/{visibility}/{recruiter_Id}")
    public ResponseEntity<List<JobDescription>> findJobsForRecruiter(@PathVariable String visibility,@PathVariable Integer recruiter_Id){
        List<JobDescription> teamJobs=jobDescriptionService.getJobsForRecruiter(visibility,recruiter_Id);
        return ResponseEntity.ok(teamJobs);
    }


}
