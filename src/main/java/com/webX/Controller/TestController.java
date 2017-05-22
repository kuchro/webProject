package com.webX.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webX.ImplServices.ImplUserService;

@Controller
public class TestController {
	
	@Autowired
	private ImplUserService implUserService;
	
	
	
	@RequestMapping("/test/{id}")
	public String test(Model model, @PathVariable int id){
		model.addAttribute("test", implUserService.findByUser(id));
		return "test";
	}

}
