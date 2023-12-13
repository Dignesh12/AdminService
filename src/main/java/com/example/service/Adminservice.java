package com.example.service;

import org.springframework.stereotype.Service;

import com.example.Entity.Admin;

import jakarta.validation.Valid;

@Service
public interface Adminservice {
	
	void registerAdmin(@Valid Admin admin);
	void login(String adminname, String password);
	void deleteAdmin(int adminId);

}
