package com.bankds.hs.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bankds.hs.model.Role;
import com.bankds.hs.model.RoleName;
import com.bankds.hs.model.User;
import com.bankds.hs.repository.RoleRepository;
import com.bankds.hs.repository.UserRepository;

@Component
public class BankDsUtil {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@EventListener
	public void loadInitialLoginData(ApplicationReadyEvent event) {
		if (roleRepository.count() == 0) {
			Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
			Role roleSuperAdmin = new Role(RoleName.ROLE_SUPER_ADMIN);
			Role roleUser = new Role(RoleName.ROLE_USER);
			roleRepository.save(roleAdmin);
			roleRepository.save(roleUser);
			roleRepository.save(roleSuperAdmin);
			User userAdmin = new User("hs_admin", "hs_admin", "hs_admin@bankds.com", passwordEncoder.encode("hs4703"));
			User userReader = new User("pr_user", "pr_user", "hs_user@bankds.com", passwordEncoder.encode("hs4703"));
			Set<Role> adminRoles = new HashSet<Role>();
			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			adminRoles.add(adminRole);
			userAdmin.setRoles(adminRoles);
			Set<Role> superAdminRoles = new HashSet<Role>();
			Role superAdminRole = roleRepository.findByName(RoleName.ROLE_SUPER_ADMIN)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			superAdminRoles.add(superAdminRole);

			Set<Role> userRoles = new HashSet<Role>();
			Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			userRoles.add(userRole);
			userReader.setRoles(userRoles);
			userRepository.save(userAdmin);
			userRepository.save(userReader);

		}

	}
}
