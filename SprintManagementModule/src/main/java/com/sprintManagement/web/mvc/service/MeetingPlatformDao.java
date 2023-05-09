package com.sprintManagement.web.mvc.service;

import java.util.List;

import com.sprintManagement.web.mvc.dto.MeetingPlatformsDto;

public interface MeetingPlatformDao {

	List<MeetingPlatformsDto> getAllMeetingPlatforms();
}
