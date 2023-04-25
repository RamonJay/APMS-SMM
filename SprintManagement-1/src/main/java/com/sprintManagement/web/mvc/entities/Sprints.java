package com.sprintManagement.web.mvc.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sprints {

	@Id
	@Column(name = "sprintid", columnDefinition = "INTEGER(10)")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sprintid;
	
	@OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonBackReference
	private List<Meetings> meetings = new ArrayList<>();

	@Column(name = "sprintname", columnDefinition = "VARCHAR(18)")
	private String sprintname;
	@Column(name = "startdate", columnDefinition = "DATE")
	private LocalDate startdate;
	@Column(name = "enddate", columnDefinition = "DATE")
	private LocalDate enddate;
	@Column(name = "projectcode", columnDefinition = "INTEGER(10)")
	private Long projectcode;
	@CreatedDate
	@Column(name = "createdon", columnDefinition = "DATE", nullable = false, updatable = false)
	private LocalDate createdon;
	

	public List<Meetings> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meetings> meetings) {
		this.meetings = meetings;
	}

	public Long getSprintid() {
		return sprintid;
	}

	public void setSprintid(Long sprintid) {
		this.sprintid = sprintid;
	}

	public String getSprintname() {
		return sprintname;
	}

	public void setSprintname(String sprintname) {
		this.sprintname = sprintname;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

	public Long getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(Long projectcode) {
		this.projectcode = projectcode;
	}

	public LocalDate getCreatedon() {
		return createdon;
	}

	public void setCreatedon(LocalDate createdon) {
		this.createdon = createdon;
	}

	public Sprints(Long sprintid, String sprintname, LocalDate startdate, LocalDate enddate, Long projectcode, LocalDate createdon) {
		super();
		this.sprintid = sprintid;
		this.sprintname = sprintname;
		this.startdate = startdate;
		this.enddate = enddate;
		this.projectcode = projectcode;
		this.createdon = createdon;
	}

	public Sprints() {
		super();
		this.createdon=LocalDate.now();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Sprints [sprintid=" + sprintid + ", sprintname=" + sprintname + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", projectcode=" + projectcode + ", createdon=" + createdon + "]";
	}

}
