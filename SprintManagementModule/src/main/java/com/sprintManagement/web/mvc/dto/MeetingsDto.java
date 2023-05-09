package com.sprintManagement.web.mvc.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.sprintManagement.web.mvc.entities.MeetingPlatforms;
import com.sprintManagement.web.mvc.entities.MeetingStatus;
import com.sprintManagement.web.mvc.entities.MeetingType;

import lombok.Data;

@Data
public class MeetingsDto {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMeetingLink() {
		return MeetingLink;
	}

	public void setMeetingLink(String meetingLink) {
		MeetingLink = meetingLink;
	}

	public LocalDate getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(LocalDate meetingDate) {
		this.meetingDate = meetingDate;
	}

	public LocalTime getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(LocalTime meetingTime) {
		this.meetingTime = meetingTime;
	}

	public MeetingType getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(MeetingType meetingType) {
		this.meetingType = meetingType;
	}

	public SprintsDto getSprintId() {
		return sprintId;
	}

	public void setSprintId(SprintsDto sprintId) {
		this.sprintId = sprintId;
	}

	public String getMeetingPassword() {
		return meetingPassword;
	}

	public void setMeetingPassword(String meetingPassword) {
		this.meetingPassword = meetingPassword;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public MeetingStatus getStatus() {
		return status;
	}

	public void setStatus(MeetingStatus status) {
		this.status = status;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public MeetingPlatforms getMeetingPlatformId() {
		return meetingPlatformId;
	}

	public void setMeetingPlatformId(MeetingPlatforms meetingPlatformId) {
		this.meetingPlatformId = meetingPlatformId;
	}

	private Long id;
	private String MeetingLink;
	private LocalDate meetingDate;
	private LocalTime meetingTime;
	private MeetingType meetingType;
	private SprintsDto sprintId;
	private String meetingPassword;
	private LocalDate createdOn;
	private MeetingStatus status;
	private LocalDate updatedOn;
	private MeetingPlatforms meetingPlatformId;

}
