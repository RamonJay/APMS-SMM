package com.sprintManagement.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprintManagement.web.mvc.entities.Meetings;
import com.sprintManagement.web.mvc.services.MeetingServices;

@RestController
public class MeetingController {
	
	@Autowired
	private MeetingServices meetingService;
	
	@GetMapping("/meetings")
	public List<Meetings> getAllMeetings(){
		return meetingService.getAllMeetings();
	}
	
	@PostMapping(value="/meeting",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Meetings addNewMeeting(@RequestBody Meetings meetings) {
		return meetingService.scheduleNewMeeting(meetings);
	}
	
}
