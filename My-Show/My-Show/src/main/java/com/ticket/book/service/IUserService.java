package com.ticket.book.service;

import java.util.List;

import com.ticket.book.dto.UserDTO;
import com.ticket.book.entity.User;


public interface IUserService {
	   public String addUser(UserDTO userDto);
		
		public List<User> getAllUser();
		
		public String updateUser(UserDTO userDto);
		
		public User getUserById(long id);
		
		public String deleteUser(long id);

}
