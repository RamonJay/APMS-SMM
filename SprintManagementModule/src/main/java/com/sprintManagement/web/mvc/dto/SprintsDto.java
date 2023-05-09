package com.sprintManagement.web.mvc.dto;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;

import jakarta.validation.constraints.AssertTrue;
import lombok.Data;

@Data
public class SprintsDto {
	private Long sprintId;
	private String sprintName = "Sprint-";
	private LocalDate startDate;
	private LocalDate endDate;
	private Long projectCode;
	@CreatedDate
	private LocalDate createdOn;
	
	@AssertTrue(message = "End date must be after start date")
    public boolean isValid() {
        return endDate.isAfter(startDate);
    }

	public SprintsDto() {
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

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
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

	@Override
	public String toString() {
		return "SprintsDto [sprintid=" + sprintId + ", sprintname=" + sprintName + ", startdate=" + startDate
				+ ", enddate=" + endDate + ", projectcode=" + projectCode + ", createdon=" + createdOn + "]";
	}

}
