package com.sprintManagement.web.mvc.service;

import java.util.List;

import com.sprintManagement.web.mvc.entities.Meetings;

public interface MeetingDao {
	List<Meetings> getAllMeetings();
	Meetings scheduleNewMeeting(Meetings meeting);
	Meetings getMeetingById(Long id);
	Meetings rescheduleMeeting(Meetings meeting,Long id);
}
