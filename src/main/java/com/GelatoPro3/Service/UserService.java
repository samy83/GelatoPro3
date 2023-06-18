package com.GelatoPro3.Service;

import com.GelatoPro3.Entity.User;
import com.GelatoPro3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	@Autowired
	UserRepository userRepository;

	public void createUser(User user)
	{
		Iterable<User> all = this.userRepository.findAll();
		this.userRepository.save(user);
	}

}
