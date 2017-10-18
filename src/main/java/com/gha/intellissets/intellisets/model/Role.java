package com.gha.intellissets.intellisets.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author edwin.njeru
 *
 */
@Entity
public class Role extends AbstractDomainClass {
	
	private String role;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable
	private List<User> users = new ArrayList<>();

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	public void addUser(User user) {
		
		if(!this.users.contains(user)) {
			this.users.add(user);
		}
		
		if(!user.getRoles().contains(this)) {
			user.getRoles().add(this);
		}
	}
	
	public void removeUser(User user) {
		this.users.remove(user);
		user.getRoles().remove(this);
	}
	
}
