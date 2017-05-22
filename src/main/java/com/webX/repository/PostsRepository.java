package com.webX.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.webX.entity.Posts;
import com.webX.entity.User;


public interface PostsRepository extends JpaRepository<Posts, Integer> {
	public List <Posts> findAll();

	
	public List <Posts> findByUser(User user);






	
}
