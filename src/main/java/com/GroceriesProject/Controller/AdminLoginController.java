package com.GroceriesProject.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.GroceriesProject.Model.Admin;
import com.GroceriesProject.Service.AdminService;



@Controller
public class AdminLoginController {
	
@Autowired
private AdminService as;
	

@RequestMapping("adminLogin")
public String adminLogin(@RequestParam("adminUsername") String user, @RequestParam("adminPassword") String pass,HttpServletRequest req) {
	
            if(as.adminLogin(user,pass)){
  	                   HttpSession ses=req.getSession();
  	                   ses.setAttribute("admin",user);
                    	   return "home";
                    	   
                       }
                    return null;  
 
}
@RequestMapping("viewAdmin")
public String viewAdmin(HttpServletRequest req,Model m) {
	HttpSession ses=req.getSession();
      String user=(String) ses.getAttribute("admin");
	Admin admin=as.viewAdmin(user);
	m.addAttribute("show", admin);
	return "view";
  


}
@RequestMapping("updateAdmin")
public String updateAdmin(Admin a) {
	 as.updateAdmin(a);
	 return "login";
	

}
}
