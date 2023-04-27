package com.sprintManagement.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintManagement.web.mvc.entities.Meetings;
import com.sprintManagement.web.mvc.service.MeetingDao;

@RestController
@RequestMapping("/api/")
public class MeetingController {
	
	@Autowired
	private MeetingDao meetingService;
	
	@GetMapping("meetings")
	public List<Meetings> getAllMeetings(){
		return meetingService.getAllMeetings();
	}
	
	@PostMapping(value="/meeting/new",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Meetings addNewMeeting(@RequestBody Meetings meetings) {
		return meetingService.scheduleNewMeeting(meetings);
	}
	
	@PutMapping("/meeting/{id}/reschedule")
	public Meetings resceduleMeeting(@RequestBody Meetings meeting,@PathVariable("id")Long id) {
		Meetings meet=meetingService.rescheduleMeeting(meeting, id);
		return meet;
	}
	
}
