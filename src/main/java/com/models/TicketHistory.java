package com.models;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class TicketHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Tickit ticket;
    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Admin ad_id;
    @ManyToOne
    @JoinColumn(name = "st_id")
    private Staff st_id;
   
    @ManyToOne
    @JoinColumn(name = "c_id")
    private Customer c_id;
    @ManyToOne
    @JoinColumn(name = "id")
    private Complain id;
	public Customer getC_id() {
		return c_id;
	}

	public void setC_id(Customer c_id) {
		this.c_id = c_id;
	}

	public Complain getId() {
		return id;
	}

	public void setId(Complain id) {
		this.id = id;
	}

	@Column
    private String updatedBy;
    @Column(name="updated_date")
    private LocalDate updatedDate;
   
    
    public Staff getSt_id() {
		return st_id;
	}

	public void setSt_id(Staff st_id) {
		this.st_id = st_id;
	}
    public TicketHistory() {
        this.updatedDate = LocalDate.now();
    }

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public Tickit getTicket() {
		return ticket;
	}

	public void setTicket(Tickit ticket) {
		this.ticket = ticket;
	}

	

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}


	public Admin getAd_id() {
		return ad_id;
	}

	public void setAd_id(Admin ad_id) {
		this.ad_id = ad_id;
	}
    
}

