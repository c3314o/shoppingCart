package com.learning.spring.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "USER_DETAILS")
public class User {

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false)
	private int userId;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	/*
	 * @Column(name = "USERNAME") private String username;
	 * 
	 * @Column(name = "USER_PASSWORD") private String password;
	 */

	/*
	 * @Column(name = "PHONE") private String phone;
	 * 
	 * @Column(name = "EMAIL") private String email;
	 */

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") private
	 * Set<Address> address = new HashSet<Address>(0);
	 */

	public User() {
	}

	public User(int userId, String firstname, String lastname, String phone,
			String email) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
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

}
