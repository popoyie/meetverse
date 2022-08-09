package com.meetverse.Meetverse.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meetverse.Meetverse.model.UserModel;
@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID>{

	UserModel findByEmail(String email);
	UserModel findByUsername(String username);
}
