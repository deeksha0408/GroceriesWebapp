package com.GroceriesProject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GroceriesProject.Model.Admin;



public interface AdminDao extends JpaRepository<Admin,Integer> {

	Admin findByAdminUsername(String user);

}
