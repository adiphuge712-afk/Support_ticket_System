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
@Table(name = "admindetails")
public class Admin {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ad_id;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
	@Column
	private String fullname;
	@Column
	private long contactno;
	@ManyToOne
	@JoinColumn(name="c_id")
	private Customer customer_id;
	  @ManyToOne
	    @JoinColumn(name = "ticket_id")
	    private Tickit ticket;
	
	public Customer getCustomer_id() {
		return customer_id;
	}
	  public void setCustomer_id(Customer customer_id) {
		  this.customer_id = customer_id;
	  }
	  public Tickit getTicket() {
		  return ticket;
	  }
	  public void setTicket(Tickit ticket) {
		  this.ticket = ticket;
	  }
	public long getId() {
		return ad_id;
	}
	public void setId(long ad_id) {
		this.ad_id = ad_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public long getContactno() {
		return contactno;
	}
	public void setContactno(long contactno) {
		this.contactno = contactno;
	}
	
	
}
