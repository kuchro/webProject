package com.webX.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webX.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
