package com.ems.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.ManagerDAO;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

public class ManagerDAOImpl implements ManagerDAO {

	@Override
	public void saveManager(Manager manager) {
		try(Session session =HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(manager);
			session.getTransaction().commit();
			session.clear();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Manager getManagerUsingId(int id) {
		try(Session session =HibernateUtil.getSession())
		{
			
			Manager manager = session.get(Manager.class, id);
			return manager;
			
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Manager updateManager(int id, Manager manager) {
		try(Session session=HibernateUtil.getSession()){
		Manager man=session.get(Manager.class, id);
		
		man.setManName(manager.getManName());
		man.setManAddress(manager.getManAddress());	
		man.setSalary(manager.getSalary());
		man.setContact(manager.getContact());
		man.setEmail(manager.getEmail());
		man.setDestination(manager.getDestination());
		man.setDOJ(manager.getDOJ());
		man.setUsername(manager.getUsername());
		man.setPassword(manager.getPassword());
		
		session.beginTransaction();
		session.saveOrUpdate(man);
		session.getTransaction().commit();
		
			return man;
			
			
		}
		
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
    return null;
	}

	@Override
	public void deleteManagerUsingId(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			Manager manager=session.load(Manager.class, id);
			session.beginTransaction();
			
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete?",
					"Are you sure?",JOptionPane.YES_NO_OPTION);
			
			if(input==0)
			{
				session.delete(manager);
				
				
			}
			else
				JOptionPane.showMessageDialog(null, "User wants to delete it");
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
			
		}

	@Override
	public boolean login(String userName, String password) {
		try(Session session =HibernateUtil.getSession())
		{
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter Id: ","Type here.."));
			Manager manager= session.get(Manager.class, id);
			
			if(manager.getUsername().equals(userName)&& manager.getPassword().equals(password)&& manager.getRole().equalsIgnoreCase("manager"))
			{
				
					JOptionPane.showMessageDialog(null, "Log in Successfull!!");
					return true;
				}
							else
							{
								JOptionPane.showMessageDialog(null, "Wrong Credentials!!");
								return false;
							}

		}
		
	}

	@Override
	public void assignManagerToEmployee(int employeeId, int managerId) {
		try(Session session= HibernateUtil.getSession()){
			
			Manager man= session.get(Manager.class, managerId);
			Employee emp=session.get(Employee.class, employeeId);
			List<Employee>employees= new ArrayList<>();
			employees.add(emp);
		man.setEmployees(employees);
		emp.setMan(man);
		man.setEmployees(man.getEmployees());
		
		session.beginTransaction();
		session.saveOrUpdate(man);
		
		session.getTransaction().commit();
	
			
		}
		}
		
	}
		
	


