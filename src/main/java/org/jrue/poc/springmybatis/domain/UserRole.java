package org.jrue.poc.springmybatis.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 489466745786742107L;
	private int roleId;
	private String userID;
	private String role;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
