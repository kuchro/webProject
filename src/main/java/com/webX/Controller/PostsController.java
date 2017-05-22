package com.webX.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webX.ImplServices.ImplPostsService;




@Controller
public class PostsController {
	
	@Autowired
	private ImplPostsService implPostsService;
	
	
	@RequestMapping("/posts")
	public String posts(Model model){
		model.addAttribute("posts", implPostsService.findAll());
		return "posts";
	}
	
	@RequestMapping("/posts/{id}")
	public String postsId(Model model, @PathVariable int id){
		model.addAttribute("postid", implPostsService.findOne(id));
		return "post-detail";
	}
	
	
	
	
	

}
