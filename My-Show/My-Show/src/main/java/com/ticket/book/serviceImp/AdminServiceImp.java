package com.ticket.book.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.book.dto.AdminDTO;
import com.ticket.book.entity.Admin;
import com.ticket.book.repository.AdminRepository;
import com.ticket.book.service.IAdminService;

@Service
public class AdminServiceImp implements IAdminService{
	
	@Autowired
	private AdminRepository repo;
	
	@Override
	public String addAdmin(AdminDTO adminDto) {
		
		Admin admin = new Admin();
		admin.setEmail(adminDto.getEmail());
		admin.setPassword(adminDto.getPassword());
		repo.save(admin);
		return "New Admin data saved";
	}
	
	@Override
	public List<Admin> getAllAdmin(){
		
		return repo.findAll();
	}


}
