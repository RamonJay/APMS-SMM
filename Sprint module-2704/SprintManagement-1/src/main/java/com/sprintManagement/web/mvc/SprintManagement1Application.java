package com.sprintManagement.web.mvc;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SprintManagement1Application {

    @Bean
    ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SprintManagement1Application.class, args);
		
//		SprintServices ss=con.getBean(SprintServices.class);
//		Sprints sp=new Sprints();
//		sp.setSprintid(2L);
//	sp.setSprintname("Jay");
//	sp.setStartdate(LocalDate.of(2023, 03, 25));
//	sp.setEnddate(LocalDate.of(2023, 06,25));
//	sp.setCreatedon(LocalDate.now());
//	sp.setProjectcode(122L);
//	Sprints ot=ss.addNewSprint(sp);
	System.out.println("Run successfully.....");
	}

}
