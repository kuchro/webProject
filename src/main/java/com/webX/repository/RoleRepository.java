package com.webX.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webX.entity.Role;

public interface RoleRepository extends JpaRepository< Role, Integer> {

	Role findByName(String name);

}
