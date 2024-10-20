/*
  Name:Shivam Gawande
  Task Assign Date Date:27-09-24
  Task Completion Date:01-10-24
  Creating filter JD using Team and all
 */
package com.login.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requirement_seq_generator")
    @SequenceGenerator(name = "requirement_seq_generator", sequenceName = "requirement_seq", allocationSize = 1)
    @Column(name = "requirement_id")
    private int requirementId;

    @Column(columnDefinition = "TEXT",length = 65535)
    private String companyName;

    @Column(columnDefinition = "TEXT",length = 65535)
    private String designation;

    @Column(columnDefinition = "TEXT",length = 65535)
    private int position;

    @Column(columnDefinition = "TEXT",length = 65535)
    private String qualification;

    @Column(columnDefinition = "TEXT",length = 65535)
    private String year_of_passing;

    @Column(columnDefinition = "TEXT",length = 65535)
    private String field;

//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String stream;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String location;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String salary;
//    @Column(columnDefinition = "TEXT",length = 65535,name = "job_type")
//    private String jobType;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String experience;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String bond;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String percentage;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String skills;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String companyLink;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String detailAddress;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String shift;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String weekOff;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String noticePeriod;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String jobRole;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String perks;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private double incentive;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String reportingHierarchy;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String gender;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String documentation;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String ageCriteria;
//
//    @Column(columnDefinition = "TEXT",length = 65535)
//    private String note;
//
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "positionOverviewId", referencedColumnName = "positionOverviewId")
//    private PositionOverview positionOverview;
//
//    @OneToMany(mappedBy = "requirementInfo", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Responsibilities> responsibilities;
//
//    @OneToMany(mappedBy = "requirementInfo", cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<JobRequirements> jobRequirements;
//
//    @OneToMany(mappedBy = "requirementInfo", cascade = CascadeType.ALL,orphanRemoval = true )
//    private List<PreferredQualifications> preferredQualifications;

    // Field to control visibility (either "team" or "all")
    @Column(name = "visibility")
    private String visibility;  // Values: "team" or "all"

    private Integer teamLeaderId;


}