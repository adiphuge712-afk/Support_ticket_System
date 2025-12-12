package com.models;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;


@Entity
public class TicketAssign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignId;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Tickit ticket;
    @ManyToOne
    @JoinColumn(name = "st_id")
    private Staff staffId;
    @Column
    private LocalDateTime assignedDate;
    @Column
    private LocalDateTime releasedDate;
    @Column
    private boolean active; // True = currently assigned

    public TicketAssign() {
        this.assignedDate = LocalDateTime.now();
        this.active = true;
    }

	public Long getAssignId() {
		return assignId;
	}

	public void setAssignId(Long assignId) {
		this.assignId = assignId;
	}

	public Tickit getTicket() {
		return ticket;
	}

	public void setTicket(Tickit ticket) {
		this.ticket = ticket;
	}

	public Staff getStaffId() {
		return staffId;
	}

	public void setStaffId(Staff staffId) {
		this.staffId = staffId;
	}

	public LocalDateTime getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDateTime assignedDate) {
		this.assignedDate = assignedDate;
	}

	public LocalDateTime getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(LocalDateTime releasedDate) {
		this.releasedDate = releasedDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
    

}
