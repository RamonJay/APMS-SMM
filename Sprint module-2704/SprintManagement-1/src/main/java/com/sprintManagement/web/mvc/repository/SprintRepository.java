package com.sprintManagement.web.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintManagement.web.mvc.entities.Sprints;

public interface SprintRepository extends JpaRepository<Sprints,Long>{

}
