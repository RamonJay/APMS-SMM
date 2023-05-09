package com.sprintManagement.web.mvc.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sprintManagement.web.mvc.entities.Meetings;
import com.sprintManagement.web.mvc.exceptions.BadRequestException;
import com.sprintManagement.web.mvc.exceptions.MeetingStatusUpdateFailedException;

public interface MeetingDao {
	List<Meetings> getAllMeetings();
	Meetings scheduleNewMeeting(Meetings meeting);
	ResponseEntity<Meetings> getMeetingById(Long id);
	ResponseEntity<String> rescheduleMeeting(Meetings meeting,Long id) throws MeetingStatusUpdateFailedException;
	ResponseEntity<String> addNewMeeting(Meetings meeting) throws BadRequestException;
}
