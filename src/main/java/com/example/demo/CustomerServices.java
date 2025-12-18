package com.example.demo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Admin;
import com.models.Complain;
import com.models.Customer;
import com.models.Staff;
import com.models.TicketHistory;
import com.models.Tickit;

@Service
public class CustomerServices {
@Autowired
private Customerrepo cr;
@Autowired
private Complainrepo cmpr;
@Autowired
private Adminrepo adr;
@Autowired
private Satffrepo stffr;
@Autowired
private Tickitrepo ticrp;
@Autowired
private TicketHistoryrepo tichrepo;
public void addCustomer(Customer c) {
	cr.save(c);
}
public Customer sign(String email,String password)
{
	Customer c=cr.findByEmail(email).orElseThrow(()->new RuntimeException("Email not found"));
	if(!c.getPassword().equals(password)) {
		throw new RuntimeException("Password not found");
	}
	return c;
}
public void addComplain(Complain c ,Customer com) {
	
	c.setC_id(com);
	cmpr.save(c);
	/* cmpr.save(ch); */
	
	
}
public List<Complain> viewcomplains() {
	return cmpr.findAll();
}
public List<Complain> viewcomplains(Customer c) {
	
	return cmpr.findByUsername(c.getFullname());
}

public Complain remark(long id, String remark) {
	Complain cs =cmpr.findById(id).orElseThrow(()->new  RuntimeException("id not found"));
	
	cs.setRemark(remark);
	return cmpr.save(cs);
}
public Optional<Complain> data(long id) {
	return cmpr.findById(id);
}
public Admin addminsign(String email,String password) {

	Admin c=adr.findByEmail(email).orElseThrow(()->new RuntimeException("Email not found"));
	if(!c.getPassword().equals(password)) {
		throw new RuntimeException("Password not found");
	}
	return c;
}
public void addStaff(Staff s) {
	stffr.save(s);
}
public List<Staff> viewStaffDetails() {
	return stffr.findAll();
}
public void addticket(Tickit t,long s) {
	Complain c= cmpr.findById(s).orElseThrow(()->new RuntimeException("Id not found"));
	t.setId(c);
	ticrp.save(t);
}
public List<Tickit> viewticket() {
	return ticrp.findAll();
}
public Complain createticket(long id) {
	Complain c= cmpr.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
//	String title=c.getComplaintitle();
	c.getComplaintitle();
	c.getC_id();
	return c;
}
public String asign_ticketById(Long id) {
	Staff s=stffr.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
	String  sname=s.getFullname();
	return sname;
}
public void asign_ticket(long id,long tid,Admin admin) {
	Staff s=stffr.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
	Tickit t=ticrp.findById(tid).orElseThrow(()->new RuntimeException("Id not found"));
	
	//Assign task
	t.setAssign_ticket_staff(s.getFullname());
	t.setSt_id(s);
	t.setUpdated_date(LocalDate.now());
	s.setTicket(t);
	 stffr.save(s);
	 
	 ticrp.save(t);
		
		 Complain complain=t.getId();
		 
		 Customer customer = complain.getC_id(); 
		 complain.setTicket(t);
		 cmpr.save(complain);
		 
	 
	// Save history
	    TicketHistory th = new TicketHistory();
	    th.setAd_id(admin);
	    th.setSt_id(s);
	    th.setTicket(t);
	   th.setUpdatedDate(LocalDate.now());
	   th.setUpdatedBy(admin.getFullname());
		
		 th.setC_id(customer); 
		 th.setId(complain);
		 
	   
	    tichrepo.save(th);
	
}
//tiket histrry
public List<TicketHistory> viewtickethistory(){
	return tichrepo.findAll();
}
public Complain viewComplainByid(long id) {
	return cmpr.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
}
public Optional<Customer> viewComplainhistory(long id){
	
	Complain complain=cmpr.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
	Optional<Customer> idr=Optional.of(complain.getC_id());
	return idr;
	 
}
public Optional<Admin> viewadminById(long id){
	return adr.findById(id);
}
public Optional<Staff> viewstaffById(long id){
	return stffr.findById(id);
}
public Optional<Customer> viewcustomerById(long id){
	return cr.findById(id);
}
public Optional<Tickit> viewtickitById(long id){
	return ticrp.findById(id);
}

public Staff staffsign(String email,String password)
{
	Staff c=stffr.findByEmail(email).orElseThrow(()->new RuntimeException("Email not found"));
	if(!c.getPassword().equals(password)) {
		throw new RuntimeException("Password not found");
	}
	return c;
}
public List<Object> viewtickets(Staff staff,Tickit t) {
	Staff s=stffr.findById(staff.getId()).orElseThrow(()->new RuntimeException("Email not found"));
	Tickit ti=ticrp.findById(t.getTicketId()).orElseThrow(()->new RuntimeException("Id not found"));
	List<Object> list = new ArrayList<>();
	list.add(ti.getStatus());
	list.add(ti.getUpdated_date());
	list.add(ti.getTicketname());
	list.add(ti.getTitle());
	list.add(s.getFullname());
	list.add(s.getId());
	list.add(ti.getTicketId());
	list.add(ti.getRemark());
	return list;

}


public List<Staff> viewAllStaff(){
	return stffr.findAll();
}
public List<Tickit> viewticketsofstaff(Staff staff,Tickit t) {
//	Staff s=stffr.findById(staff.getId()).orElseThrow(()->new RuntimeException("Email not found"));
	List<Tickit> tickets = ticrp.findByStid(staff);
	
	return tickets;

}



//adding the remark on tickit
public void addremarkandstatus(long id,String remark,String status) {
	Tickit ti=ticrp.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
	ti.setStatus(status);
	ti.setRemark(remark);
	ticrp.save(ti);

}	
//}
//public List <TicketHistory> viewdatastaff(Staff staff) {
////	long sid=staff.getId();
//	 List <TicketHistory> list=tichrepo.findAllByStaffId(staff.getId());
//	return  list;
//}

}
