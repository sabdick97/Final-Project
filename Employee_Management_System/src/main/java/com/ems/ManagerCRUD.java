package com.ems;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;
import com.ems.serviceimpl.ManagerServiceImpl;

public class ManagerCRUD {
	static ManagerServiceImpl mngService= new ManagerServiceImpl();
	
	public static void saveManager()
	{
		
		Manager mng= new Manager();
		
		
		String name = JOptionPane.showInputDialog("Enter name:","Type here..");
		String add = JOptionPane.showInputDialog("Enter address:","Type here..");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:","Type here.."));
		String cont = JOptionPane.showInputDialog("Enter phone no.:","Type here..");
		String email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String des = JOptionPane.showInputDialog("Enter designation:","Type here..");
		LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Enter D.O.J:","Type here.."));
		String user = JOptionPane.showInputDialog("Enter user-name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter password:","Type here..");
		
		mng.setManName(name);
		mng.setManAddress(add);
		mng.setSalary(sal);
		mng.setContact(cont);
		mng.setEmail(email);
		mng.setDestination(des);
		mng.setDOJ(date);
		mng.setUsername(user);
		mng.setPassword(pass);
		mng.setRole("Manager");
		
		mngService.saveManager(mng);
		System.out.println("Manager Details Saved!!");
	}
	
	public static void getManager()throws GlobalException
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search Details: ", "Enter ID Here..."));
		ManagerDTO man1 = mngService.getManagerUsingId(id);
		
		System.out.println("\nEmployee Name: " + man1.getManName());
		System.out.println("Employee Address: " + man1.getManAddress());
		System.out.println("Employee Salary: " + man1.getSalary());
		System.out.println("Employee Contact: " + man1.getContact());
		System.out.println("Employee Email: " + man1.getEmail());
	}

	
	public static void updateManager()throws GlobalException
	{
		Manager man= new Manager();
		
		String name = JOptionPane.showInputDialog("Enter name:","Type here..");
		String add = JOptionPane.showInputDialog("Enter address:","Type here..");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:","Type here.."));
		String cont = JOptionPane.showInputDialog("Enter phone no.:","Type here..");
		String email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String des = JOptionPane.showInputDialog("Enter designation:","Type here..");
		LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Enter D.O.J:","Type here.."));
		String user = JOptionPane.showInputDialog("Enter user-name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter password:","Type here..");
		
		man.setManName(name);
		man.setManAddress(add);
		man.setSalary(sal);
		man.setContact(cont);
		man.setEmail(email);
		man.setDestination(des);
		man.setDOJ(date);
		man.setUsername(user);
		man.setPassword(pass);
		mngService.updateManager(Integer.parseInt(JOptionPane.showInputDialog("Enter ID to update : ", "Type Here...")), man);
		
	     System.out.println("Manager details update sucessfully!!");
	     
	     

	}
	public static void deleteManager()
    {
		int id= Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:", "Type here...."));
		mngService.deleteManagerUsingId(id);
		JOptionPane.showMessageDialog(null, "Object is deleted!!");
    }
	
	public static void login()
	{
		String user= JOptionPane.showInputDialog("Enter user_name: ", "Type here..");
		String pass= JOptionPane.showInputDialog("Enter password: ", "Type here..");
		mngService.login(user, pass);
		
	}
	
	public static void assign()
	{
		int manId=Integer.parseInt(JOptionPane.showInputDialog("Enter Manager Id: ", "Type here..."));
		int empId=Integer.parseInt(JOptionPane.showInputDialog("Enter emp Id: ", "Type here..."));
		mngService.assignManagerToEmployee(empId, manId);
		JOptionPane.showMessageDialog(null,"Employee has been assigned succesfully!!");
		
		
	}
}
