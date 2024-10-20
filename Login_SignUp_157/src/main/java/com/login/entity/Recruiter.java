/*
  Name:Shivam Gawande
  Task Assign Date Date:27-09-24
  Task Completion Date:01-10-24
  Creating filter JD using Team and all
 */
package com.login.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "recruiter", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_name")
})
public class Recruiter  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_generator")
    @SequenceGenerator(name = "employee_seq_generator", sequenceName = "employee_seq", allocationSize = 1)
    @Column( name = "emp_id")
    private int employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

//    @Column(name = "date_of_joining")
//    private String dateOfJoining;

    @Column(name = "designation")
    private String designation;

    @Column(name = "department")
    private String department;

    @Column(name = "official_mail")
    private String officialMail;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "official_contact_no")
    private long officialContactNumber;

//    @Column(name = "alternate_contact_no")
//    private long alternateContactNo;

//    @Column(name = "date_of_birth")
//    private String dateOfBirth;

    @Column(name = "gender")
    private String gender;

//    @Column(name = "company_mobile_number")
//    private long companyMobileNumber;
//
//    @Column(name = "whats_app_number")
//    private long whatsAppNumber;
//
//    @Column(name = "emergency_contact_person")
//    private String emergencyContactPerson;
//
//    @Column(name = "emergency_contact_number")
//    private long emergencyContactNumber;
//
//    @Column(name = "emergency_person_relation")
//    private String emergencyPersonRelation;
//
//    @Column(name = "employee_present_address")
//    private String employeePresentAddress;
//
//    @Column(name = "employee_experience")
//    private String employeeExperience;
//
//    @Column(name = "perks")
//    private String perks;
//
//    @Column(name = "marital_status")
//    private String maritalStatus;
//
//    @Column(name = "anniversary_date")
//    private String anniversaryDate;
//
//    @Column(name = "t_shirt_size")
//    private String tshirtSize;
//
//    @Column(name = "last_company")
//    private String lastCompany;
//
//    @Column(name = "work_location")
//    private String workLocation;
//
//    @Column(name = "entry_source")
//    private String entrySource;
//
//    @Column(name = "employee_status")
//    private String employeeStatus;
//
//    @Column(name = "last_working_date")
//    private String lastWorkingDate;
//
//    @Column(name = "reason_for_leaving")
//    private String reasonForLeaving;
//
//    @Column(name = "induction_yes_or_no")
//    private String inductionYesOrNo;
//
//    @Column(name = "induction_comment")
//    private String inductionComment;
//
//    @Column(name = "training_source")
//    private String trainingSource;
//
//    @Column(name = "training_completed_yes_or_no")
//    private String trainingCompletedYesOrNo;
//
//    @Column(name = "training_taken_count")
//    private int trainingTakenCount;
//
//    @Column(name = "rounds_of_interview")
//    private String roundsOfInterview;
//
//    @Column(name = "interview_taken_person")
//    private String interviewTakenPerson;
//
//    @Column(name = "warning_comments")
//    private String warningComments;
//
//    @Column(name = "performance_indicator")
//    private String performanceIndicator;
//
//    @Column(name = "team_leader_msg")
//    private String teamLeaderMsg;
//
//    @Column(name = "edit_delete_authority")
//    private String editDeleteAuthority;
//
//    @Column(name = "linked_inurl")
//    private String linkedInURl;
//
//    @Column(name = "face_bookurl")
//    private String faceBookURL;
//
//    @Column(name = "twitterurl")
//    private String twitterURl;
//
//    @Column(name = "employee_address")
//    private String employeeAddress;
//
//    @Column(name = "blood_group")
//    private String bloodGroup;
//
//    @Column(name = "aadhaar_no")
//    private long aadhaarNo;
//
//    @Column(name = "pan_no")
//    private String panNo;
//
//    @Column(name = "educational_qualification")
//    private String educationalQualification;
//
//    @Column(name = "offered_salary")
//    private double offeredSalary;
//
//    @Column(name = "job_role")
//    private String jobRole;
//
//    @Column(name = "professional_pt_no")
//    private long professionalPtNo;
//
//    @Column(name = "es_ic_no")
//    private long esIcNo;
//
//    @Column(name = "pf_no")
//    private long pfNo;
//
//    private long insuranceNumber;
//    private String reportingMangerName;
//    private String reportingMangerDesignation;
//
//    @Column(name = "employee_password")
//    private String employeePassword;
//    @Column(name = "confirm_password")
//    private String confirmPassword;
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
//    private int oldTeamLeaderId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "req_reference")
//    private Requirement_Info requirementInfo;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "team_leader_id", nullable = false)
//    private TeamLeader teamLeader;
//
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<EmployeeColumnAssignment> columnAssignments = new HashSet<>();
//
//    public Employee(int empId) {
//        this.employeeId = empId;
//    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_leader_id", nullable = false)
    @JsonBackReference // Prevents infinite recursion in bidirectional relationship
    private TeamLeader teamLeader;

}
