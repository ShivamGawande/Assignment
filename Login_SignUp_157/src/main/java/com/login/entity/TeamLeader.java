/*
  Name:Shivam Gawande
  Task Assign Date Date:27-09-24
  Task Completion Date:01-10-24
  Creating filter JD using Team and all
 */
package com.login.entity;



import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_leader", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_name")})
public class TeamLeader {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq_generator")
    @SequenceGenerator(name = "team_seq_generator", allocationSize = 543,initialValue = 432)
    @Column(name = "team_leader_id")
    private int teamLeaderId;

    @Column(name = "team_leader_name")
    private String teamLeaderName;

    @Column(name = "user_name")
    private String userName;

//    private String tlDateOfJoining;
//    private String tlDesignation;
    private String tlDepartment;
    private String tlOfficialMail;
    private String tlPersonalEmailId;
    @Column(name = "tl_official_contact_no")
    private long tlOfficialContactNo;

//    @Column(name = "tl_alternate_contact_no")
//    private long tlAlternateContactNo;
//
//    private String tlDateOfBirth;
    private String tlGender;
//    private String jobLevel;
//    @Column(name = "tl_company_mobile_no")
//    private long tlCompanyMobileNo;
//    @Column(name = "tl_whats_app_no")
//    private long tlWhatsAppNo;
//    private String tlEmergencyContactPerson;
//    @Column(name = "tl_emergency_contact_no")
//    private long tlEmergencyContactNo;
//
//    private String tlEmergencyPersonRelation;
//    private String tlPresentAddress;
//    private String tlExperience;
//    private String tlPerks;
//    private String tlMaritalStatus;
//    private String tlAnniversaryDate;
//    private String tlTShirtSize;
//    private String tlLastCompany;
//    private String tlWorkLocation;
//    private String tlEntrySource;
//    private String teamLeaderStatus;
//    private String lastWorkingDate;
//    private String tlReasonForLeaving;
//    private String tlInductionYesOrNo;
//    private String tlInductionComment;
//    private String tlTrainingSource;
//    private String tlTrainingCompleted;
//    private int tlTrainingTakenCount;
//    private String tlRoundsOfInterview;
//    private String tlInterviewTakenPerson;
//    private String tlWarningComments;
//    private String tlPerformanceIndicator;
//    private String messageForAdmin;
//    private String editDeleteAuthority;
//    private String linkedInURL;
//    private String faceBookURL;
//    private String twitterURL;
//    private String tlAddress;
//    private String bloodGroup;
//    private long tlAadhaarNo;
//    private String tlPanNo;
//    private String tlQualification;
//    private double tlSalary;
//    private long professionalPtNo;
//    private long esIcNo;
//    private long pfNo;
//
//    private long tlInsuranceNumber;
//    private String reportingAdminName;
//    private String reportingAdminDesignation;
//    private String tlPassword;
//    private String tlConfirmPassword;
//
//    @Lob
//    @Column(columnDefinition = "LONGBLOB",name = "profile_image")
//    private byte[] profileImage;
//
//    @Lob
//    @Column(columnDefinition = "LONGBLOB",name = "document")
//    private byte[] document;
//
//    @Lob
//    @Column(columnDefinition = "LONGBLOB",name = "resume_file")
//    private byte[] resumeFile;
//
//    private int oldMangerId;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "manager_id", nullable = false)
//    private Manager manager;
//
//    @OneToMany(mappedBy = "teamLeader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Employee> employees;
//
//    @OneToMany(mappedBy = "teamLeader")
//    private Set<EmployeeColumnAssignment> columnAssignments = new HashSet<>();
//
//    public TeamLeader(int teamLeaderId, String teamLeaderName) {
//        this.teamLeaderId = teamLeaderId;
//        this.teamLeaderName = teamLeaderName;
//    }
//
//    public TeamLeader(int teamLeaderId) {
//    }
    @OneToMany(mappedBy = "teamLeader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Recruiter> recruiters;
}
