package com.webX.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webX.entity.Blog;
import com.webX.entity.Contact;
import com.webX.entity.Item;
import com.webX.entity.Posts;
import com.webX.entity.Role;
import com.webX.entity.User;
import com.webX.repository.BlogRepository;
import com.webX.repository.ContactRepository;
import com.webX.repository.ItemRepository;
import com.webX.repository.PostsRepository;
import com.webX.repository.RoleRepository;
import com.webX.repository.UserRepository;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@PostConstruct
	public void init(){
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
		
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setEnabled(true);
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		
		User userX = new User();
		userX.setName("user");
		userX.setEnabled(false);
		userX.setPassword(encoder.encode("user"));
		List<Role> roleX = new ArrayList<Role>();
		roleX.add(roleUser);
		userX.setRoles(roleX);
		userRepository.save(userX);
		
		User userY = new User();
		userY.setName("UserY");
		List<Role> roleY = new ArrayList<Role>();
		roleY.add(roleUser);
		userY.setRoles(roleY);
		userRepository.save(userY);
		
		
		Blog blogjava = new Blog();
		blogjava.setName("BlogJava");
		blogjava.setUrl("www.java.pl");
		blogjava.setUser(userAdmin);
		blogRepository.save(blogjava);
		
		Item item1 = new Item();
		item1.setBlog(blogjava);
		item1.setTitle("Tytul Blogu");
		item1.setDescription("DESCRITPIONM");
		item1.setLink("wwwjava.pl");
		item1.setPublishDate(new Date());
		itemRepository.save(item1);
		
		Blog blogjavaX = new Blog();
		blogjavaX.setName("BlogJava");
		blogjavaX.setUrl("www.java.pl");
		blogjavaX.setUser(userX);
		blogRepository.save(blogjavaX);
		
		Item item2 = new Item();
		item2.setBlog(blogjavaX);
		item2.setTitle("Tytul Blogu");
		item2.setDescription("DESCRITPIONM");
		item2.setLink("wwwjava.pl");
		item2.setPublishDate(new Date());
		itemRepository.save(item2);
		
		
		Posts post1 = new Posts();
		post1.setAuthor("Karol K");
		post1.setBody("Lorem ipsum dolor sit amet ipsum primis in augue. Sed ac eros. Fusce fringilla sem at orci ultricies urna fringilla enim. Duis at ante. Duis a ornare lobortis semper. Sed interdum pellentesque ut, pulvinar turpis. Integer neque sollicitudin mi. Nam nunc eu libero posuere cubilia Curae, Nulla facilisi. Morbi eleifend. Sed sit amet, consectetuer adipiscing dui auctor varius. Etiam rutrum. Pellentesque ante. Donec vitae velit non neque nibh eu felis neque, fringilla et, lobortis volutpat. Maecenas bibendum vel, dignissim id, vulputate quam. Nam convallis non, tellus. Fusce venenatis eu, fringilla enim. Pellentesque malesuada arcu elit, dictum orci. Proin dapibus, accumsan eget, suscipit a, aliquet molestie. Quisque sed augue id lorem. Fusce venenatis nunc, at erat sed dui. Vivamus iaculis, turpis at turpis. Duis dictum. Fusce nulla. Phasellus lorem semper vitae, consequat non, placerat at, bibendum mi, gravida massa nec ante. Maecenas eget dolor sit amet diam vitae lacus. Pellentesque habitant morbi tristique luctus pellentesque. Proin lacus. Nullam risus libero, consectetuer adipiscing elit. Sed nec felis. Curabitur interdum. Donec odio et malesuada congue. Maecenas vitae pede lacinia varius laoreet. Morbi feugiat venenatis, elit viverra a, rutrum sollicitudin quis, accumsan sit amet nibh. Etiam tellus. Donec eleifend eget, neque. Suspendisse vitae dui ornare vel, consectetuer elit. Nunc ultricies leo. Curabitur sed dui. Pellentesque habitant morbi tristique eu, purus. Mauris et malesuada congue. Integer magna justo non odio. Aliquam erat volutpat. Nullam wisi semper magna diam, tincidunt lorem, pellentesque ut, eleifend congue. Aliquam erat lacus, suscipit lectus. Nullam iaculis malesuada congue. Integer a dictum a, pellentesque quis, ornare facilisis sem ac eros ultrices sit amet, consectetuer ut, semper risus auctor velit. Vivamus orci ut nibh consectetuer nec, elementum leo. Nullam vitae velit sit amet felis. Nulla interdum ligula at arcu vitae nunc vel tortor. Proin ornare mi non odio. Aliquam adipiscing elit. Vivamus arcu elit, lobortis dapibus, libero ante, cursus consequat, orci interdum euismod pulvinar, quam sed massa. Aliquam feugiat dolor. Integer hendrerit feugiat felis. Mauris nec tellus. Suspendisse sed nunc sem, sed enim. Sed tristique senectus et purus at blandit lectus. Nam tempor diam. Fusce nisl dui nulla, vitae wisi eu lacus.");
		post1.setPublishdate(new Date());
		post1.setTitle("Just Example!");
		post1.setUser(userAdmin);
		postsRepository.save(post1);
		
		Posts post2 = new Posts();
		post2.setAuthor("Karol K");
		post2.setBody("Lorem ipsum dolor sit amet ipsum primis in augue. Sed ac eros. Fusce fringilla sem at orci ultricies urna fringilla enim. Duis at ante. Duis a ornare lobortis semper. Sed interdum pellentesque ut, pulvinar turpis. Integer neque sollicitudin mi. Nam nunc eu libero posuere cubilia Curae, Nulla facilisi. Morbi eleifend. Sed sit amet, consectetuer adipiscing dui auctor varius. Etiam rutrum. Pellentesque ante. Donec vitae velit non neque nibh eu felis neque, fringilla et, lobortis volutpat. Maecenas bibendum vel, dignissim id, vulputate quam. Nam convallis non, tellus. Fusce venenatis eu, fringilla enim. Pellentesque malesuada arcu elit, dictum orci. Proin dapibus, accumsan eget, suscipit a, aliquet molestie. Quisque sed augue id lorem. Fusce venenatis nunc, at erat sed dui. Vivamus iaculis, turpis at turpis. Duis dictum. Fusce nulla. Phasellus lorem semper vitae, consequat non, placerat at, bibendum mi, gravida massa nec ante. Maecenas eget dolor sit amet diam vitae lacus. Pellentesque habitant morbi tristique luctus pellentesque. Proin lacus. Nullam risus libero, consectetuer adipiscing elit. Sed nec felis. Curabitur interdum. Donec odio et malesuada congue. Maecenas vitae pede lacinia varius laoreet. Morbi feugiat venenatis, elit viverra a, rutrum sollicitudin quis, accumsan sit amet nibh. Etiam tellus. Donec eleifend eget, neque. Suspendisse vitae dui ornare vel, consectetuer elit. Nunc ultricies leo. Curabitur sed dui. Pellentesque habitant morbi tristique eu, purus. Mauris et malesuada congue. Integer magna justo non odio. Aliquam erat volutpat. Nullam wisi semper magna diam, tincidunt lorem, pellentesque ut, eleifend congue. Aliquam erat lacus, suscipit lectus. Nullam iaculis malesuada congue. Integer a dictum a, pellentesque quis, ornare facilisis sem ac eros ultrices sit amet, consectetuer ut, semper risus auctor velit. Vivamus orci ut nibh consectetuer nec, elementum leo. Nullam vitae velit sit amet felis. Nulla interdum ligula at arcu vitae nunc vel tortor. Proin ornare mi non odio. Aliquam adipiscing elit. Vivamus arcu elit, lobortis dapibus, libero ante, cursus consequat, orci interdum euismod pulvinar, quam sed massa. Aliquam feugiat dolor. Integer hendrerit feugiat felis. Mauris nec tellus. Suspendisse sed nunc sem, sed enim. Sed tristique senectus et purus at blandit lectus. Nam tempor diam. Fusce nisl dui nulla, vitae wisi eu lacus.");
		post2.setPublishdate(new Date());
		post2.setTitle("Just Example2!");
		post2.setUser(userAdmin);
		postsRepository.save(post2);
		
		Posts post3 = new Posts();
		post3.setAuthor("Karol K");
		post3.setBody("Lorem ipsum dolor sit amet ipsum primis in augue. Sed ac eros. Fusce fringilla sem at orci ultricies urna fringilla enim. Duis at ante. Duis a ornare lobortis semper. Sed interdum pellentesque ut, pulvinar turpis. Integer neque sollicitudin mi. Nam nunc eu libero posuere cubilia Curae, Nulla facilisi. Morbi eleifend. Sed sit amet, consectetuer adipiscing dui auctor varius. Etiam rutrum. Pellentesque ante. Donec vitae velit non neque nibh eu felis neque, fringilla et, lobortis volutpat. Maecenas bibendum vel, dignissim id, vulputate quam. Nam convallis non, tellus. Fusce venenatis eu, fringilla enim. Pellentesque malesuada arcu elit, dictum orci. Proin dapibus, accumsan eget, suscipit a, aliquet molestie. Quisque sed augue id lorem. Fusce venenatis nunc, at erat sed dui. Vivamus iaculis, turpis at turpis. Duis dictum. Fusce nulla. Phasellus lorem semper vitae, consequat non, placerat at, bibendum mi, gravida massa nec ante. Maecenas eget dolor sit amet diam vitae lacus. Pellentesque habitant morbi tristique luctus pellentesque. Proin lacus. Nullam risus libero, consectetuer adipiscing elit. Sed nec felis. Curabitur interdum. Donec odio et malesuada congue. Maecenas vitae pede lacinia varius laoreet. Morbi feugiat venenatis, elit viverra a, rutrum sollicitudin quis, accumsan sit amet nibh. Etiam tellus. Donec eleifend eget, neque. Suspendisse vitae dui ornare vel, consectetuer elit. Nunc ultricies leo. Curabitur sed dui. Pellentesque habitant morbi tristique eu, purus. Mauris et malesuada congue. Integer magna justo non odio. Aliquam erat volutpat. Nullam wisi semper magna diam, tincidunt lorem, pellentesque ut, eleifend congue. Aliquam erat lacus, suscipit lectus. Nullam iaculis malesuada congue. Integer a dictum a, pellentesque quis, ornare facilisis sem ac eros ultrices sit amet, consectetuer ut, semper risus auctor velit. Vivamus orci ut nibh consectetuer nec, elementum leo. Nullam vitae velit sit amet felis. Nulla interdum ligula at arcu vitae nunc vel tortor. Proin ornare mi non odio. Aliquam adipiscing elit. Vivamus arcu elit, lobortis dapibus, libero ante, cursus consequat, orci interdum euismod pulvinar, quam sed massa. Aliquam feugiat dolor. Integer hendrerit feugiat felis. Mauris nec tellus. Suspendisse sed nunc sem, sed enim. Sed tristique senectus et purus at blandit lectus. Nam tempor diam. Fusce nisl dui nulla, vitae wisi eu lacus.");
		post3.setPublishdate(new Date());
		post3.setTitle("Just Example3!");
		post3.setUser(userX);
		postsRepository.save(post3);
		
		Posts post4 = new Posts();
		post4.setAuthor("Karol K");
		post4.setBody("Lorem ipsum dolor sit amet ipsum primis in augue. Sed ac eros. Fusce fringilla sem at orci ultricies urna fringilla enim. Duis at ante. Duis a ornare lobortis semper. Sed interdum pellentesque ut, pulvinar turpis. Integer neque sollicitudin mi. Nam nunc eu libero posuere cubilia Curae, Nulla facilisi. Morbi eleifend. Sed sit amet, consectetuer adipiscing dui auctor varius. Etiam rutrum. Pellentesque ante. Donec vitae velit non neque nibh eu felis neque, fringilla et, lobortis volutpat. Maecenas bibendum vel, dignissim id, vulputate quam. Nam convallis non, tellus. Fusce venenatis eu, fringilla enim. Pellentesque malesuada arcu elit, dictum orci. Proin dapibus, accumsan eget, suscipit a, aliquet molestie. Quisque sed augue id lorem. Fusce venenatis nunc, at erat sed dui. Vivamus iaculis, turpis at turpis. Duis dictum. Fusce nulla. Phasellus lorem semper vitae, consequat non, placerat at, bibendum mi, gravida massa nec ante. Maecenas eget dolor sit amet diam vitae lacus. Pellentesque habitant morbi tristique luctus pellentesque. Proin lacus. Nullam risus libero, consectetuer adipiscing elit. Sed nec felis. Curabitur interdum. Donec odio et malesuada congue. Maecenas vitae pede lacinia varius laoreet. Morbi feugiat venenatis, elit viverra a, rutrum sollicitudin quis, accumsan sit amet nibh. Etiam tellus. Donec eleifend eget, neque. Suspendisse vitae dui ornare vel, consectetuer elit. Nunc ultricies leo. Curabitur sed dui. Pellentesque habitant morbi tristique eu, purus. Mauris et malesuada congue. Integer magna justo non odio. Aliquam erat volutpat. Nullam wisi semper magna diam, tincidunt lorem, pellentesque ut, eleifend congue. Aliquam erat lacus, suscipit lectus. Nullam iaculis malesuada congue. Integer a dictum a, pellentesque quis, ornare facilisis sem ac eros ultrices sit amet, consectetuer ut, semper risus auctor velit. Vivamus orci ut nibh consectetuer nec, elementum leo. Nullam vitae velit sit amet felis. Nulla interdum ligula at arcu vitae nunc vel tortor. Proin ornare mi non odio. Aliquam adipiscing elit. Vivamus arcu elit, lobortis dapibus, libero ante, cursus consequat, orci interdum euismod pulvinar, quam sed massa. Aliquam feugiat dolor. Integer hendrerit feugiat felis. Mauris nec tellus. Suspendisse sed nunc sem, sed enim. Sed tristique senectus et purus at blandit lectus. Nam tempor diam. Fusce nisl dui nulla, vitae wisi eu lacus.");
		post4.setPublishdate(new Date());
		post4.setTitle("Just Example4!");
		post4.setUser(userY);
		postsRepository.save(post4);
		
		Posts post5 = new Posts();
		post5.setAuthor("Karol K");
		post5.setBody("Lorem ipsum dolor sit amet ipsum primis in augue. Sed ac eros. Fusce fringilla sem at orci ultricies urna fringilla enim. Duis at ante. Duis a ornare lobortis semper. Sed interdum pellentesque ut, pulvinar turpis. Integer neque sollicitudin mi. Nam nunc eu libero posuere cubilia Curae, Nulla facilisi. Morbi eleifend. Sed sit amet, consectetuer adipiscing dui auctor varius. Etiam rutrum. Pellentesque ante. Donec vitae velit non neque nibh eu felis neque, fringilla et, lobortis volutpat. Maecenas bibendum vel, dignissim id, vulputate quam. Nam convallis non, tellus. Fusce venenatis eu, fringilla enim. Pellentesque malesuada arcu elit, dictum orci. Proin dapibus, accumsan eget, suscipit a, aliquet molestie. Quisque sed augue id lorem. Fusce venenatis nunc, at erat sed dui. Vivamus iaculis, turpis at turpis. Duis dictum. Fusce nulla. Phasellus lorem semper vitae, consequat non, placerat at, bibendum mi, gravida massa nec ante. Maecenas eget dolor sit amet diam vitae lacus. Pellentesque habitant morbi tristique luctus pellentesque. Proin lacus. Nullam risus libero, consectetuer adipiscing elit. Sed nec felis. Curabitur interdum. Donec odio et malesuada congue. Maecenas vitae pede lacinia varius laoreet. Morbi feugiat venenatis, elit viverra a, rutrum sollicitudin quis, accumsan sit amet nibh. Etiam tellus. Donec eleifend eget, neque. Suspendisse vitae dui ornare vel, consectetuer elit. Nunc ultricies leo. Curabitur sed dui. Pellentesque habitant morbi tristique eu, purus. Mauris et malesuada congue. Integer magna justo non odio. Aliquam erat volutpat. Nullam wisi semper magna diam, tincidunt lorem, pellentesque ut, eleifend congue. Aliquam erat lacus, suscipit lectus. Nullam iaculis malesuada congue. Integer a dictum a, pellentesque quis, ornare facilisis sem ac eros ultrices sit amet, consectetuer ut, semper risus auctor velit. Vivamus orci ut nibh consectetuer nec, elementum leo. Nullam vitae velit sit amet felis. Nulla interdum ligula at arcu vitae nunc vel tortor. Proin ornare mi non odio. Aliquam adipiscing elit. Vivamus arcu elit, lobortis dapibus, libero ante, cursus consequat, orci interdum euismod pulvinar, quam sed massa. Aliquam feugiat dolor. Integer hendrerit feugiat felis. Mauris nec tellus. Suspendisse sed nunc sem, sed enim. Sed tristique senectus et purus at blandit lectus. Nam tempor diam. Fusce nisl dui nulla, vitae wisi eu lacus.");
		post5.setPublishdate(new Date());
		post5.setTitle("Just Example5!");
		post5.setUser(userY);
		postsRepository.save(post5);
		

		Posts post6 = new Posts();
		post6.setAuthor("Karol K");
		post6.setBody("Lorem ipsum dolor sit amet ipsum primis in augue. Sed ac eros. Fusce fringilla sem at orci ultricies urna fringilla enim. Duis at ante. Duis a ornare lobortis semper. Sed interdum pellentesque ut, pulvinar turpis. Integer neque sollicitudin mi. Nam nunc eu libero posuere cubilia Curae, Nulla facilisi. Morbi eleifend. Sed sit amet, consectetuer adipiscing dui auctor varius. Etiam rutrum. Pellentesque ante. Donec vitae velit non neque nibh eu felis neque, fringilla et, lobortis volutpat. Maecenas bibendum vel, dignissim id, vulputate quam. Nam convallis non, tellus. Fusce venenatis eu, fringilla enim. Pellentesque malesuada arcu elit, dictum orci. Proin dapibus, accumsan eget, suscipit a, aliquet molestie. Quisque sed augue id lorem. Fusce venenatis nunc, at erat sed dui. Vivamus iaculis, turpis at turpis. Duis dictum. Fusce nulla. Phasellus lorem semper vitae, consequat non, placerat at, bibendum mi, gravida massa nec ante. Maecenas eget dolor sit amet diam vitae lacus. Pellentesque habitant morbi tristique luctus pellentesque. Proin lacus. Nullam risus libero, consectetuer adipiscing elit. Sed nec felis. Curabitur interdum. Donec odio et malesuada congue. Maecenas vitae pede lacinia varius laoreet. Morbi feugiat venenatis, elit viverra a, rutrum sollicitudin quis, accumsan sit amet nibh. Etiam tellus. Donec eleifend eget, neque. Suspendisse vitae dui ornare vel, consectetuer elit. Nunc ultricies leo. Curabitur sed dui. Pellentesque habitant morbi tristique eu, purus. Mauris et malesuada congue. Integer magna justo non odio. Aliquam erat volutpat. Nullam wisi semper magna diam, tincidunt lorem, pellentesque ut, eleifend congue. Aliquam erat lacus, suscipit lectus. Nullam iaculis malesuada congue. Integer a dictum a, pellentesque quis, ornare facilisis sem ac eros ultrices sit amet, consectetuer ut, semper risus auctor velit. Vivamus orci ut nibh consectetuer nec, elementum leo. Nullam vitae velit sit amet felis. Nulla interdum ligula at arcu vitae nunc vel tortor. Proin ornare mi non odio. Aliquam adipiscing elit. Vivamus arcu elit, lobortis dapibus, libero ante, cursus consequat, orci interdum euismod pulvinar, quam sed massa. Aliquam feugiat dolor. Integer hendrerit feugiat felis. Mauris nec tellus. Suspendisse sed nunc sem, sed enim. Sed tristique senectus et purus at blandit lectus. Nam tempor diam. Fusce nisl dui nulla, vitae wisi eu lacus.");
		post6.setPublishdate(new Date());
		post6.setTitle("Just Example6!");
		post6.setUser(userX);
		postsRepository.save(post6);
		
		Contact c1 = new Contact();
		c1.setContactEmail("firmax@ala.pl");
		c1.setPhoneNumber("555-777-333");
		c1.setTextBody("Lorem ipsum dolor sit amet ipsum primis in augue. Sed ac eros. Fusce fringilla sem at orci ultricies urna fringilla enim. Duis at ante. Duis a ornare lobortis semper. Sed interdum pellentesque ut, pulvinar turpis. Integer neque sollicitudin mi. Nam nunc eu libero posuere cubilia Curae, Nulla facilisi. Morbi eleifend. Sed sit amet, consectetuer adipiscing dui auctor varius. Etiam rutrum. Pellentesque ante. Donec vitae velit non neque nibh eu felis neque, fringilla et, lobortis volutpat. Maecenas bibendum vel, dignissim id, vulputate quam. Nam convallis non, tellus. Fusce venenatis eu, fringilla enim. Pellentesque malesuada arcu elit, dictum orci. Proin dapibus, accumsan eget, suscipit a, aliquet molestie. Quisque sed augue id lorem. Fusce venenatis nunc, at erat sed dui. Vivamus iaculis, turpis at turpis. Duis dictum. Fusce nulla. Phasellus lorem semper vitae, consequat non, placerat at, bibendum mi, gravida massa nec ante. Maecenas eget dolor sit amet diam vitae lacus. Pellentesque habitant morbi tristique luctus pellentesque. Proin lacus. Nullam risus libero, consectetuer adipiscing elit. Sed nec felis. Curabitur interdum. Donec odio et malesuada congue. Maecenas vitae pede lacinia varius laoreet. Morbi feugiat venenatis, elit viverra a, rutrum sollicitudin quis, accumsan sit amet nibh. Etiam tellus. Donec eleifend eget, neque. Suspendisse vitae dui ornare vel, consectetuer elit. Nunc ultricies leo. Curabitur sed dui. Pellentesque habitant morbi tristique eu, purus. Mauris et malesuada congue. Integer magna justo non odio. Aliquam erat volutpat. Nullam wisi semper magna diam, tincidunt lorem, pellentesque ut, eleifend congue. Aliquam erat lacus, suscipit lectus. Nullam iaculis malesuada congue. Integer a dictum a, pellentesque quis, ornare facilisis sem ac eros ultrices sit amet, consectetuer ut, semper risus auctor velit. Vivamus orci ut nibh consectetuer nec, elementum leo. Nullam vitae velit sit amet felis. Nulla interdum ligula at arcu vitae nunc vel tortor. Proin ornare mi non odio. Aliquam adipiscing elit. Vivamus arcu elit, lobortis dapibus, libero ante, cursus consequat, orci interdum euismod pulvinar, quam sed massa. Aliquam feugiat dolor. Integer hendrerit feugiat felis. Mauris nec tellus. Suspendisse sed nunc sem, sed enim. Sed tristique senectus et purus at blandit lectus. Nam tempor diam. Fusce nisl dui nulla, vitae wisi eu lacus.");
		contactRepository.save(c1);
		
		Contact c2 = new Contact();
		c2.setContactEmail("firmax@ala.pl");
		c2.setPhoneNumber("555-777-333");
		c2.setTextBody("Lorem ipsum dolor sit amet ipsum primis in augue. Sed ac eros. Fusce fringilla sem at orci ultricies urna fringilla enim. Duis at ante. Duis a ornare lobortis semper. Sed interdum pellentesque ut, pulvinar turpis. Integer neque sollicitudin mi. Nam nunc eu libero posuere cubilia Curae, Nulla facilisi. Morbi eleifend. Sed sit amet, consectetuer adipiscing dui auctor varius. Etiam rutrum. Pellentesque ante. Donec vitae velit non neque nibh eu felis neque, fringilla et, lobortis volutpat. Maecenas bibendum vel, dignissim id, vulputate quam. Nam convallis non, tellus. Fusce venenatis eu, fringilla enim. Pellentesque malesuada arcu elit, dictum orci. Proin dapibus, accumsan eget, suscipit a, aliquet molestie. Quisque sed augue id lorem. Fusce venenatis nunc, at erat sed dui. Vivamus iaculis, turpis at turpis. Duis dictum. Fusce nulla. Phasellus lorem semper vitae, consequat non, placerat at, bibendum mi, gravida massa nec ante. Maecenas eget dolor sit amet diam vitae lacus. Pellentesque habitant morbi tristique luctus pellentesque. Proin lacus. Nullam risus libero, consectetuer adipiscing elit. Sed nec felis. Curabitur interdum. Donec odio et malesuada congue. Maecenas vitae pede lacinia varius laoreet. Morbi feugiat venenatis, elit viverra a, rutrum sollicitudin quis, accumsan sit amet nibh. Etiam tellus. Donec eleifend eget, neque. Suspendisse vitae dui ornare vel, consectetuer elit. Nunc ultricies leo. Curabitur sed dui. Pellentesque habitant morbi tristique eu, purus. Mauris et malesuada congue. Integer magna justo non odio. Aliquam erat volutpat. Nullam wisi semper magna diam, tincidunt lorem, pellentesque ut, eleifend congue. Aliquam erat lacus, suscipit lectus. Nullam iaculis malesuada congue. Integer a dictum a, pellentesque quis, ornare facilisis sem ac eros ultrices sit amet, consectetuer ut, semper risus auctor velit. Vivamus orci ut nibh consectetuer nec, elementum leo. Nullam vitae velit sit amet felis. Nulla interdum ligula at arcu vitae nunc vel tortor. Proin ornare mi non odio. Aliquam adipiscing elit. Vivamus arcu elit, lobortis dapibus, libero ante, cursus consequat, orci interdum euismod pulvinar, quam sed massa. Aliquam feugiat dolor. Integer hendrerit feugiat felis. Mauris nec tellus. Suspendisse sed nunc sem, sed enim. Sed tristique senectus et purus at blandit lectus. Nam tempor diam. Fusce nisl dui nulla, vitae wisi eu lacus.");
		contactRepository.save(c2);
		
		Contact c3 = new Contact();
		c3.setContactEmail("firmax@ala.pl");
		c3.setPhoneNumber("555-777-333");
		c3.setTextBody("Lorem ipsum dolor sit amet ipsum primis in augue. Sed ac eros. Fusce fringilla sem at orci ultricies urna fringilla enim. Duis at ante. Duis a ornare lobortis semper. Sed interdum pellentesque ut, pulvinar turpis. Integer neque sollicitudin mi. Nam nunc eu libero posuere cubilia Curae, Nulla facilisi. Morbi eleifend. Sed sit amet, consectetuer adipiscing dui auctor varius. Etiam rutrum. Pellentesque ante. Donec vitae velit non neque nibh eu felis neque, fringilla et, lobortis volutpat. Maecenas bibendum vel, dignissim id, vulputate quam. Nam convallis non, tellus. Fusce venenatis eu, fringilla enim. Pellentesque malesuada arcu elit, dictum orci. Proin dapibus, accumsan eget, suscipit a, aliquet molestie. Quisque sed augue id lorem. Fusce venenatis nunc, at erat sed dui. Vivamus iaculis, turpis at turpis. Duis dictum. Fusce nulla. Phasellus lorem semper vitae, consequat non, placerat at, bibendum mi, gravida massa nec ante. Maecenas eget dolor sit amet diam vitae lacus. Pellentesque habitant morbi tristique luctus pellentesque. Proin lacus. Nullam risus libero, consectetuer adipiscing elit. Sed nec felis. Curabitur interdum. Donec odio et malesuada congue. Maecenas vitae pede lacinia varius laoreet. Morbi feugiat venenatis, elit viverra a, rutrum sollicitudin quis, accumsan sit amet nibh. Etiam tellus. Donec eleifend eget, neque. Suspendisse vitae dui ornare vel, consectetuer elit. Nunc ultricies leo. Curabitur sed dui. Pellentesque habitant morbi tristique eu, purus. Mauris et malesuada congue. Integer magna justo non odio. Aliquam erat volutpat. Nullam wisi semper magna diam, tincidunt lorem, pellentesque ut, eleifend congue. Aliquam erat lacus, suscipit lectus. Nullam iaculis malesuada congue. Integer a dictum a, pellentesque quis, ornare facilisis sem ac eros ultrices sit amet, consectetuer ut, semper risus auctor velit. Vivamus orci ut nibh consectetuer nec, elementum leo. Nullam vitae velit sit amet felis. Nulla interdum ligula at arcu vitae nunc vel tortor. Proin ornare mi non odio. Aliquam adipiscing elit. Vivamus arcu elit, lobortis dapibus, libero ante, cursus consequat, orci interdum euismod pulvinar, quam sed massa. Aliquam feugiat dolor. Integer hendrerit feugiat felis. Mauris nec tellus. Suspendisse sed nunc sem, sed enim. Sed tristique senectus et purus at blandit lectus. Nam tempor diam. Fusce nisl dui nulla, vitae wisi eu lacus.");
		contactRepository.save(c3);
		
	
		
		
		
	}

}
