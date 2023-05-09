package com.sprintManagement.web.mvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sprintManagement.web.mvc.dto.MeetingPlatformsDto;
import com.sprintManagement.web.mvc.dto.SprintsDto;
import com.sprintManagement.web.mvc.entities.MeetingPlatforms;
import com.sprintManagement.web.mvc.entities.MeetingType;
import com.sprintManagement.web.mvc.entities.Meetings;
import com.sprintManagement.web.mvc.entities.Sprints;
import com.sprintManagement.web.mvc.exceptions.BadRequestException;
import com.sprintManagement.web.mvc.repository.MeetingPlatformRepository;
import com.sprintManagement.web.mvc.repository.MeetingsRepository;
import com.sprintManagement.web.mvc.repository.SprintRepository;
import com.sprintManagement.web.mvc.serviceimpl.MeetingPlatformServices;
import com.sprintManagement.web.mvc.serviceimpl.MeetingServices;
import com.sprintManagement.web.mvc.serviceimpl.SprintServices;
import com.sprintManagement.web.mvc.validate.SprintValidation;

@SpringBootTest
class SprintManagement1ApplicationTests {

	@Mock
	private MeetingsRepository meetingRepository;

	@Mock
	private ModelMapper modelMapper;

	@Mock
	private SprintRepository sprintRepository;

	@Mock
	private SprintValidation sprintValidate;
	@Mock
	private MeetingPlatformRepository meetingPlatformRepository;

	@InjectMocks
	private MeetingPlatformServices meetingPlatformService;

	@InjectMocks
	private SprintServices sprintService;

	@InjectMocks
	private MeetingServices meetingService;

	@SuppressWarnings("deprecation")
	@Before(value = "modelMapper")
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	//Test to get All meeting platforms
	@Test
    public void testGetAllMeetingPlatforms() {
        // Create a list of MeetingPlatform entities
        List<MeetingPlatforms> meetingPlatformList = new ArrayList<>();
        meetingPlatformList.add(new MeetingPlatforms(1L, "Zoom"));
        meetingPlatformList.add(new MeetingPlatforms(2L, "Google Meet"));
        meetingPlatformRepository.save(new MeetingPlatforms(1L, "Zoom"));
        meetingPlatformRepository.save(new MeetingPlatforms(2L, "Google Meet"));
        when(meetingPlatformRepository.findAll()).thenReturn(meetingPlatformList);
        List<MeetingPlatformsDto> result = meetingPlatformService.getAllMeetingPlatforms();
        assertEquals(2, result.size());
    }

	
	// Test to get all Sprints
	@Test
	public void testGetAllSprints() {
		// Mock the sprintRepository to return a list of sprints
		List<Sprints> sprints = new ArrayList<>();
		sprints.add(new Sprints());
		sprints.add(new Sprints());
		when(sprintRepository.findAll()).thenReturn(sprints);
		List<SprintsDto> result = sprintService.getAllSprints();
		assertEquals(2, result.size());
	}

