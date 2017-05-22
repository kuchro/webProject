package com.webX.ImplServices;

import java.util.List;



import com.webX.entity.Posts;


public interface ImplPostsService {
	
	
	public Posts findOne(int id);
	public void save(Posts post);
	public List <Posts> findAll();
	public void deletePost(int id);
	public List<String> getOne(int id);


	

	

}
