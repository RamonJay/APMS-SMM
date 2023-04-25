package com.sprintManagement.web.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintManagement.web.mvc.dao.SprintDao;
import com.sprintManagement.web.mvc.entities.Sprints;
import com.sprintManagement.web.mvc.repository.SprintRepository;

@Service
public class SprintServices implements SprintDao {

	@Autowired
	private SprintRepository sprintRepository;
	@Override
	public Sprints addNewSprint(Sprints sprint) {
		// TODO Auto-generated method stub
		return sprintRepository.save(sprint);
	}
	
	@Override
	public List<Sprints> getAllSprints(){
		return sprintRepository.findAll();
	}

}
