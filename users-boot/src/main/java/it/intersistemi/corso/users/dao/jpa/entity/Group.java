package it.intersistemi.corso.users.dao.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the GROUPS database table.
 *
 */
@Entity
@Table(name="GROUPS")
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GROUP_NAME", unique=true, nullable=false, length=50)
	private String groupName;

	@Column(nullable=false, length=200)
	private String description;

	//bi-directional many-to-many association to Authority
	@ManyToMany
	@JoinTable(
		name="GROUP_AUTHORITIES"
		, joinColumns={
			@JoinColumn(name="GROUP_NAME", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="AUTHORITY", nullable=false)
			}
		)
	private Set<Authority> authorities;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="groups")
	private Set<User> users;

	public Group() {
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Authority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}