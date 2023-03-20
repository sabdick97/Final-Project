package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;

import com.ems.dao.Admin_dao;
import com.ems.daoimpl.AdminDAOImpl;
import com.ems.entity.Admin;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;
import com.ems.model.EmployeeDTO;
import com.ems.service.AdminService;

public class AdminServiceImpl implements AdminService{

	
	AdminDAOImpl adminDao= new AdminDAOImpl();
	
	@Override
	public void saveAdmin(Admin admin) {
		adminDao.saveAdmin(admin);
		
	}

      @Override
	public boolean login(String userName, String password) {
		
		return adminDao.login(userName, password);
	}

	@Override
	public AdminDTO getAdminUsingId(int id) {
	
		Admin admin=adminDao.getAdminUsingId(id);
if(admin!=null)
			
		{
			
		   		return new ModelMapper().map(admin, AdminDTO.class);
		}
		else 
			throw new GlobalException("Employee details not found!!");
		
		}

	@Override
	public AdminDTO updateAdmin(int id, Admin admin) {
		Admin adm= adminDao.updateAdmin(id, admin);
		if(adm!=null)
		{
			return new ModelMapper().map(adm, AdminDTO.class);
		}
		else
		{
			throw new GlobalException("Admin with "+id+"not found!!");
		}
		
	}

	@Override
	public void deleteAdminUsingId(int id) {
		
		adminDao.deleteAdminUsingId(id);
	}
		
	}

	
	


