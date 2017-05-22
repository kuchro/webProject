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

import com.webX.ImplServices.ImplUserService;
import com.webX.entity.User;



@Controller
public class UserController {
	
	@Autowired
	private ImplUserService implUserService;;
	
	@ModelAttribute("userRegister")
	public User construct(){
		return new User();
	}
	

	
	
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("users", implUserService.findAll());
		return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String user_id(Model model, @PathVariable int id){
		model.addAttribute("user", implUserService.findOneWithBlogs(id));
		return "user-detail";
	}
	
	@RequestMapping("/register")
	public String registerUser(){
		return "user-register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
		public String doRegistration(@Valid @ModelAttribute("userRegister") User user, BindingResult result){
			if(result.hasErrors()){
				return "user-register";
			}
			implUserService.save(user);
			return "redirect:/register.html?succes=true";
	}
	
}
