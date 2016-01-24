package com.learning.spring.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class Role {

	@Id
	@SequenceGenerator(name = "USER_ROLE_SEQ", sequenceName = "USER_ROLE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ROLE_SEQ")
	@Column(name = "USER_ROLE_ID")
	private int userRoleId;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "ROLE")
	private String role;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User userId;

	public Role() {
	}

	public Role(int userRoleId, String username, String role, User userId) {
		super();
		this.userRoleId = userRoleId;
		this.username = username;
		this.role = role;
		this.userId = userId;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

}
