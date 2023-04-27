package com.sprintManagement.web.mvc.validate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import com.sprintManagement.web.mvc.dto.SprintsDto;
@Component
public class SprintValidation {
	public boolean validate(SprintsDto sprintDto) {
		LocalDate startDate=LocalDate.now();
		LocalDate endDate=sprintDto.getEnddate();
		long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
		int weeks=(int)totalDays/7;
		if(weeks<=4 && weeks>=1) {
			return true;
		}else {
		return false;
		}
	}

}
