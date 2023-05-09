package com.sprintManagement.web.mvc.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintManagement.web.mvc.dto.MeetingPlatformsDto;
import com.sprintManagement.web.mvc.entities.MeetingPlatforms;
import com.sprintManagement.web.mvc.repository.MeetingPlatformRepository;
import com.sprintManagement.web.mvc.service.MeetingPlatformDao;

@Service
public class MeetingPlatformServices implements MeetingPlatformDao {

	@Autowired
	private MeetingPlatformRepository meetingPlatformRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<MeetingPlatformsDto> getAllMeetingPlatforms() {
		// TODO Auto-generated method stub
		return meetingPlatformRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	// To convert the Entity to DTO
	private MeetingPlatformsDto convertEntityToDto(MeetingPlatforms meetingPlatforms) {

		MeetingPlatformsDto meet = modelMapper.map(meetingPlatforms, MeetingPlatformsDto.class);
		return meet;
	}

}
