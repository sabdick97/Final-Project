package com.ems;



import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;
import com.ems.serviceimpl.EmployeeServiceImpl;

public class EmployeeCRUD {

	
	static EmployeeService empService = new EmployeeServiceImpl();
	
	public static void saveEmployee()
	{
		Employee emp = new Employee();
//		sc.nextLine();
//		System.out.println("Enter name:");
//		String name = sc.nextLine();
//		System.out.println("Enter address:");
//		String add = sc.nextLine();
//		System.out.println("Enter salary:");
//		double sal = sc.nextDouble();
//		System.out.println("Enter contact number:");
//		String cont = sc.next();
//		sc.nextLine();
//		System.out.println("Enter email:");
//		String email = sc.nextLine();
//		System.out.println("Enter designation:");
//		String des = sc.next();
//		System.out.println("Enter DOJ:");
//		LocalDate date = LocalDate.parse(sc.next()); //YYYY-MM-DD
//		System.out.println("Enter username:");
//		String user = sc.next();
//		System.out.println("Enter password:");
//		String pass = sc.next();
		
		String name = JOptionPane.showInputDialog("Enter name:","Type here..");
		String add = JOptionPane.showInputDialog("Enter address:","Type here..");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:","Type here.."));
		String cont = JOptionPane.showInputDialog("Enter phone no.:","Type here..");
		String email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String des = JOptionPane.showInputDialog("Enter designation:","Type here..");
		LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Enter D.O.J:","Type here.."));
		String user = JOptionPane.showInputDialog("Enter user-name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter password:","Type here..");
		
		emp.setEmpName(name);
		emp.setEmpAddress(add);
		emp.setSalary(sal);
		emp.setContact(cont);
		emp.setEmail(email);
		emp.setDestination(des);
		emp.setDOJ(date);
		emp.setUsername(user);
		emp.setPassword(pass);
		emp.setRole("employee");
		
		
		empService.saveEmployee(emp);
		System.out.println("Employee details saved!!");
		
		
	}
	public static void getEmployee()throws GlobalException
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search Details: ", "Enter ID Here..."));
		EmployeeDTO emp1 = empService.getEmployeeUsingId(id);
		
		System.out.println("\nEmployee Name: " + emp1.getEmpName());
		System.out.println("Employee Address: " + emp1.getEmpAddress());
		System.out.println("Employee Salary: " + emp1.getSalary());
		System.out.println("Employee Contact: " + emp1.getContact());
		System.out.println("Employee Email: " + emp1.getEmail());
		
		
		
	}
	public static void updateEmployee()throws GlobalException{
		
		Employee emp1= new Employee();
		
		
		String name = JOptionPane.showInputDialog("Enter name:","Type here..");
		String add = JOptionPane.showInputDialog("Enter address:","Type here..");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:","Type here.."));
		String cont = JOptionPane.showInputDialog("Enter phone no.:","Type here..");
		String email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String des = JOptionPane.showInputDialog("Enter designation:","Type here..");
		LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Enter D.O.J:","Type here.."));
		String user = JOptionPane.showInputDialog("Enter user-name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter password:","Type here..");
		
		emp1.setEmpName(name);
		emp1.setEmpAddress(add);
		emp1.setSalary(sal);
		emp1.setContact(cont);
		emp1.setEmail(email);
		emp1.setDestination(des);
		emp1.setDOJ(date);
		emp1.setUsername(user);
		emp1.setPassword(pass);
		emp1.setRole("employee");
		
		empService.updateEmployee(Integer.parseInt(JOptionPane.showInputDialog("Enter ID to update : ", "Type Here...")), emp1);
		System.out.println("Employee details update sucessfully!!");
	}
		
		public static void deleteEmployee()
		{
			int id= Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:", "Type here...."));
			empService.deleteEmployeeById(id);
			JOptionPane.showMessageDialog(null, "Object is deleted!!");
		}
	public static void getEmployeeByEmail()
	{
	String email =(JOptionPane.showInputDialog("Enter email to search Details: ", "Enter email Here..."));
	EmployeeDTO emp1 = empService.getEmployeeByEmail(email);
	
	System.out.println("\nEmployee Name: " + emp1.getEmpName());
	System.out.println("Employee Address: " + emp1.getEmpAddress());
	System.out.println("Employee Salary: " + emp1.getSalary());
	System.out.println("Employee Contact: " + emp1.getContact());
	System.out.println("Employee Email: " + emp1.getEmail());
	
	
		
		
		
	}
	public static void login()
	{
		String user= JOptionPane.showInputDialog("Enter user_name: ", "Type here..");
		String pass= JOptionPane.showInputDialog("Enter password: ", "Type here..");
		empService.login(user, pass);
	
	}
}

