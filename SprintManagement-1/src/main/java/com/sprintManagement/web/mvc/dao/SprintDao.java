package com.sprintManagement.web.mvc.dao;

import java.util.List;

import com.sprintManagement.web.mvc.entities.Sprints;

public interface SprintDao  {

	Sprints addNewSprint(Sprints sprint);
	List<Sprints> getAllSprints();
}
