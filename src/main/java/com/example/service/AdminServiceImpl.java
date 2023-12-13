package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.example.Entity.Admin;
import com.example.Repositiory.AdminRepositiory;


import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Service
public class AdminServiceImpl implements Adminservice{
 
	@Autowired
	private AdminRepositiory adminrepo;
	

	public void setAdminrepoAdminRepositiory (AdminRepositiory adminrepo)
	{
		this.adminrepo = adminrepo;
	}
	
	
	@Override
	public void registerAdmin(Admin admin) throws IllegalArgumentException
	{
		if(adminrepo.existsByAdminname(admin.getAdminname()))
		{
			throw new IllegalArgumentException("Admin already present");
		}
		adminrepo.save(admin);
	}


	@Override
	public void login(String adminname, String password) throws IllegalArgumentException
	{
		if (!adminrepo.existsByAdminname(adminname)) 
		{
		    throw new IllegalArgumentException("Admin does not exist");
		}
		Admin existingAdmin =  adminrepo.findByAdminname(adminname);
		if(!existingAdmin.getPassword().equals(password))
		{
			throw new IllegalArgumentException("Incorrect Password");
		}
	}
	
	@Override
	public void deleteAdmin(int adminId) {
		Optional<Admin> admin =adminrepo.findById(adminId);
		if (admin.isPresent())
		{
			adminrepo.deleteById(adminId);
		}
		else
		{
			throw new IllegalArgumentException("Admin does not exist");
		}
		
	}
}
