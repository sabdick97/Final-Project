package com.ems.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.DepartmentDAO;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

public class DepartmentDAOImpl implements DepartmentDAO{
	//save the department
	@Override
	public void saveDepartment(Department dept) {
		try(Session session= HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(dept);
			session.getTransaction().commit();
			session.clear();
			
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	//Show the Department details
	@Override
	public Department getDepartmentUsingID(int id) {
		try(Session session= HibernateUtil.getSession()){	
		Department dept= session.get(Department.class, id);
		return dept;
		
		}
		catch(HibernateException e) {
			
			System.out.println(e.getMessage());
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	// update the Department details
	@Override
	public Department updateDepartment(int id, Department department) {
try(Session session= HibernateUtil.getSession()){
			
			Department dept1=session.get(Department.class, id);
					dept1.setDeptName(department.getDeptName());
					dept1.setTotalEmp(department.getTotalEmp());
					dept1.setLocation(department.getLocation());
					session.beginTransaction();
					session.saveOrUpdate(dept1);
					session.getTransaction().commit();
					return dept1;
			
			
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	//assign Employee to Department
	@Override
	public void assignEmployeeToDept(int employeeId, int deptId) {
		try(Session session= HibernateUtil.getSession()){
		Employee emp= session.get(Employee.class, employeeId);
		Department dept=session.get(Department.class, deptId);
		
		
		List<Employee>employees= new ArrayList<>();
		employees.add(emp);
		
		dept.setEmployees(employees);
		emp.setDept(dept);
		
		dept.setTotalEmp(dept.getTotalEmp()+1);
		
		session.beginTransaction();
		session.saveOrUpdate(dept);
		
		session.getTransaction().commit();
		
		
	}
	
	
	}
	//assign Manager to Department
	@Override
	public void assignManagerToDept(int managerId, int deptId) {
		try(Session session= HibernateUtil.getSession()){
			
			Manager man=session.get(Manager.class, managerId);
			Department dept= session.get(Department.class, deptId);
			
			dept.setMan(man);
			
			session.beginTransaction();
			session.saveOrUpdate(dept);
			
			session.getTransaction().commit();
		}
			
			catch(HibernateException e) {
				
				System.out.println(e.getMessage());
				
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		}
	
	
	
