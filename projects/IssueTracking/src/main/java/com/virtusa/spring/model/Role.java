package com.virtusa.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="ROLE")
public class Role {
	@Id
	@Column(name="ROLE_ID")
	private int roleId;
	@Column(name="ROLE_NAME")
	private String roleName;
	@ManyToMany(/*cascade = CascadeType.ALL*/)
	@JoinTable(name="ROLE_FUNCTIONS",joinColumns={@JoinColumn(name="ROLE_ID")},inverseJoinColumns={@JoinColumn(name="FUNCTION_ID")})
	List<Functions>functions=new ArrayList<Functions>();
	public Role() {
		super();
	}
	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		//this.functions = functions;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<Functions> getFunctions() {
		return functions;
	}
	public void setFunctions(List<Functions> functions) {
		this.functions = functions;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", functions=" + functions + "]";
	}
}
