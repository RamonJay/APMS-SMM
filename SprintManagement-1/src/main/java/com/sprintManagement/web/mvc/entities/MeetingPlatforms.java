package com.sprintManagement.web.mvc.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Meetingplatform")
public class MeetingPlatforms {
	@Id
	@Column(name = "Id", columnDefinition = "INTEGER(10)")
	private Long id;
	@Column(name = "name", columnDefinition = "VARCHAR(50)")
	private String name;
	@OneToMany(mappedBy = "meetingPlatform", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonBackReference
	private List<Meetings> meetings = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Meetings> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meetings> meetings) {
		this.meetings = meetings;
	}

	public MeetingPlatforms(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public MeetingPlatforms() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MeetingPlatform [id=" + id + ", name=" + name + "]";
	}

}
