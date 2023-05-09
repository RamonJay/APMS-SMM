package com.sprintManagement.web.mvc.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprintManagement.web.mvc.entities.MeetingStatus;
import com.sprintManagement.web.mvc.entities.Meetings;
import com.sprintManagement.web.mvc.exceptions.BadRequestException;
import com.sprintManagement.web.mvc.exceptions.MeetingStatusUpdateFailedException;
import com.sprintManagement.web.mvc.repository.MeetingsRepository;
import com.sprintManagement.web.mvc.service.MeetingDao;

@Service
public class MeetingServices implements MeetingDao {

	@Autowired
	private MeetingsRepository meetingRepository;

	@Override
	public Meetings scheduleNewMeeting(Meetings meeting) {
		// TODO Auto-generated method stub
		return meetingRepository.save(meeting);
	}

	@Override
	public ResponseEntity<Meetings> getMeetingById(Long id) {
		// TODO Auto-generated method stub
		Optional<Meetings> opt = meetingRepository.findById(id);
		if (opt.isPresent()) {
			return ResponseEntity.of(Optional.of(opt.get()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Override
	public ResponseEntity<String> rescheduleMeeting(Meetings meeting, Long id) {
		// TODO Auto-generated method stub
		Optional<Meetings> meet = meetingRepository.findById(id);
		if (meet.isEmpty()) {
			return new ResponseEntity<String>("Meeting not found with Id :" + id, HttpStatus.NOT_FOUND);
		} else {
			Meetings m = meet.get();
			if (m.getStatus() == MeetingStatus.completed) {
				throw new MeetingStatusUpdateFailedException("Error! Completed meeting cannot be reschedule");
			}
			meeting.setId(id);
			meeting.setUpdatedon(LocalDate.now());
			meetingRepository.save(meeting);
			return new ResponseEntity<String>("Meeting rescheduled successfully", HttpStatus.OK);
		}
	}

	@Override
	public List<Meetings> getAllMeetings() {
		// TODO Auto-generated method stub
		return meetingRepository.findAll();
	}

	@Override
	public ResponseEntity<String> addNewMeeting(Meetings meeting) throws BadRequestException {
		Optional<Meetings> meetings = meetingRepository.findById(meeting.getId());
		if (!meetings.isEmpty()) {
			throw new BadRequestException("Meeting with this ID already Present");
		}
		switch (meeting.getMeetingType()) {
		case DailyScrum:
			LocalDate firstDate = meeting.getCreatedOn();
			LocalDate endDate = meeting.getSprint().getEnddate();
			long meetingid = meeting.getId();
			while (firstDate.isBefore(endDate)) {
				Meetings dailyMeeting = new Meetings();
				dailyMeeting = meeting;
				dailyMeeting.setId(meetingid++);
				dailyMeeting.setMeetingDate(firstDate);
				meetingRepository.save(dailyMeeting);
				firstDate = firstDate.plusDays(1);
			}
			return new ResponseEntity<String>("DailyScrum meeting is added successfully", HttpStatus.OK);
		case SprintPlanning:
			LocalDate meetingdate = meeting.getSprint().getStartDate();
			meeting.setMeetingDate(meetingdate);
			meetingRepository.save(meeting);
			return new ResponseEntity<>("Sprint Planning meeting scheduled successfully", HttpStatus.OK);
		case SprintReview:
			LocalDate meetingDate = meeting.getSprint().getEnddate();
			meeting.setMeetingDate(meetingDate);
			meetingRepository.save(meeting);
			return new ResponseEntity<>("SprintReview meeting is scheduled successfully", HttpStatus.OK);
		case SprintRetrospective:
			LocalDate meetingDa = meeting.getSprint().getEnddate();
			meeting.setMeetingDate(meetingDa);
			meetingRepository.save(meeting);
			return new ResponseEntity<>("SprintRetrospective meeting is scheduled successfully", HttpStatus.OK);
		default:
			return new ResponseEntity<>(
					"Meeting Type should be DailyScrum/SprintPlanning/SprintReview/SprintRetrospective",
					HttpStatus.EXPECTATION_FAILED);
		}

	}

}