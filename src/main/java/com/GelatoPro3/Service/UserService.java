package com.GelatoPro3.Service;

import com.GelatoPro3.Entity.User;
import com.GelatoPro3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService
{
	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public void createUser(User user)
	{
		Iterable<User> all = this.userRepository.findAll();
		this.userRepository.save(user);
	}

	public Optional<User> findUserByEMail(String email){
		return this.userRepository.findByEmail(email);
	}

	public boolean login(String email, String pwd)
	{
		Optional<User> user= this.userRepository.findByEmail(email);
		if(! user.isPresent()) return false;
		if(! bCryptPasswordEncoder.matches(pwd,user.get().getPwd())) return false;
		return true;
	}
}
