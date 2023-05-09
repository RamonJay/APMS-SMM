package com.sprintManagement.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintManagement.web.mvc.dto.MeetingPlatformsDto;
import com.sprintManagement.web.mvc.service.MeetingPlatformDao;

@RestController
@RequestMapping("/api/meetings/")
public class MeetingPlatformController {

	@Autowired
	private MeetingPlatformDao meetingPlatformServices;

	// Control to get List of all Meeting platforms
	@GetMapping("platforms")
	public List<MeetingPlatformsDto> getAllMeetingPlatforms() {
		return meetingPlatformServices.getAllMeetingPlatforms();
	}
}
