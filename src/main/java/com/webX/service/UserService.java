package com.webX.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.webX.ImplServices.ImplUserService;
import com.webX.entity.Blog;
import com.webX.entity.Item;
import com.webX.entity.Posts;
import com.webX.entity.Role;
import com.webX.entity.User;
import com.webX.repository.BlogRepository;
import com.webX.repository.ItemRepository;
import com.webX.repository.PostsRepository;
import com.webX.repository.RoleRepository;
import com.webX.repository.UserRepository;

@Service
@Transactional
public class UserService implements ImplUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	public List<User> findAll(){
		return userRepository.findAll();
	}


	public User findOne(int id) {
		
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(int id) {
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		
		for( Blog blog: blogs){
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishDate"));
			blog.setItems(items);
			
			
			
		}
		List <Posts> posts = postsRepository.findByUser(user);
		user.setPosts(posts);
		user.setBlogs(blogs);
	
	
		
		return user;
	}
		
		@Transactional
		public User findByUser(int id){
			User user = findOne(id);
			List<Posts> posts = postsRepository.findByUser(user);
			
			user.setPosts(posts);
				
			
			return user;
		}
		
		public void save(User user){
			user.setEnabled(true);
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findByName("ROLE_USER"));
			user.setRoles(roles);
			
			userRepository.save(user);
		}

	
	}
	
	
	
	
	
	
	





	


