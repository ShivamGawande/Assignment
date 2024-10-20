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
import com.login.repo.RecruiterRepo;
import com.login.repo.TLeaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TLeaderServiceImpl implements  TLeaderService{

    @Autowired
    private TLeaderRepo teamLeaderRepository;

    @Autowired
    private RecruiterRepo recruiterRepository;

    @Override
    public TeamLeaderDTO createTeamLeader(TeamLeaderDTO teamLeaderDTO) {
        // Map DTO to TeamLeader entity
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setTeamLeaderName(teamLeaderDTO.getTeamLeaderName());
        teamLeader.setUserName(teamLeaderDTO.getUserName());
        teamLeader.setTlDepartment(teamLeaderDTO.getTlDepartment());
        teamLeader.setTlOfficialMail(teamLeaderDTO.getTlOfficialMail());
        teamLeader.setTlPersonalEmailId(teamLeaderDTO.getTlPersonalEmailId());
        teamLeader.setTlOfficialContactNo(teamLeaderDTO.getTlOfficialContactNo());
        teamLeader.setTlGender(teamLeaderDTO.getTlGender());

        // Map the list of RecruiterDTO to Recruiter entities
        Set<Recruiter> recruiters = teamLeaderDTO.getRecruiters().stream().map(recruiterDTO -> {
            Recruiter recruiter = new Recruiter();
            recruiter.setEmployeeName(recruiterDTO.getEmployeeName());
            recruiter.setUserName(recruiterDTO.getUserName());
            recruiter.setDesignation(recruiterDTO.getDesignation());
            recruiter.setDepartment(recruiterDTO.getDepartment());
            recruiter.setOfficialMail(recruiterDTO.getOfficialMail());
            recruiter.setEmployeeEmail(recruiterDTO.getEmployeeEmail());
            recruiter.setOfficialContactNumber(recruiterDTO.getOfficialContactNumber());
            recruiter.setGender(recruiterDTO.getGender());
            recruiter.setTeamLeader(teamLeader); // Set the team leader for each recruiter
            return recruiter;
        }).collect(Collectors.toSet());

        // Save the team leader and recruiters
        teamLeader.setRecruiters(recruiters);
        TeamLeader savedTeamLeader = teamLeaderRepository.save(teamLeader);
        recruiterRepository.saveAll(recruiters); // Save recruiters separately

        // Return the saved DTO
        teamLeaderDTO.setTeamLeaderId(savedTeamLeader.getTeamLeaderId());
        return teamLeaderDTO;
    }


    public Set<Recruiter> getRecruiter(Integer id){

        return  teamLeaderRepository.findById(id).get().getRecruiters();
    }

    public TeamLeader findById(Integer id){
        return teamLeaderRepository.findById(id).get();
    }
}
