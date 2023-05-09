package com.sprintManagement.web.mvc.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Meetings {
	// Creating primary key using @Id annotation
	@Id
	@Column(name = "Id", columnDefinition = "INTEGER(10)")
//	@SequenceGenerator(name="meetSeq",initialValue=6000,allocationSize=1,sequenceName="Meet_Seq")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Meet_Seq")
	private Long id;
	@Column(name = "meetinglink", columnDefinition = "VARCHAR(200)")
	private String meetingLink;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "meetingdate", columnDefinition = "DATE")
	private LocalDate meetingDate;
	@Column(name = "meetingtime", columnDefinition = "TIME(6)")
	private LocalTime meetingTime;

	// Adding constraints for check meeting type should be in
	// ['DailyScrum','SprintPlanning','SprintReview','SprintRetrospective']
	@Column(name = "meetingtype", columnDefinition = "VARCHAR(20)")
	@Enumerated(EnumType.STRING)
	private MeetingType meetingType;

	// Creating a join column for add foreign key with Sprint table's primary key
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Sprintid", columnDefinition = "INTEGER(10)")
	private Sprints sprint;

	@Column(name = "meetingpassword", columnDefinition = "VARCHAR(8)")
	private String meetingPassword;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "createdon", columnDefinition = "DATE")
	@CreatedDate
	private LocalDate createdOn;

	// Adding constraints for check meeting status in
	// ['scheduled','closed','completed','rescheduled']
	@Column(name = "status", columnDefinition = "VARCHAR(20)")
	@Enumerated(EnumType.STRING)
	private MeetingStatus status;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "updatedon", columnDefinition = "DATE", nullable = true)
	private LocalDate updatedOn;

	// Creating a join column for add foreign key with Meeting platforms table's
	// pimary key
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Meetingplatformmid")
	private MeetingPlatforms meetingPlatform;

	public MeetingPlatforms getMeetingPlatform() {
		return meetingPlatform;
	}

	public void setMeetingPlatform(MeetingPlatforms meetingPlatform) {
		this.meetingPlatform = meetingPlatform;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMeetinglink() {
		return meetingLink;
	}

	public void setMeetinglink(String meetingLink) {
		this.meetingLink = meetingLink;
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

	public Sprints getSprint() {
		return sprint;
	}

	public void setSprint(Sprints sprint) {
		this.sprint = sprint;
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

	public LocalDate getUpdatedon() {
		return updatedOn;
	}

	public void setUpdatedon(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Meetings(Long id, String meetingLink, LocalDate meetingDate, LocalTime meetingTime, MeetingType meetingType,
			Sprints sprints, String meetingPassword, LocalDate createdOn, MeetingStatus status, LocalDate updatedOn) {
		super();
		this.id = id;
		this.meetingLink = meetingLink;
		this.meetingDate = meetingDate;
		this.meetingTime = meetingTime;
		this.meetingType = meetingType;
		this.sprint = sprints;
		this.meetingPassword = meetingPassword;
		this.createdOn = createdOn;
		this.status = status;
		this.updatedOn = updatedOn;
	}

	public Meetings() {
		super();
		this.createdOn = LocalDate.now();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Meetings [Id=" + id + ", Meetinglink=" + meetingLink + ", Meetingdate=" + meetingDate + ", Meetingtime="
				+ meetingTime + ", Meetingtype=" + meetingType + ", Sprintid=" + sprint + ", Meetingpassword="
				+ meetingPassword + ", Createdon=" + createdOn + ", Status=" + status + ", Updatedon=" + updatedOn
				+ "]";
	}

}
