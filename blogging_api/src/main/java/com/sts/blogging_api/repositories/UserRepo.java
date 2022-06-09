package com.sts.blogging_api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.blogging_api.entites.User;

public interface UserRepo extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
	
}
