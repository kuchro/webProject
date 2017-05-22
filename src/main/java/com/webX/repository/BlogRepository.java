package com.webX.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webX.entity.Blog;
import com.webX.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	
	List<Blog> findByUser(User user);

}
