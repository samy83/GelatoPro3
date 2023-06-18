package com.GelatoPro3.Mapper;

import com.GelatoPro3.Entity.User;
import com.GelatoPro3.Form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserMapper
{
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public User userFormToUser(UserForm form){
		User newUser = new User();
		newUser.setPrenom(form.getPrenom());
		newUser.setNom(form.getNom());
		newUser.setPwd(bCryptPasswordEncoder.encode(form.getPwd()));
		newUser.setEmail(form.getEmail());
		newUser.setPays(form.getPays());
		//newUser.setId(123L);
		return newUser;
	}
}
