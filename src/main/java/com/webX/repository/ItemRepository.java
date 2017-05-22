package com.webX.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.webX.entity.Item;
import com.webX.entity.Blog;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	List<Item> findByBlog(Blog blog, Pageable pageable);

}
