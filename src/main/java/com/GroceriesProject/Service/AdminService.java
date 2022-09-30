package com.GroceriesProject.Service;

import com.GroceriesProject.Dao.AdminDao;
import com.GroceriesProject.Model.Admin;

public class AdminService {
	private AdminDao ad;
	

	public boolean adminLogin(String user, String pass) {
		
        Admin admin= ad.findByAdminUsername(user);
        if(user.equals(admin.getAdminUsername())&& pass.equals(admin.getPassword())){
     	   return true;
     	   
        }
     return false;  
	}

	public Admin viewAdmin(String user) {
		// TODO Auto-generated method stub
		return ad.findByAdminUsername(user);
	}

	public Admin updateAdmin(Admin a) {
		// TODO Auto-generated method stub
		return ad.save(a);
	}



}
