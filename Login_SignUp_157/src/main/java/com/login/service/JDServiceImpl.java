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
import com.login.repo.JobDescriptionRepo;
import com.login.repo.RecruiterRepo;
import com.login.repo.TLeaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JDServiceImpl implements  JDService{

    @Autowired
    private JobDescriptionRepo jobDescriptionRepo;

    @Autowired
    private RecruiterRepo recruiterRepository;

    @Autowired
    private TLeaderRepo tLeaderRepo;

    @Autowired
    private TLeaderService tLeaderService;

    public String saveJobDescription(JobDescriptionDTO jobDescriptionDTO, TeamLeader teamLeader) {
        JobDescription jobDescription = new JobDescription();
        jobDescription.setCompanyName(jobDescriptionDTO.getCompanyName());
        jobDescription.setDesignation(jobDescriptionDTO.getDesignation());
        jobDescription.setPosition(jobDescriptionDTO.getPosition());
        jobDescription.setQualification(jobDescriptionDTO.getQualification());
        jobDescription.setField(jobDescriptionDTO.getField());
        jobDescription.setVisibility(jobDescriptionDTO.getVisibility());
        jobDescription.setYear_of_passing(jobDescriptionDTO.getPassYear());
        jobDescription.setTeamLeaderId(teamLeader.getTeamLeaderId());

       jobDescriptionRepo.save(jobDescription);
        return "Job Description created successfully!";
    }



    @Override
    public List<JobDescription> jobsWhereVisibityIsTeam(Integer teamLeader_Id) {

        return jobDescriptionRepo.findByVisibilityIgnoreCaseAndTeamLeaderId("Team",teamLeader_Id);
    }


    public List<JobDescription> getJobsForRecruiter(String visibility,Integer recruiter_Id){
        Recruiter recruiter=recruiterRepository.findById(recruiter_Id).get();
        TeamLeader teamLeader=tLeaderRepo.findById(recruiter.getTeamLeader().getTeamLeaderId()).get();
        List<JobDescription> forTeam=new ArrayList<>();
        if(visibility.equalsIgnoreCase("team")){
           forTeam =jobDescriptionRepo.findByVisibilityIgnoreCaseAndTeamLeaderId(visibility,teamLeader.getTeamLeaderId());
            return forTeam;
        } else if (visibility.equalsIgnoreCase("all")) {
            List<JobDescription> forTeamAndAll=new ArrayList<>();
//            forTeamAndAll.addAll(jobsWhereVisibityIsAll());
            List<JobDescription> allJobs=jobDescriptionRepo.findAll();
            for(JobDescription jd:allJobs){
                if(jd.getVisibility().equalsIgnoreCase("all")){
                    forTeamAndAll.add(jd);
                }
            }
           forTeam=jobDescriptionRepo.findByVisibilityIgnoreCaseAndTeamLeaderId("team",teamLeader.getTeamLeaderId());
            forTeamAndAll.addAll(forTeam);
            return forTeamAndAll;
        }
        return null;

    }
}
