package com.webX.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.webX.ImplServices.ImplPostsService;
import com.webX.entity.Posts;
import com.webX.repository.PostsRepository;

@Service
public class PostsService implements ImplPostsService {
	
	@Autowired
	private PostsRepository postsRepository;
	

	
	public List <Posts> findAll(){
		return postsRepository.findAll();
	}
	
	
	public Posts findOne(int id){
		return postsRepository.findOne(id);
	}


	public void save(Posts post) {
		post.setPublishdate(new Date());
		postsRepository.save(post);
		
	}



	public void deletePost(int id) {
		
		postsRepository.delete(id);
	}


	

	public List<String> getOne(int id){
		String no = postsRepository.findOne(id).getBody().toString();
		String n1 = postsRepository.findOne(id).getAuthor().toString();
		String n2 = postsRepository.findOne(id).getTitle().toString();
		List<String> post = new ArrayList<String>();
		post.add(no);
		post.add(n1);
		post.add(n2);
		
		
		return post;
		
	}


	

}
