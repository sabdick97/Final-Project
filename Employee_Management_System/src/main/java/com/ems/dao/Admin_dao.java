package com.ems.dao;
import com.ems.entity.Admin;
public interface Admin_dao {

			void saveAdmin(Admin admin);
			boolean login(String userName, String password);
			Admin getAdminUsingId(int id);
           Admin updateAdmin(int id, Admin admin);		
           void deleteAdminUsingId(int id);
		}


