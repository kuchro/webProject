package com.webX.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webX.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	

}
