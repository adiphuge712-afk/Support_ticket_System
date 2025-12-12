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
@Table(name="complaindetails")
public class Complain {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "ticket_id")
	private Tickit ticket;
	public Tickit getTicket() {
		return ticket;
	}
	public void setTicket(Tickit ticket) {
		this.ticket = ticket;
	}
	public Customer getC_id() {
		return c_id;
	}
	public void setC_id(Customer c_id) {
		this.c_id = c_id;
	}
	@ManyToOne
	@JoinColumn(name = "c_id")
	private Customer c_id;
	@Column(unique=true)
	private String complaintitle;
	@Column
	private String complaindiscreption;
	@Column
	private String username;
	
	@Column
	private String remark;
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getComplaintitle() {
		return complaintitle;
	}
	public void setComplaintitle(String complaintitle) {
		this.complaintitle = complaintitle;
	}
	public String getComplaindiscreption() {
		return complaindiscreption;
	}
	public void setComplaindiscreption(String complaindiscreption) {
		this.complaindiscreption = complaindiscreption;
	}

}
