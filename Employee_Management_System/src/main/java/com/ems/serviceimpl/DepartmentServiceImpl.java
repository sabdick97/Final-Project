package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;

import com.ems.daoimpl.DepartmentDAOImpl;
import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;
import com.ems.model.EmployeeDTO;
import com.ems.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	//accessing the Data Access Layer(DAO) to call the methods
	DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();
	

@Override
public void saveDepartment(Department dept) {
	departmentDAO.saveDepartment(dept);
}
@Override
public DepartmentDTO getDepartmentUsingID(int id)
{
Department dept= departmentDAO.getDepartmentUsingID(id);
if(dept!=null)
	
{
   		return new ModelMapper().map(dept,DepartmentDTO.class);
}
else 
	throw new GlobalException("Department details not found!!");

}
@Override
public DepartmentDTO updateDepartment(int id, Department department) {
	Department dept=departmentDAO.updateDepartment(id, department);
	if(dept!=null)
	{
		return new ModelMapper().map(dept, DepartmentDTO.class);
		
		
		
	}else
	{
		throw new GlobalException("Department with "+id+"not found!!");
	}
	
	
	
}
@Override
public void assignEmployeeToDept(int employeeId, int deptId) {
	departmentDAO.assignEmployeeToDept(employeeId, deptId);
	
}
@Override
public void assignManagerToDept(int managerId, int deptId) {
	departmentDAO.assignManagerToDept(managerId, deptId);
}


}

