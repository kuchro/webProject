package com.webX.ImplServices;

import java.util.List;

import com.webX.entity.User;

public interface ImplUserService {
	public User findOneWithBlogs(int id);
	public List<User> findAll();
	public User findByUser(int id);
	public void save(User user);
	
	
	

}
