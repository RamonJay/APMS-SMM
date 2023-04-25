package com.sprintManagement.web.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintManagement.web.mvc.entities.Meetings;

public interface MeetingsRepository extends JpaRepository<Meetings,Long>{

}
