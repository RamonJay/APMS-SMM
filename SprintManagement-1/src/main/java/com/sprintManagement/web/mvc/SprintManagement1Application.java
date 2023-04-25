package com.sprintManagement.web.mvc;

import java.time.LocalDate;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sprintManagement.web.mvc.entities.Sprints;
import com.sprintManagement.web.mvc.services.SprintServices;

@SpringBootApplication
public class SprintManagement1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext con=SpringApplication.run(SprintManagement1Application.class, args);
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
