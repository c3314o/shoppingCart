package com.learning.spring.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class User {

	@Id
	@SequenceGenerator(name = "USER_DETAIL_SEQ", sequenceName = "USER_DETAIL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_DETAIL_SEQ")
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "USER_PASSWORD")
	private String password;

	@Column(name = "ENABLED")
	private int enabled;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
	private Set<Role> role = new HashSet<Role>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Address> address = new HashSet<Address>();

	public User() {
	}

	public User(int userId, String firstname, String lastname, String username,
			String password, int enabled, Set<Role> role, Set<Address> address) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}
}
