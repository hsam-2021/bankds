package com.bankds.hs.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UsersData implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userId;
	private String name;
	private String userName;
	private String eMail;
	private String password;
	private Long roleId;
	private String roleName;

	public UsersData() {

	}

	public UsersData(Long userId, String name, String userName, String eMail, String password, Long roleId,
			String roleName) {
		this.userId = userId;
		this.userName = userName;
		this.eMail = eMail;
		this.password = password;
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
