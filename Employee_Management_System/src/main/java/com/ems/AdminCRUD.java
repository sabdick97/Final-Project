package com.ems;

import javax.swing.JOptionPane;

import com.ems.entity.Admin;
import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;
import com.ems.service.AdminService;
import com.ems.serviceimpl.AdminServiceImpl;

public class AdminCRUD {
	
	static AdminService adminService= new AdminServiceImpl();

	public static void saveAdmin()
	{
		Admin admin = new Admin();
		
		String name=JOptionPane.showInputDialog("Enter admin name: ", "Type here..");
		String email=JOptionPane.showInputDialog("Enter email: ", "Type here..");
		String user=JOptionPane.showInputDialog("Enter User_name: ", "Type here..");
		String pass=JOptionPane.showInputDialog("Enter password: ", "Type here..");
		
		admin.setAdminName(name);
		admin.setAdminEmail(email);
		admin.setUsername(user);
		admin.setPassword(pass);
		admin.setRole("admin");
		
		adminService.saveAdmin(admin);
		System.out.println("New admin details has been added!");
		
		}
	
	public static void login()
	{
		String user= JOptionPane.showInputDialog("Enter user_name: ", "Type here..");
		String pass= JOptionPane.showInputDialog("Enter password: ", "Type here..");
		adminService.login(user, pass);
		
	}
	
	public static void getAdmin()throws GlobalException
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search Details: ", "Enter ID Here..."));
		AdminDTO adm=adminService.getAdminUsingId(id);
		System.out.println("\nAdmin Name: " + adm.getAdminName());
		System.out.println("Admin Email: " + adm.getAdminEmail());
	    System.out.println("Admin Username: " + adm.getUserName());
		System.out.println("Admin Password : " +adm.getPassword());
		
		
	}
	
	public static void updateAdmin()throws GlobalException
	{
		Admin adm= new Admin();

		String name=JOptionPane.showInputDialog("Enter admin name: ", "Type here..");
		String email=JOptionPane.showInputDialog("Enter email: ", "Type here..");
		String user=JOptionPane.showInputDialog("Enter User_name: ", "Type here..");
		String pass=JOptionPane.showInputDialog("Enter password: ", "Type here..");
		
		adm.setAdminName(name);
		adm.setAdminEmail(email);
		adm.setUsername(user);
		adm.setPassword(pass);
		
		adminService.updateAdmin(Integer.parseInt(JOptionPane.showInputDialog("Enter ID to update : ", "Type Here...")), adm);
		System.out.println("Admin details update sucessfully!!");
				
		}
	
	public static void deleteAdminUsingId()
	{
		int id= Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:", "Type here...."));
		adminService.deleteAdminUsingId(id);
		JOptionPane.showMessageDialog(null, "Object is deleted!!");
	}
	
}
