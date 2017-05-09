package org.PickMePetStore.controller;

import org.PickMePetStore.controller.response.SignupResponse;
import org.PickMePetStore.persistence.model.UserModel;
import org.PickMePetStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
@RequestMapping("/signup")
public class SignUpController {

	@Autowired
	private UserService userService;

	@PostMapping
	public SignupResponse processNewUserFrom(@RequestBody UserModel newUser) {
		userService.createUser(newUser);
		SignupResponse response = new SignupResponse();
		response.setMessage("Thank you for registering. Please confirm your email within 1 day. You may proceed to login");
		response.setStatus(200);
		return response;
	}
	
}
