package com.sprintManagement.web.mvc.dto;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
public class SprintsDto {
	private Long sprintid;
	private String sprintname="Sprint-";
	private LocalDate startdate;
	private LocalDate enddate;
	private Long projectcode;
	@CreatedDate
	private LocalDate createdon;
	
	public SprintsDto() {
		this.createdon = LocalDate.now();
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
	public void setProjectCode(Long projectcode) {
		this.projectcode = projectcode;
	}
	public LocalDate getCreatedon() {
		return createdon;
	}
	public void setCreatedon(LocalDate createdon) {
		this.createdon = createdon;
	}
	
	
	

}
