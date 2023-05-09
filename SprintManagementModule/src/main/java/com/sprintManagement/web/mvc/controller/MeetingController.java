package com.sprintManagement.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintManagement.web.mvc.entities.Meetings;
import com.sprintManagement.web.mvc.exceptions.BadRequestException;
import com.sprintManagement.web.mvc.service.MeetingDao;

@RestController
@RequestMapping("/api/")
public class MeetingController {

	@Autowired
	private MeetingDao meetingService;

	// Control to get List of all meetings
	@GetMapping("meetings")
	public List<Meetings> getAllMeetings() {
		return meetingService.getAllMeetings();
	}

	// Control to get reschedule a meeting
	@PutMapping("/meeting/{id}/reschedule")
	public ResponseEntity<String> resceduleMeeting(@RequestBody Meetings meeting, @PathVariable("id") Long id) {
		return meetingService.rescheduleMeeting(meeting, id);
	}

	// Control to get Meeting by Id
	@GetMapping("/meeting/{id}")
	public ResponseEntity<Meetings> getMeetingById(@PathVariable("id") Long id) {
		return meetingService.getMeetingById(id);
	}

	// Control to create a new meeting
	@PostMapping("/meeting/new")
	public ResponseEntity<String> scheduleMeeting(@RequestBody Meetings meeting) throws BadRequestException {
		return meetingService.addNewMeeting(meeting);
	}

}