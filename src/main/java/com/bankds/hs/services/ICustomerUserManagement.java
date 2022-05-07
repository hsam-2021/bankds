package com.bankds.hs.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bankds.hs.model.SignUpForm;
import com.bankds.hs.model.UpdateUserAccount;
import com.bankds.hs.model.UsersData;

public interface ICustomerUserManagement {
	public List<UsersData> getUserDetails();

	public ResponseEntity<String> addUserAccount(SignUpForm signUpRequest);

	public ResponseEntity<String> updateUserDetails(UpdateUserAccount updateUserAccount);
	
	public ResponseEntity<String> deleteUserAccount(String userName);
}
