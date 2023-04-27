package com.sprintManagement.web.mvc.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.sprintManagement.web.mvc.entities.MeetingPlatforms;
import com.sprintManagement.web.mvc.entities.MeetingStatus;
import com.sprintManagement.web.mvc.entities.MeetingType;
import com.sprintManagement.web.mvc.entities.Sprints;

public class MeetingsDto {
	private Long Id;
	private String Meetinglink;
	private LocalDate meetingdate;
	private LocalTime meetingtime;
	private MeetingType meetingtype;
	private Sprints sprintid;
	private String Meetingpassword;
	private LocalDate Createdon;
	private MeetingStatus status;
	private LocalDate Updatedon;
	private MeetingPlatforms meetingplatformid;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getMeetinglink() {
		return Meetinglink;
	}
	public void setMeetinglink(String meetinglink) {
		Meetinglink = meetinglink;
	}
	public LocalDate getMeetingdate() {
		return meetingdate;
	}
	public void setMeetingdate(LocalDate meetingdate) {
		this.meetingdate = meetingdate;
	}
	public LocalTime getMeetingtime() {
		return meetingtime;
	}
	public void setMeetingtime(LocalTime meetingtime) {
		this.meetingtime = meetingtime;
	}
	public MeetingType getMeetingtype() {
		return meetingtype;
	}
	public void setMeetingtype(MeetingType meetingtype) {
		this.meetingtype = meetingtype;
	}
	public Sprints getSprintid() {
		return sprintid;
	}
	public void setSprintid(Sprints sprintid) {
		this.sprintid = sprintid;
	}
	public String getMeetingpassword() {
		return Meetingpassword;
	}
	public void setMeetingpassword(String meetingpassword) {
		Meetingpassword = meetingpassword;
	}
	public LocalDate getCreatedon() {
		return Createdon;
	}
	public void setCreatedon(LocalDate createdon) {
		Createdon = createdon;
	}
	public MeetingStatus getStatus() {
		return status;
	}
	public void setStatus(MeetingStatus status) {
		this.status = status;
	}
	public LocalDate getUpdatedon() {
		return Updatedon;
	}
	public void setUpdatedon(LocalDate updatedon) {
		Updatedon = updatedon;
	}
	public MeetingPlatforms getMeetingplatformid() {
		return meetingplatformid;
	}
	public void setMeetingplatformid(MeetingPlatforms meetingplatformid) {
		this.meetingplatformid = meetingplatformid;
	}
		
	
}
