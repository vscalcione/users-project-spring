package it.intersistemi.corso.users.dao.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the AUTHORITIES database table.
 *
 */
@Entity
@Table(name="AUTHORITIES")
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=50)
	private String authority;

	@Column(nullable=false, length=200)
	private String description;

	//bi-directional many-to-many association to Group
	@ManyToMany(mappedBy="authorities")
	private Set<Group> groups;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="authorities")
	private Set<User> users;

	public Authority() {
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Group> getGroups() {
		return this.groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}