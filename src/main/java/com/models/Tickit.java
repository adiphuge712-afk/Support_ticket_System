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
public class Tickit {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long ticketId;
	    @Column
	    private String title;
	    @Column(name="assign_ticket_staff")
	    private String assignticketstaff;
	    @ManyToOne
	    @JoinColumn(name = "st_id")
	    private Staff stid;
	    public Staff getSt_id() {
			return stid;
		}

		public void setSt_id(Staff stid) {
			this.stid = stid;
		}
		@Column
	    private LocalDate updated_date;
	    public LocalDate getUpdated_date() {
			return updated_date;
		}

		public void setUpdated_date(LocalDate updated_date) {
			this.updated_date = updated_date;
		}

		public String getAssign_ticket_staff() {
			return assignticketstaff;
		}

		public void setAssign_ticket_staff(String assignticketstaff) {
			this.assignticketstaff = assignticketstaff;
		}
		 @ManyToOne
		    @JoinColumn(name = "id")
		    private Complain id;

		public Complain getId() {
			return id;
		}

		 public void setId(Complain id) {
			 this.id = id;
		 }
		@Column(length = 500)
	    private String ticketname;

		@Column
	    private LocalDate created_date;
	    @Column
	    private String status; // OPEN, ASSIGNED, IN_PROGRESS, RESOLVED, CLOSED
	    @Column
	    private String remark;
	    public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		// Constructor
	    public Tickit() {
	        this.created_date = LocalDate.now();
	        this.status = "OPEN";
	    }

	    public Long getTicketId() {
			return ticketId;
		}

		public void setTicketId(Long ticketId) {
			this.ticketId = ticketId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getTicketname() {
			return ticketname;
		}

		public void setTicketname(String ticketname) {
			this.ticketname = ticketname;
		}

		public LocalDate getCreatedDate() {
			return created_date;
		}

		public void setCreatedDate(LocalDate created_date) {
			this.created_date = created_date;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	}

	


