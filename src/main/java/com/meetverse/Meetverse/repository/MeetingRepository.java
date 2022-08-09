package com.meetverse.Meetverse.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meetverse.Meetverse.model.MeetingModel;
@Repository
public interface MeetingRepository extends JpaRepository<MeetingModel, UUID>{

}
