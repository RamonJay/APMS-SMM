package com.sprintManagement.web.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprintManagement.web.mvc.entities.MeetingPlatforms;

public interface MeetingPlatformRepository extends JpaRepository<MeetingPlatforms, Long> {

}
