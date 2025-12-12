package com.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="customerdetails")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long c_id;
	@Column
	private String fullname;
	@Column(unique=true)
	private String email;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Tickit ticket;
	public Tickit getTicket() {
		return ticket;
	}
	public void setTicket(Tickit ticket) {
		this.ticket = ticket;
	}
	public Long getId() {
		return c_id;
	}
	public void setId(Long c_id) {
		this.c_id = c_id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(unique=true)
	private String contactno;
	@Column
	private String password;

}
