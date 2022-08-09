package com.meetverse.Meetverse.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meetverse.Meetverse.model.MessageModel;
@Repository
public interface MessageRepository extends JpaRepository<MessageModel, UUID>{

}
