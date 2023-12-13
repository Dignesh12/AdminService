package com.example.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.Entity.Admin;



@Repository
public interface AdminRepositiory extends JpaRepository<Admin,Integer>{
	
	boolean existsByAdminname(String adminname);
	Admin findByAdminname(String adminname);

}
