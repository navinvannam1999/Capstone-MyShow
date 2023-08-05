package com.ticket.book.service;

import java.util.List;

import com.ticket.book.dto.AdminDTO;
import com.ticket.book.entity.Admin;



public interface IAdminService {
	
public String addAdmin(AdminDTO adminDto);
	
	public List<Admin> getAllAdmin();

}
