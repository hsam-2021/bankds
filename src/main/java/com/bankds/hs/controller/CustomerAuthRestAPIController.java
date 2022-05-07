package com.bankds.hs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bankds.hs.model.SignUpForm;
import com.bankds.hs.model.UpdateUserAccount;
import com.bankds.hs.model.UsersData;
import com.bankds.hs.repository.RoleRepository;
import com.bankds.hs.repository.UserRepository;
import com.bankds.hs.services.ICustomerUserManagement;

@CrossOrigin
@RestController
@RequestMapping("/customer/v1")
@ResponseBody
public class CustomerAuthRestAPIController {
	
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ICustomerUserManagement UserManagement;
	
	@PostMapping("/api/auth/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		return UserManagement.addUserAccount(signUpRequest);
	}

	@RequestMapping(value = "/getUsersDetail", method = RequestMethod.GET)
	public List<UsersData> getUsersDetail() {
		return UserManagement.getUserDetails();
	}

	@RequestMapping(value = "/deleteUsersDetail/{userName}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUserAccount(@PathVariable("userName") String userName) {
		return UserManagement.deleteUserAccount(userName);
	}

	@PostMapping("/updateUserDetails")
	public ResponseEntity<String> updateUserDetails(@Valid @RequestBody UpdateUserAccount updateUserAccount) {
		return UserManagement.updateUserDetails(updateUserAccount);
	}


}
