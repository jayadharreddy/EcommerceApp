package com.project.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecom.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional <User> findFirstByEmail(String email);
}
