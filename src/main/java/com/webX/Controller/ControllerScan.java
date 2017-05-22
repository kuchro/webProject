package com.webX.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webX.ImplServices.ImplContactService;
import com.webX.entity.Contact;


@Controller
public class ControllerScan {
	
	@Autowired
	private ImplContactService implContactService;
	
	@ModelAttribute("contactUs")
	public Contact construct(){
		return new Contact();
	}
	
	@RequestMapping("/")
	public String welcome(Model model){
		return "index";
		
	}
	
@RequestMapping("/contact")
public String contact(){
	return "contact-us";
}
	
	
	
	@RequestMapping(value= "/contact", method = RequestMethod.POST)
	public String contactSent(@Valid @ModelAttribute("contactUs") Contact contact, BindingResult result){
		if(result.hasErrors()){
			return "contact-us";
		}
		
		System.out.println(contact.getTextBody()+"--TEST");
		implContactService.save(contact);
		implContactService.sendEmail(contact.getContactEmail(), contact.getSubject() ,contact.getPhoneNumber(), contact.getTextBody());
		
		return "redirect:/contact.html?success=true";
	}
	
}
