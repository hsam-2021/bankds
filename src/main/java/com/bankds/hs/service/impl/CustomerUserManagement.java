package com.bankds.hs.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bankds.hs.model.Role;
import com.bankds.hs.model.RoleName;
import com.bankds.hs.model.SignUpForm;
import com.bankds.hs.model.UpdateUserAccount;
import com.bankds.hs.model.User;
import com.bankds.hs.model.UsersData;
import com.bankds.hs.repository.RoleRepository;
import com.bankds.hs.repository.UserRepository;
import com.bankds.hs.services.ICustomerUserManagement;

@Component
public class CustomerUserManagement implements ICustomerUserManagement {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<UsersData> getUserDetails() {
		List<UsersData> userDetailsArrayList = null;
		UsersData usersData = null;
		List<User> getUserDetails = userRepository.findAll();
		if (null != getUserDetails && !getUserDetails.isEmpty()) {
			userDetailsArrayList = new ArrayList<UsersData>();
			for (User getUserDetailsObj : getUserDetails) {
				usersData = new UsersData();
				usersData.setName(getUserDetailsObj.getName());
				usersData.setUserName(getUserDetailsObj.getUsername());
				usersData.setUserId(getUserDetailsObj.getId());
				usersData.setPassword(getUserDetailsObj.getPassword());
				usersData.seteMail(getUserDetailsObj.getEmail());
				for (Role role : getUserDetailsObj.getRoles()) {
					usersData.setRoleId(role.getId());
					usersData.setRoleName(role.getName().toString());
				}
				userDetailsArrayList.add(usersData);
			}
		}
		return userDetailsArrayList;
	}

	@Override
	public ResponseEntity<String> addUserAccount(SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<String>("Fail -> Username is already taken!", HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<String>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<Role>();

		strRoles.forEach(role -> {
			switch (role) {
			case "ROLE_ADMIN":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "ROLE_SUPER_ADMIN":
				Role pmRole = roleRepository.findByName(RoleName.ROLE_SUPER_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok().body("User registered successfully!");
	}

	@Override
	@Transactional
	public ResponseEntity<String> updateUserDetails(UpdateUserAccount updateUserAccount) {
		if (userRepository.existsByUsername(updateUserAccount.getUsername()) && (userRepository
				.countExistingUserNameForUpdate(updateUserAccount.getUsername(), updateUserAccount.getId())) == 0) {
			return new ResponseEntity<String>("Fail -> Username is already taken!", HttpStatus.BAD_REQUEST);
		}
		if (userRepository.existsByEmail(updateUserAccount.getEmail()) && (userRepository
				.countExistingUserEmailForUpdate(updateUserAccount.getEmail(), updateUserAccount.getId())) == 0) {
			return new ResponseEntity<String>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
		}
		User user = new User();
		user.setId(updateUserAccount.getId());
		user.setName(updateUserAccount.getName());
		user.setUsername(updateUserAccount.getUsername());
		if ((userRepository.getPassword(updateUserAccount.getId()).equals(updateUserAccount.getPassword()))) {
			user.setPassword(updateUserAccount.getPassword());
		} else {
			user.setPassword(encoder.encode(updateUserAccount.getPassword()));
		}
		user.setEmail(updateUserAccount.getEmail());

		Set<String> strRoles = updateUserAccount.getRole();
		Set<Role> roles = new HashSet<Role>();
		strRoles.forEach(role -> {
			switch (role) {
			case "ROLE_ADMIN":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "ROLE_SUPER_ADMIN":
				Role pmRole = roleRepository.findByName(RoleName.ROLE_SUPER_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});
		user.setRoles(roles);
		em.merge(user);
		return ResponseEntity.ok().body("User account updated successfully!");
	}

	@Override
	public ResponseEntity<String> deleteUserAccount(String userName) {
		long userId = -1;
		userId = userRepository.findUserId(userName);
		if (userId > 0) {
			userRepository.deleteById(userId);
		} else {
			return new ResponseEntity<String>("Fail -> Username does't exist!", HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body("User account deleted successfully!");
	}
}
