package com.webX.ImplServices;

import java.util.List;

import com.webX.entity.Contact;

public interface ImplContactService {

	public void save(Contact contact);

	public List <Contact> findAll();
	
	public void sendEmail(String email, String subject, String phone, String text);
	
	

}
