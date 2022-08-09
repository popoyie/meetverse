package com.meetverse.Meetverse.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetverse.Meetverse.model.MeetingModel;
import com.meetverse.Meetverse.repository.MeetingRepository;

@RestController
@RequestMapping("/meeting")
public class MeetingController {
	@Autowired
	private MeetingRepository repo;

	@PostMapping("/create")
	public MeetingModel createMeeting(@RequestBody MeetingModel meeting) {
		return repo.save(meeting);
	}

	@DeleteMapping("/destroy/{id}")
	public boolean destroyMeeting(@PathVariable UUID id) {
		repo.deleteById(id);
		return true;
	}
}
