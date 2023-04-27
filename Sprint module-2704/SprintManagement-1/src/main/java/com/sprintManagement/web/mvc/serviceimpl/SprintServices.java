package com.sprintManagement.web.mvc.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprintManagement.web.mvc.dto.SprintsDto;
import com.sprintManagement.web.mvc.entities.Sprints;
import com.sprintManagement.web.mvc.repository.SprintRepository;
import com.sprintManagement.web.mvc.service.SprintDao;
import com.sprintManagement.web.mvc.validate.SprintValidation;

@Service
public class SprintServices implements SprintDao {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SprintRepository sprintRepository;
	
	@Autowired
	private SprintValidation sprintValidate;

	@Override
	public List<SprintsDto> getAllSprints() {
		return sprintRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	
	@Override
	public ResponseEntity<SprintsDto> addNewSprintDto(SprintsDto sprintDto) {
		// TODO Auto-generated method stub
		if(sprintValidate.validate(sprintDto)) {
			String name="Sprint-";
			name=name.concat(Long.toString(sprintDto.getSprintid()));
			sprintDto.setSprintname(name);
		Sprints sprint = ConvertDtoToEntity(sprintDto);
		sprint = sprintRepository.save(sprint);
		return ResponseEntity.ok(convertEntityToDTO(sprint));
		}else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build(); 
		}
	}

	private Sprints ConvertDtoToEntity(SprintsDto sprintDto) {
		Sprints sprint = new Sprints();
		sprint = modelMapper.map(sprintDto, Sprints.class);
		return sprint;
	}
	private SprintsDto convertEntityToDTO(Sprints sprint) {
		SprintsDto sprintDto = new SprintsDto();
		sprintDto = modelMapper.map(sprint, SprintsDto.class);
		return sprintDto;

	}

}
