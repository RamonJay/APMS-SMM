package com.sprintManagement.web.mvc.seeder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.sprintManagement.web.mvc.entities.MeetingPlatforms;
import com.sprintManagement.web.mvc.repository.MeetingPlatformRepository;

@Component
public class MeetingPlatformSeeder implements ApplicationRunner{

	@Autowired
	private MeetingPlatformRepository meetingPlatformRepository;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		seedMeetingPlatform();
		
	}
	
	private void seedMeetingPlatform() {
		MeetingPlatforms zoom=new MeetingPlatforms(11L,"Zoom"); 
		MeetingPlatforms meet=new MeetingPlatforms(12L,"Meet"); 
		MeetingPlatforms teams=new MeetingPlatforms(13L,"Team");
		MeetingPlatforms WebEx=new MeetingPlatforms(14L,"WebEx"); 
		meetingPlatformRepository.saveAll(List.of(zoom,meet,teams,WebEx));
		
	}

}
