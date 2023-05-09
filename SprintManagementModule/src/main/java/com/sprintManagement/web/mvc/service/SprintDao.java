package com.sprintManagement.web.mvc.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sprintManagement.web.mvc.dto.SprintsDto;

public interface SprintDao  {
	List<SprintsDto> getAllSprints();
	ResponseEntity<SprintsDto> addNewSprintDto(SprintsDto sprintDto);
}
