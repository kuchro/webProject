package com.webX.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.webX.ImplServices.ImplPostsService;
import com.webX.entity.Posts;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private ImplPostsService implPostsService;
	
	@GetMapping("restpost")
	public List<Posts> getAllPosts(){
		List<Posts> posts = new ArrayList<Posts>();
		posts.addAll(implPostsService.findAll());
		return posts;
	}

	
	
	@GetMapping("restpost/{id}")
	public ArrayList<String> findOne(@PathVariable int id){
		
		ArrayList<String> post = new ArrayList<String>();
		post.addAll(implPostsService.getOne(id));
		return post;
}
}

