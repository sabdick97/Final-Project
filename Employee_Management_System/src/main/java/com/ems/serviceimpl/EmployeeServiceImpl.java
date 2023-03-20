package com.ems.serviceimpl;

 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;

import org.modelmapper.ModelMapper;

import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class); 
	//accessing the Data Access Layer(DAO) to call the methods
		EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
		
		@Override
		public void saveEmployee(Employee employee) {
			logger.info("New Employee Details added!!");
			employeeDAO.saveEmployee(employee);
		}
		@Override
		public EmployeeDTO getEmployeeUsingId(int id)
		{
		Employee employee= employeeDAO.getEmployeeUsingId(id);
		if(employee!=null)
			
		{
			
		   		return new ModelMapper().map(employee,EmployeeDTO.class);
		}
		else 
			throw new GlobalException("Employee details not found!!");
		
		}
		@Override
		public EmployeeDTO updateEmployee(int id, Employee employee) {
			Employee emp= employeeDAO.updateEmployee(id, employee);
			if(emp!=null)
			{
				return new ModelMapper().map(emp, EmployeeDTO.class);
			}
			else
			{
				throw new GlobalException("Employee with "+id+"not found!!");
			}
			
			
		}
		@Override
		public void deleteEmployeeById(int id) {
		
			employeeDAO.deleteEmployeeUsingId(id);
		}
		@Override
		public EmployeeDTO getEmployeeByEmail(String email) {
			Employee emp= employeeDAO.getEmployeeByEmail(email);
			if(emp!=null)
			{
				return new ModelMapper().map(emp, EmployeeDTO.class);
			}
			else
			{
				throw new GlobalException("Employee with "+email+"not found!!");
			}
			
		}
		
		
		@Override
		public boolean login(String userName, String password) {
			return employeeDAO.login(userName, password);
			
			
		}
		
}
