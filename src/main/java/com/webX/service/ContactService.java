package com.webX.service;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webX.ImplServices.ImplContactService;
import com.webX.entity.Contact;
import com.webX.repository.ContactRepository;

@Service
public class ContactService implements ImplContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void save(Contact contact) {
		contactRepository.save(contact);

	}

	public List<Contact> findAll() {

		return contactRepository.findAll();
	}
	
	public void sendEmail(String email, String subject, String phone, String text){
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("karoltestowy91@gmail.com");
		message.setSubject(subject+","+email+",phone:"+phone);
		message.setText(text);
		
	try{
		mailSender.send(message);
	}catch(MailException e ){
		
		System.err.println("Wystapil blad: "+e);
		
	}
		
		
		
	}

}
