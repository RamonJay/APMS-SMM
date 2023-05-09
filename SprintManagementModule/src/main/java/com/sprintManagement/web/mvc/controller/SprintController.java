package com.sprintManagement.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintManagement.web.mvc.dto.SprintsDto;
import com.sprintManagement.web.mvc.service.SprintDao;

@RestController
@RequestMapping("/api/")
public class SprintController {

	@Autowired
	private SprintDao sprintServices;

	// Control to add new Sprint
	@PostMapping("sprints/new")
	public ResponseEntity<SprintsDto> addNewSprint(@RequestBody SprintsDto sprintDto) {
		return sprintServices.addNewSprintDto(sprintDto);
	}

	// Control to get List of all sprints
	@GetMapping("sprints")
	public List<SprintsDto> getAllSprint() {
		return sprintServices.getAllSprints();
	}
}
