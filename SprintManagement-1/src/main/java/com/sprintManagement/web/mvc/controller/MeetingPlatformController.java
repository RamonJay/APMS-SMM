package com.sprintManagement.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintManagement.web.mvc.entities.MeetingPlatforms;
import com.sprintManagement.web.mvc.services.MeetingPlatformServices;

@RestController
public class MeetingPlatformController {

	@Autowired
	private MeetingPlatformServices meetingPlatformServices; 
	
	@GetMapping("/meetingplatforms")
	public List<MeetingPlatforms> getAllMeetingPlatforms(){
		return meetingPlatformServices.getAllMeetingPlatforms();
	}
}
