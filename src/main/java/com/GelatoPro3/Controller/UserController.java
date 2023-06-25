package com.GelatoPro3.Controller;

import com.GelatoPro3.Form.UserForm;
import com.GelatoPro3.Mapper.UserMapper;
import com.GelatoPro3.Service.MailService;
import com.GelatoPro3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@RequestMapping("/api/user")
@RestController
public class UserController
{
	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private MailService mailService;

	@PostMapping(path= "/", consumes = {"multipart/form-data"})
	public void createUser(@ModelAttribute UserForm formUser){
		this.userService.createUser(userMapper.userFormToUser(formUser));
	}

	@GetMapping(path="/{id}")
	public void getUser(@PathVariable String email){
		this.userService.findUserByEMail(email);
	}

	@GetMapping(path="/login/{email}/{pwd}")
	public boolean login(@PathVariable String email, @PathVariable String pwd){
		return this.userService.login(email, pwd);
	}

	@GetMapping("/mail")
	public void sendMail()
	{
		mailService.sendMail();
	}
}
