package com.sprintManagement.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.sprintManagement.web.mvc.entities.Sprints;
import com.sprintManagement.web.mvc.services.SprintServices;

@RestController
public class SprintController {

	@Autowired
	private SprintServices sprintServices;
	
	@PostMapping("/sprint")
	public Sprints addNewSprint(Sprints sprint) {
		return sprintServices.addNewSprint(sprint);
	}
	
	@GetMapping("/sprint")
	public List<Sprints> getAllSprint(){
		return sprintServices.getAllSprints();
	}
}