	//Test add new sprint with valid data
	@Test
	public void testAddNewSprintDtoWithValidInput() {
		SprintsDto sprints = new SprintsDto();
		sprints.setSprintId(1L);
		sprints.setStartDate(LocalDate.of(2023, 05, 06));
		sprints.setEndDate(LocalDate.of(2023, 06, 01));
		when(sprintValidate.validate(sprints)).thenReturn(true);
		Sprints sprint = new Sprints();
		sprint.setStartdate(LocalDate.of(2023, 05, 06));
		sprint.setEnddate(LocalDate.of(2023, 06, 01));
		when(sprintRepository.save(sprint)).thenReturn(new Sprints());
		ResponseEntity<SprintsDto> result = sprintService.addNewSprintDto(sprints);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	//Test add new Sprint with invalid data
	@Test
	public void testAddNewSprintDtoWithInvalidInput() {
		SprintsDto sprints = new SprintsDto();
		sprints.setSprintId(1L);
		sprints.setStartDate(LocalDate.of(2023, 05, 06));
		sprints.setEndDate(LocalDate.of(2023, 05, 10));
		when(sprintValidate.validate(sprints)).thenReturn(false);
		ResponseEntity<SprintsDto> result = sprintService.addNewSprintDto(sprints);
		assertEquals(HttpStatus.EXPECTATION_FAILED, result.getStatusCode());
	}

	// Test Get Meeting details by Id;
	@Test
	public void testGetMeetingById() {
		Meetings meeting = new Meetings();
		meeting.setId(1L);
		Mockito.when(meetingRepository.findById(1L)).thenReturn(Optional.of(meeting));
		ResponseEntity<Meetings> response = meetingService.getMeetingById(1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(meeting, response.getBody());
	}

	// Test Reschedule Meeting
	@Test
	public void testRescheduleMeeting() {
		Meetings meeting = new Meetings();
		Mockito.when(meetingRepository.findById(1L)).thenReturn(Optional.of(meeting));
		Meetings newMeeting = new Meetings();
		ResponseEntity<String> response = meetingService.rescheduleMeeting(newMeeting, 1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Meeting rescheduled successfully", response.getBody());
	}

	// Test schedule SprintRetrospective Meeting
	@Test
	public void testAddNewSprintRetrospectiveMeeting() throws BadRequestException {
		Meetings meeting = new Meetings();
		meeting.setId(1L);
		meeting.setMeetingType(MeetingType.SprintRetrospective);
		Sprints sprint = new Sprints(1L, "Sprint-1", LocalDate.of(2023, 05, 05), LocalDate.of(2023, 10, 05), 11L,
				LocalDate.of(2023, 05, 05));
		meeting.setSprint(sprint);
		ResponseEntity<String> response = meetingService.addNewMeeting(meeting);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("SprintRetrospective meeting is scheduled successfully", response.getBody());
	}

	// Test schedule SprintReview Meeting
	@Test
	public void testAddNewSprintReviewMeeting() throws BadRequestException {
		Meetings meeting = new Meetings();
		meeting.setId(1L);
		meeting.setMeetingType(MeetingType.SprintReview);
		Sprints sprint = new Sprints(1L, "Sprint-1", LocalDate.of(2023, 05, 05), LocalDate.of(2023, 10, 05), 11L,
				LocalDate.of(2023, 05, 05));
		meeting.setSprint(sprint);
		ResponseEntity<String> response = meetingService.addNewMeeting(meeting);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("SprintReview meeting is scheduled successfully", response.getBody());
	}

	// Test schedule DailyScrum Meeting
	@Test
	public void testAddNewDailyScrumMeeting() throws BadRequestException {
		Meetings meeting = new Meetings();
		meeting.setId(1L);
		meeting.setMeetingType(MeetingType.DailyScrum);
		Sprints sprint = new Sprints(1L, "Sprint-1", LocalDate.of(2023, 05, 05), LocalDate.of(2023, 10, 05), 11L,
				LocalDate.of(2023, 05, 05));
		meeting.setSprint(sprint);
		ResponseEntity<String> response = meetingService.addNewMeeting(meeting);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("DailyScrum meeting is added successfully", response.getBody());
	}

	// Test schedule Spring planning Meeting
	@Test
	public void testAddNewSprintPlanningMeeting() throws BadRequestException {
		Meetings meeting = new Meetings();
		meeting.setId(1L);
		meeting.setMeetingType(MeetingType.SprintPlanning);
		Sprints sprint = new Sprints(1L, "Sprint-1", LocalDate.of(2023, 05, 05), LocalDate.of(2023, 10, 05), 11L,
				LocalDate.of(2023, 05, 05));
		meeting.setSprint(sprint);
		ResponseEntity<String> response = meetingService.addNewMeeting(meeting);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Sprint Planning meeting scheduled successfully", response.getBody());
	}

}
