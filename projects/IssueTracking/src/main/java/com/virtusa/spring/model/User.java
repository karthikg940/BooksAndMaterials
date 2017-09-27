//package com.virtusa.spring.model;
//
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
// 
//
//@Entity
//@Table(name="USER_DETAILS")
//public class User {
//
//	@Id
//	@GeneratedValue()
//	@Column(name="USER_ID")
//	private int userId;
//	
//	@Column(name="FULLNAME")
//	private String fullName;
//	
//	@Column(name="EMAIL")
//	private String email;
//	
//	@Column(name="USERNAME")
//	private String userName;
//	
//	@Column(name="PASSWORD")
//	private String password;
//	
//	@Column(name="PHONENUMBER")
//	private long phoneNumber;
//	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="ROLE_ID",referencedColumnName="ROLE_ID")
//	private Role role;
//
//	public User() {
//		super();
//	}
//
//	public User(String fullName, String email, String userName,
//			String password, long phoneNumber, Role role) {
//		super();
//		this.fullName = fullName;
//		this.email = email;
//		this.userName = userName;
//		this.password = password;
//		this.phoneNumber = phoneNumber;
//		this.role = role;
//	}
//
//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public String getFullName() {
//		return fullName;
//	}
//
//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public long getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(long phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
//
//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", fullName=" + fullName + ", email="
//				+ email + ", userName=" + userName + ", password=" + password
//				+ ", phoneNumber=" + phoneNumber + ", role=" + role + "]";
//	}
//	
//	 
//}

package com.virtusa.spring.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
 

@Entity
@Table(name="USER_DETAILS")
public class User{

	/**
	 * 
	 */
	@Id
	@GeneratedValue()
	@Column(name="USER_ID")
	private int userId;
	@NotEmpty(message="Full Name shouldn't be empty")
	@Size(min=2,max=20,message="Full Name must be in between 2 to 15 characters")
	@Column(name="FULLNAME")
	private String fullName;
	
	@NotEmpty(message="Email shouldn't be empty")
//	@Pattern(regexp=".+@.+\\.[a-z]+")
	@Email
	@Column(name="EMAIL")
	private String email;
	
	@NotEmpty(message="User Name shouldn't be empty")
	@Size(min=5,max=20,message="User Name must be in between 5 to 15 characters")
	@Column(name="USERNAME")
	private String userName;
	
	@NotEmpty(message = "Please enter your password.")
    @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	@Column(name="PASSWORD")
	private String password;
	
    @NotNull(message = "Please enter your phoneNumber")
	@Column(name="PHONENUMBER")
	private long phoneNumber;
	
	@ManyToOne(/*cascade = CascadeType.ALL*/)
	@JoinColumn(name="ROLE_ID",referencedColumnName="ROLE_ID")
	/*@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="USER_PROJECTS",joinColumns={@JoinColumn(name="USER_ID")},inverseJoinColumns={@JoinColumn(name="PROJECT_ID")})
	Set<Project>projects=new HashSet<Project>();*/
	private Role role;
	@ManyToMany(/*cascade = CascadeType.ALL*/)
	@JoinTable(name="TICKET_USER_DEVELOPER",joinColumns={@JoinColumn(name="USER_ID")},inverseJoinColumns={@JoinColumn(name="TICKET_ID")})
	private Set<Ticket>developerTickets=new HashSet<Ticket>();
	public User() {
		super();
	}

	public User(String fullName, String email, String userName,
			String password, long phoneNumber, Role role) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Set<Ticket> getDeveloperTickets() {
		return developerTickets;
	}

	public void setDeveloperTickets(Set<Ticket> developerTickets) {
		this.developerTickets = developerTickets;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", email="
				+ email + ", userName=" + userName + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", role=" + role + "]";
	}
	
	 
}

