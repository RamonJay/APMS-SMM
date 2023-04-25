package com.sprintManagement.web.mvc.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Meetings {
	@Id
	@Column(name = "Id", columnDefinition = "INTEGER(10)")
	private Long Id;
	@Column(name = "meetinglink", columnDefinition = "VARCHAR(200)")
	private String Meetinglink;
	@Column(name = "meetingdate", columnDefinition = "DATE")
	private LocalDate Meetingdate;
	@Column(name = "meetingtime", columnDefinition = "TIME(6)")
	private LocalTime Meetingtime;
	
	@Column(name = "meetingtype", columnDefinition = "VARCHAR(20)")
	@Enumerated(EnumType.STRING)
	private MeetingType Meetingtype;

	@ManyToOne
	@JoinColumn(name = "Sprintid", columnDefinition = "INTEGER(10)")
	@JsonManagedReference
	private Sprints sprint;

	@Column(name = "meetingpassword", columnDefinition = "VARCHAR(8)")
	private String Meetingpassword;
	@Column(name = "createdon", columnDefinition = "DATE")
	private LocalDate Createdon;
	
	@Column(name = "status", columnDefinition = "VARCHAR(20)")
	@Enumerated(EnumType.STRING)
	private MeetingStatus Status;
	@Column(name = "updatedon", columnDefinition = "DATE",nullable=true)
	private LocalDate Updatedon;

	@ManyToOne
	@JoinColumn(name = "Meetingplatformmid")
	@JsonManagedReference
	private MeetingPlatforms meetingPlatform;

	public MeetingPlatforms getMeetingPlatform() {
		return meetingPlatform;
	}

	public void setMeetingPlatform(MeetingPlatforms meetingPlatform) {
		this.meetingPlatform = meetingPlatform;
	}

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
		return Meetingdate;
	}

	public void setMeetingdate(LocalDate meetingdate) {
		Meetingdate = meetingdate;
	}

	public LocalTime getMeetingtime() {
		return Meetingtime;
	}

	public void setMeetingtime(LocalTime meetingtime) {
		Meetingtime = meetingtime;
	}

	public MeetingType getMeetingtype() {
		return Meetingtype;
	}

	public void setMeetingtype(MeetingType string) {
		Meetingtype = string;
	}

	public Sprints getSprint() {
		return sprint;
	}

	public void setSprint(Sprints sprint) {
		this.sprint = sprint;
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
		return Status;
	}

	public void setStatus(MeetingStatus status) {
		Status = status;
	}

	public LocalDate getUpdatedon() {
		return Updatedon;
	}

	public void setUpdatedon(LocalDate updatedon) {
		Updatedon = updatedon;
	}

	public Meetings(Long id, String meetinglink, LocalDate meetingdate, LocalTime meetingtime, MeetingType meetingtype,
			Sprints sprints, String meetingpassword, LocalDate createdon, MeetingStatus status, LocalDate updatedon) {
		super();
		Id = id;
		Meetinglink = meetinglink;
		Meetingdate = meetingdate;
		Meetingtime = meetingtime;
		Meetingtype = meetingtype;
		sprint = sprints;
		Meetingpassword = meetingpassword;
		Createdon = createdon;
		Status = status;
		Updatedon = updatedon;
	}

	public Meetings() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Meetings [Id=" + Id + ", Meetinglink=" + Meetinglink + ", Meetingdate=" + Meetingdate + ", Meetingtime="
				+ Meetingtime + ", Meetingtype=" + Meetingtype + ", Sprintid=" + sprint + ", Meetingpassword="
				+ Meetingpassword + ", Createdon=" + Createdon + ", Status=" + Status + ", Updatedon=" + Updatedon
				+ "]";
	}

}
