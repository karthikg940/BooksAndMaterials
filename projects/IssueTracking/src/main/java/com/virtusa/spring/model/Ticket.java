package com.virtusa.spring.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TICKET")
public class Ticket {

@Id
@GeneratedValue
@Column(name="TICKET_ID")
private int ticketId;
@ManyToOne(/*cascade = CascadeType.ALL*/)
@JoinColumn(name="PROJECT_ID",referencedColumnName="PROJECT_ID")
private Project project;
@Column(name="DESCRIPTION")
private String description;
@ManyToOne(/*cascade = CascadeType.ALL*/)
@JoinColumn(name="USER_ID",referencedColumnName="USER_ID")
private User user;
@Temporal(TemporalType.DATE)
@Column(name="RISEDATE")
private Date riseDate;
@OneToMany(/*cascade = CascadeType.ALL*/)
@JoinTable(name="TICKET_CATEGORY",joinColumns={@JoinColumn(name="TICKET_ID")},inverseJoinColumns={@JoinColumn(name="CATEGORY_ID")})
private Set<Category> category=new HashSet<Category>();
@OneToOne(/*cascade = CascadeType.ALL*/)
@JoinColumn(name="PRIORITY_ID",referencedColumnName="PRIORITY_ID")
private Priority priority;
@ManyToMany(/*cascade = CascadeType.ALL*/)
@JoinTable(name="TICKET_USER_DEVELOPER",joinColumns={@JoinColumn(name="TICKET_ID")},inverseJoinColumns={@JoinColumn(name="USER_ID")})
private Set<User> assignDeveloper=new HashSet<User>();
@OneToOne(/*cascade = CascadeType.ALL*/)
@JoinColumn(name="STATUS_ID",referencedColumnName="STATUS_ID")
private Status status;
@Temporal(TemporalType.DATE)
@Column(name="RESOLVEDATE")
private Date resolveDate;
/*@OneToOne()
@JoinColumn(name="PRIORITY_ID",referencedColumnName="file_NAME")
FileUpload file;*/
public Ticket() {
	super();
}

public Ticket(Project project, String description, User user, Date riseDate,
		Priority priority, Set<User> assignDeveloper, Status status,
		Date resolveDate) {
	super();
	this.project = project;
	this.description = description;
	this.user = user;
	this.riseDate = riseDate;
	this.priority = priority;
	this.assignDeveloper = assignDeveloper;
	this.status = status;
	this.resolveDate = resolveDate;
}
public int getTicketId() {
	return ticketId;
}
public void setTicketId(int ticketId) {
	this.ticketId = ticketId;
}
public Project getProject() {
	return project;
}
public void setProject(Project project) {
	this.project = project;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Date getRiseDate() {
	return riseDate;
}
public void setRiseDate(Date riseDate) {
	this.riseDate = riseDate;
}
public Priority getPriority() {
	return priority;
}
public void setPriority(Priority priority) {
	this.priority = priority;
}
public Set<User> getAssignDeveloper() {
	return assignDeveloper;
}
public void setAssignDeveloper(Set<User> assignDeveloper) {
	this.assignDeveloper = assignDeveloper;
}
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public Date getResolveDate() {
	return resolveDate;
}
public void setResolveDate(Date resolveDate) {
	this.resolveDate = resolveDate;
}
public Set<Category> getCategory() {
	return category;
}
public void setCategory(Set<Category> category) {
	this.category = category;
}


@Override
public String toString() {
	return "Ticket [ticketId=" + ticketId + ", project=" + project
			+ ", description=" + description + ", user=" + user + ", riseDate="
			+ riseDate + ", category=" + category + ", priority=" + priority
			+ ", assignDeveloper=" + assignDeveloper + ", status=" + status
			+ ", resolveDate=" + resolveDate + "]";
}
 
 


/*public Ticket(Project project, String description, User user, Date riseDate,
		Priority priority, Status status, Date resolveDate) {
	super();
	this.project = project;
	this.description = description;
	this.user = user;
	this.riseDate = riseDate;
	this.priority = priority;
	this.status = status;
	this.resolveDate = resolveDate;
}
public int getTicketId() {
	return ticketId;
}
public void setTicketId(int ticketId) {
	this.ticketId = ticketId;
}
public Project getProject() {
	return project;
}
public void setProject(Project project) {
	this.project = project;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Date getRiseDate() {
	return riseDate;
}
public void setRiseDate(Date riseDate) {
	this.riseDate = riseDate;
}
public Priority getPriority() {
	return priority;
}
public void setPriority(Priority priority) {
	this.priority = priority;
}
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public Date getResolveDate() {
	return resolveDate;
}
public void setResolveDate(Date resolveDate) {
	this.resolveDate = resolveDate;
}
@Override
public String toString() {
	return "Ticket [ticketId=" + ticketId + ", project=" + project
			+ ", description=" + description + ", user=" + user + ", riseDate="
			+ riseDate + ", priority=" + priority + ", status=" + status
			+ ", resolveDate=" + resolveDate + "]";
}

*/
}
