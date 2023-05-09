package com.sprintManagement.web.mvc.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;

@Entity
public class Sprints {

	// Creating a primary key using @id annotation
	@Id
	@Column(name = "sprintid", columnDefinition = "INTEGER(10)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name="accSeq",initialValue=6000,allocationSize=1,sequenceName="Acc_Seq")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="accSeq")
	private Long sprintId;

//	@OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
//	@JsonBackReference
//	private List<Meetings> meetings = new ArrayList<>();

	@Column(name = "sprintname", columnDefinition = "VARCHAR(18)")
	private String sprintName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "startdate", columnDefinition = "DATE")
	private LocalDate startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "enddate", columnDefinition = "DATE")
	private LocalDate endDate;
	@Column(name = "projectcode", columnDefinition = "INTEGER(10)")
	private Long projectCode;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "createdon", columnDefinition = "DATE", nullable = false, updatable = false)
	// Adding constraints to store todays date
	@CreatedDate
	private LocalDate createdOn;
	
	@AssertTrue(message = "End date must be after start date")
    public boolean isValid() {
        return endDate.isAfter(startDate);
    }

	public Sprints() {
		this.createdOn = LocalDate.now();
	}

	public Long getSprintId() {
		return sprintId;
	}

	public void setSprintId(Long sprintId) {
		this.sprintId = sprintId;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartdate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEnddate() {
		return endDate;
	}

	public void setEnddate(LocalDate enddate) {
		this.endDate = enddate;
	}

	public Long getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(Long projectCode) {
		this.projectCode = projectCode;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public Sprints(Long sprintId, String sprintName, LocalDate startDate, LocalDate endDate, Long projectCode,
			LocalDate createdOn) {
		super();
		this.sprintId = sprintId;
		this.sprintName = sprintName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectCode = projectCode;
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Sprints [sprintid=" + sprintId + ", sprintname=" + sprintName + ", startdate=" + startDate
				+ ", enddate=" + endDate + ", projectcode=" + projectCode + ", createdon=" + createdOn + "]";
	}

//	public List<Meetings> getMeetings() {
//		return meetings;
//	}
//
//	public void setMeetings(List<Meetings> meetings) {
//		this.meetings = meetings;
//	}

}
