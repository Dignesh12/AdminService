package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Admin;
import com.example.service.Adminservice;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	private  Adminservice adminservice;
	
	@Autowired
	public AdminController(Adminservice adminservice)
	{
		this.adminservice = adminservice;
	}
	
	public Adminservice getAdminservice()
	{
		return adminservice;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> addAdmin(@Valid @RequestBody Admin admin)
	{
		Admin a1 = new Admin(admin.getAdminId(),admin.getFirstName(),admin.getLastName(),admin.getEmail(),admin.getAdminname(),admin.getPassword());
		adminservice.registerAdmin(a1);
		return new ResponseEntity<>("Admin register Sucessfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> loginAdmin(@RequestBody Admin admin)
	{
		adminservice.login(admin.getAdminname(), admin.getPassword());
		return new ResponseEntity<>("Admin LogIn Sucessfully",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAdminById(@RequestParam int adminId)
	{
		adminservice.deleteAdmin(adminId);
		return new ResponseEntity<>("Admin Profile Deleted successfully", HttpStatus.ACCEPTED);
	}
}
