package com.webX.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webX.ImplServices.ImplContactService;
import com.webX.ImplServices.ImplPostsService;
import com.webX.entity.Posts;

@Controller
public class admController {

	@Autowired
	private ImplPostsService implPostsService;
	
	@Autowired
	private ImplContactService implContactService;

	@ModelAttribute("addPost")
	public Posts construct() {
		return new Posts();
	}

	@RequestMapping("/adm")
	public String adm(Model model) {
		return "adm_pannel";
	}

	@RequestMapping("/adm/add")
	public String toForm() {
		return "add-post";
	}

	@RequestMapping(value = "/adm/add", method = RequestMethod.POST)
	public String addPost(@Valid @ModelAttribute("addPost") Posts post, BindingResult result) {
		
		if(result.hasErrors()){
			return "add-post";
		}
		implPostsService.save(post);
		
		return "redirect:/adm/add.html?succes=true";
	}
	
	@RequestMapping("/adm/manage")
	public String managePosts(Model model){
		model.addAttribute("manage", implPostsService.findAll());
		return "managePosts";
	}
	
	@RequestMapping("/adm/manage/{id}")
	public String removePost(@PathVariable int id){
		implPostsService.deletePost(id);
		return "redirect:/adm/manage.html";
	}
	
	@RequestMapping("/adm/messages")
	public String findAllMessage(Model model){
		model.addAttribute("message", implContactService.findAll() );
		
		return "messages";
	}
}
