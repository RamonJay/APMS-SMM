package com.sprintManagement.web.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintManagement.web.mvc.dao.MeetingPlatformDao;
import com.sprintManagement.web.mvc.entities.MeetingPlatforms;
import com.sprintManagement.web.mvc.repository.MeetingPlatformRepository;

@Service
public class MeetingPlatformServices implements MeetingPlatformDao{

	@Autowired
	private MeetingPlatformRepository meetingPlatformRepository;
	@Override
	public List<MeetingPlatforms> getAllMeetingPlatforms() {
		// TODO Auto-generated method stub
		return meetingPlatformRepository.findAll();
	}

}
