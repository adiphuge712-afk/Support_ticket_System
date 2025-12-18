package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.models.Admin;
import com.models.Complain;
import com.models.Customer;
import com.models.Staff;
import com.models.TicketHistory;
import com.models.Tickit;

import jakarta.servlet.http.HttpSession;



@Controller
public class MyController {

	@Autowired
	private CustomerServices cs;

 
	@GetMapping("/")
	public String home() {
		return "home";// home.jsp
		//internalresourseviewer is set to the application.propertiesfile
	}
	@GetMapping("/login")
	public String login() {
		return "login";// home.jsp
		//internalresourseviewer is set to the application.propertiesfile
	}
	@GetMapping("/register")
	public String register() {
		return "register";// home.jsp
		//internalresourseviewer is set to the application.propertiesfile
	}
	@GetMapping("/stafflogin")
	public String staff() {
		return "stafflogin";// home.jsp
		//internalresourseviewer is set to the application.propertiesfile
	}
	@GetMapping("/adminlogin")
	public String admin() {
		return "adminlogin";// home.jsp
		//internalresourseviewer is set to the application.propertiesfile
	}
	@GetMapping("/forgotpass")
	public ModelAndView fpass() {
		ModelAndView mv=new ModelAndView();
		 mv.setViewName("forgotpassword");
		 return mv;
	}
	@PostMapping("/cregister")
	public String clogin(@ModelAttribute Customer c) {
		cs.addCustomer(c);
		return "redirect:/register";
	}
	@PostMapping("/clogin")
	public String cloging(@RequestParam String email,@RequestParam String password,HttpSession session) {
		try {
			Customer c=cs.sign(email,password);
			session.setAttribute("cuser", c);
			return "redirect:/dashboard";
		} catch (Exception e) {
			
			e.printStackTrace();
			return "redirect:/login";
		}
		
	}
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		if(session.getAttribute("cuser")==null) {
			return "redirect:/login";
		}
		return "cdashboard";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	@GetMapping("/updatecomplain")
	public String updatecomplain(HttpSession session) {
		if(session.getAttribute("cuser")==null) {
			return "redirect:/login";
		}
		return "customer_complain";
	}
	@GetMapping("/viewComplain")
	public ModelAndView viewcomplain(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		if(session.getAttribute("cuser")==null) {
			
			  mv.setViewName("redirect:/login");
		}
		else {
			Customer c=(Customer) session.getAttribute("cuser");
			List<Complain> list=cs.viewcomplains(c);
			
			mv.addObject("list", list);
			mv.setViewName("viewComplain");
		}
		return mv;
	}
	@PostMapping("/complainform")
	public String complainform(@ModelAttribute Complain cm,HttpSession session,Model m) {
		try {
			if(session.getAttribute("cuser")==null) {
				return "redirect:/login";
			}
			Customer c=(Customer) session.getAttribute("cuser");
			
			
			cs.addComplain(cm,c);
			
			return "redirect:/viewComplain";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		
	}
	@GetMapping("/remark/{id}")
	public String remark(@PathVariable long id,Model m,HttpSession session) {
		try {
			if(session.getAttribute("cuser")==null) {
				return "redirect:/login";
			}
			Optional<Complain> c=cs.data(id);
			m.addAttribute("com",c.get());
			
			
			return "remark";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	@PostMapping("/addremark")
	public String addremark(@RequestParam long id, @RequestParam String remark,Model m,HttpSession session) {
		if(session.getAttribute("cuser")==null) {
			return "redirect:/login";
		}
		m.addAttribute("remark", remark);
		cs.remark(id,remark);
		return "redirect:/viewComplain";
	}
	
	@PostMapping("/admin_login")
	public String addminsign(@RequestParam String email,@RequestParam String password,HttpSession session) {
		try {
			Admin a=cs.addminsign(email,password);
			session.setAttribute("auser", a);
			return "redirect:/admin_dashboard";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/adminlogin";
		}
		
	}
	@GetMapping("/admin_dashboard")
	public String dashboard_admin(HttpSession session) {
		if(session.getAttribute("auser")==null) {
			return "redirect:/adminlogin";
		}
		return "admin_dashboard";
	}
	@GetMapping("/admin_logout")
	public String addmin_logout(HttpSession session) {
		session.invalidate();
		return "redirect:/adminlogin";
	}
	@GetMapping("/stafff_register")
	public String staff_register(HttpSession session) {
		if(session.getAttribute("auser")==null) {
			return "redirect:/adminlogin";
		}
	return "staff_register";
	}
	@PostMapping("/staff_register")
	public String ad_register(@ModelAttribute Staff c,Model m,HttpSession session) {
		try {
			if(session.getAttribute("auser")==null) {
				return "redirect:/adminlogin";
			}
			cs.addStaff(c);
			m.addAttribute("successfullly register");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute(" fail");
		}
		return "redirect:/stafff_register";
	}
	@GetMapping("/view_staff_details")
	public String view_staff_details(Model m,HttpSession session) {
		if(session.getAttribute("auser")==null) {
			return "redirect:/adminlogin";
		}
		List<Staff> list=cs.viewStaffDetails();
		List<TicketHistory> his=cs.viewtickethistory();
		m.addAttribute("list", list);
		m.addAttribute("his", his);
	return "staff_details";
	}
	@GetMapping("/create_ticket")
	public String create_ticket(HttpSession session) {
		if(session.getAttribute("auser")==null) {
			return "redirect:/adminlogin";
		}
		return "create_ticket";
	}
	@PostMapping("/add_ticket")
	public String addticket(@ModelAttribute Tickit t,@RequestParam long id,HttpSession session)
	{if(session.getAttribute("auser")==null) {
		return "redirect:/adminlogin";
	}
		Complain s=cs.viewComplainByid(id);
		cs.addticket(t,s.getId());
		return "redirect:/create_ticket";
	}
	@GetMapping("/view_ticket")
	public String view_ticket(Model m,HttpSession session) {
		if(session.getAttribute("auser")==null) {
			return "redirect:/adminlogin";
		}
		List<Tickit> list=cs.viewticket();
		m.addAttribute("list", list);
		return "view_ticket";
	}
	@GetMapping("/viewComplain_admin")
	public ModelAndView viewComplain_admin(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		if(session.getAttribute("auser")==null) {
			mv.setViewName("redirect:/adminlogin");
		}
		else {
		List<Complain> list=cs.viewcomplains();
		mv.addObject("list", list);
		mv.setViewName("viewComplain_admin");
		}
		return mv;
		
	}
	@GetMapping("/create_ticket/{id}")
	public String create_ticket(@PathVariable long id,Model m,HttpSession session) {
		try {
			if(session.getAttribute("auser")==null) {
				return "redirect:/adminlogin";
			}
			
			Complain s=cs.createticket(id);
			m.addAttribute("com",s);
			
			
			return "create_ticket";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	@GetMapping("/asign_ticket/{st_id}")
	public String asign_ticket(@PathVariable long st_id,Model m,HttpSession session) {
		try {
			if(session.getAttribute("auser")==null) {
				return "redirect:/adminlogin";
			}
			List<Tickit> t=cs.viewticket();
			List<Staff>lis= cs.viewAllStaff();
			m.addAttribute("st", lis);
			System.out.println("tickit size is: "+t.size());
			m.addAttribute("tic", t);
			m.addAttribute("sid",st_id);
			String s=cs.asign_ticketById(st_id);
			m.addAttribute("sname",s);
			
			
			return "asignticket";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	@PostMapping("/assign_ticket_admin")
	public String assignticket(@RequestParam long st_id,@RequestParam String fullname,@RequestParam long ticket_id,Model m,HttpSession session) {
		
			if(session.getAttribute("auser")==null) {
				return "redirect:/adminlogin";
			}
		Admin admin = (Admin) session.getAttribute("auser");
		List<Tickit> list=cs.viewticket();
		m.addAttribute("tickets", list);
		cs.asign_ticket(st_id,ticket_id,admin);
		return "asignticket";
	}
	@GetMapping("/viewticketshistory")
	public String viewtickethistory(Model m,HttpSession session) {
		
			if(session.getAttribute("auser")==null) {
				return "redirect:/adminlogin";
			}
		List<TicketHistory> history;
		try {
			history = cs.viewtickethistory();
			 System.out.println("TicketHistory List: " + history.size()); // Debug
			m.addAttribute("list", history);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "viewtickethistory";
	
	}
	
	@PostMapping("/staff_sign")
	public String staffsign(@RequestParam String email,@RequestParam String password,Model m,HttpSession session) {
		try {
		Staff s=cs.staffsign(email,password);
			session.setAttribute("suser", s);
			return "redirect:/staff_dashboard";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/stafflogin";
		}
		
		
		
	}
	
	@GetMapping("/staff_dashboard")
	public String staffdashboard(HttpSession session) {
		
		try {
			if(session.getAttribute("suser")!=null) {
			return "staff_dashboard";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return "redirect:/stafflogin";
	}
	@GetMapping("/staff_logout")
	public String stafflogout(HttpSession session) {
		session.invalidate();
		return "redirect:/stafflogin";
	}

	
	@GetMapping("/view_assignticket")
	public String viewassignticket(HttpSession session,Model m) {
		if(session.getAttribute("suser")==null) {
			return "redirect:/stafflogin";
		}else {
			Staff staff = (Staff) session.getAttribute("suser");
			Tickit t=staff.getTicket();
			List<Tickit> list=cs.viewticketsofstaff(staff,t);
			System.out.println(list);
			m.addAttribute("stafftickets", list);
			System.out.println(list);
			return "view_tickits_ofstaffbyhistory";
			
		}
}
	
	
	
	@GetMapping("/addremarkandstatus/{id}")
	public String addremarkstatus(@PathVariable long id,HttpSession session,Model m) {
		if (session.getAttribute("suser")!=null) {
			try {
				
				Optional<Tickit> list=cs.viewtickitById(id);
				m.addAttribute("ticdata", list.get());
				return "tikitupdate";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/stafflogin";
		
	}
	@PostMapping("/updatestatus")
	public String addstatusremark(HttpSession session,@RequestParam String remark,@RequestParam String status,@RequestParam long id) {
		
			if (session.getAttribute("suser")!=null) {
				cs.addremarkandstatus(id, remark, status);
				return "redirect:/view_assignticket";
			}else {
				return "redirect:/stafflogin";
			}
		
	}
	@GetMapping("/addremarkandstatusadmin/{id}")
	public String addadminremark(@PathVariable long id,HttpSession session,Model m) {
		if(session.getAttribute("auser")==null) {
			return "redirect:/adminlogin";
		}else {
			
			Optional<Tickit> list=cs.viewtickitById(id);
			m.addAttribute("ticdata", list.get());
			return "tickitupdateadmin";
		}
		
	}
	@PostMapping("/updatestatusadmin")
	public String addstatusremarkadmin(HttpSession session,@RequestParam String remark,@RequestParam String status,@RequestParam long id) {
		
		if (session.getAttribute("auser")!=null) {
			cs.addremarkandstatus(id, remark, status);
			return "redirect:/view_staff_details";
		}else {
			return "redirect:/adminlogin";
		}
	
}
	
}
