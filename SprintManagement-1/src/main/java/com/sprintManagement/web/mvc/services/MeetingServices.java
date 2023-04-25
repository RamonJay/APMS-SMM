package com.sprintManagement.web.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintManagement.web.mvc.dao.MeetingDao;
import com.sprintManagement.web.mvc.entities.Meetings;
import com.sprintManagement.web.mvc.repository.MeetingsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MeetingServices implements MeetingDao{
	
	@Autowired
	private MeetingsRepository meetingRepository;
	
	

	@Override
	public Meetings scheduleNewMeeting(Meetings meeting) {
		// TODO Auto-generated method stub
		return meetingRepository.save(meeting);
	}

	@Override
	public Meetings getMeetingById(Long id) {
		// TODO Auto-generated method stub
		Optional<Meetings> opt=meetingRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new EntityNotFoundException("Meeting not found with Id " + id);
		}
	}

	@Override
	public Meetings rescheduleMeeting(Meetings meeting, Long id) {
		// TODO Auto-generated method stub
		Optional<Meetings> meet=meetingRepository.findById(id);
		if(meet.isEmpty()) {
			throw new EntityNotFoundException("Meeting not found with Id " + id);
		}else {
			meeting.setId(id);
			meetingRepository.save(meeting);
			return meeting;
		}
	}

	@Override
	public List<Meetings> getAllMeetings() {
		// TODO Auto-generated method stub
		return meetingRepository.findAll();
	}
	

}
