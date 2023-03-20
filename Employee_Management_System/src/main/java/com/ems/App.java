package com.ems;


	import java.util.Scanner;

	import javax.swing.JOptionPane;

import org.hibernate.internal.build.AllowSysOut;

import com.ems.entity.Admin;
import com.ems.service.AdminService;
import com.ems.service.EmployeeService;
import com.ems.service.ManagerService;
import com.ems.serviceimpl.AdminServiceImpl;
import com.ems.serviceimpl.EmployeeServiceImpl;
import com.ems.serviceimpl.ManagerServiceImpl;



	public class App 
	{
		//static Scanner sc = new Scanner(System.in);
	    public static void main( String[] args )
	    {
	    mainMenu();	
	    }
	    
	    public static void mainMenu()
	    {
	    	int ch;
	    	do {
	        System.out.println("=================Welcome to Employee Management System!====================");
	        System.out.println("1) Admin\n2) Employee\n3) Manager \n4) Exit");
//	        ch = sc.nextInt();
	        ch = Integer.parseInt(JOptionPane.showInputDialog("Enter choice: ","Type here 1/2/3/4"));
	        switch(ch)
	        {
	        case 1:
	        	mainAdmin();// Admin Modification
	        	break;
	        case 2:
	        	mainUser();//Employee Modification
	        	break;
	        case 3:
	        	mainManager();//Manager Modification
	        	break;
	        case 4:
	        	System.exit(0); //Exit from main menu
	        	break;
	        default:
	        	System.out.println("Wrong Input!!");	
	        }
	    	}while(ch!=3);
	    }
//====================================================Employee Log in======================================================//	    
	    public static void mainUser()
	    {
	    	do {
	    		
	    		EmployeeService employeeService= new EmployeeServiceImpl();
	    	System.out.println("==================Employee Menu==========================");
	      	System.out.println("A)Log in\nB)Exit");
	    	//char choice = sc.next().charAt(0);
	      	String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...A/B");
	    	switch(choice)
	    	{
	    	
	    	case "A":
	    		boolean status=employeeService.login(JOptionPane.showInputDialog("Enter User_name: ", "Type here..."),JOptionPane.showInputDialog("Enter Password: ", "Type here..."));
		    	if(status==true)
		    	{
		    		 afterLoginEmployee();
		    	}
		    	break;
	    		
	    	case "B":
	    		  mainMenu();
	    		
	    		break;
	    
	    	
	    	}	
	    	}while(true);
	    	}
//=====================================================To show details of Employee==========================================//	    	
	    
	    	public static void afterLoginEmployee()
	    	{
	    		do {
		    		System.out.println();
		    		System.out.println("A) Get Employee Details by Id\nB) Get Employee details by Email\nC) Update Employee Details\nD)Main Menu");
		    		String choice= JOptionPane.showInputDialog("Enter Choice: ", "Type here...A/B/C/D");
		    			switch(choice)
		    			{
		    		
		    			case "A":
		    				EmployeeCRUD.getEmployee();
		    				break;
		    				
		    			case "B":
		    				EmployeeCRUD.getEmployeeByEmail();
		    				break;
		    			case "C":
		    				EmployeeCRUD.updateEmployee();// to update the Employee details
		    				break;
		    			case "D":
		    				mainMenu();
		    				break;
		    				
		    				default:
		    				System.out.println("Wrong Input");
		    			
		    			}
		    			}while(true);
		    			
	    	}
	    	
	  
	    public static void mainAdmin()
	    {
	    	AdminService adminservice= new AdminServiceImpl();
	    System.out.println("====================Admin Menu==========================");
	    System.out.println("A) Log in\nB) Exit");
	    String choice= JOptionPane.showInputDialog("Enter choice: ","Type here...A/B");
	    
	    switch(choice)
	    {
	    	
	    case "A":
	    	
			boolean status=adminservice.login(JOptionPane.showInputDialog("Enter User_name: ", "Type here..."),JOptionPane.showInputDialog("Enter Password: ", "Type here..."));
	    	if(status==true)
	    	{
	    		afterLoginAdmin();
	    	}
	    	break;
	    	
	    case "B":
	    	mainMenu();
	    	
	    	break;
	    
	    }
	    
	    }
//=============================================After log in Admin part==================================================//	    
	    	public static void afterLoginAdmin()
	    	{
	    		do {
	    		System.out.println();
	    		System.out.println("1) Department Operation\n2) Employee Operation\n3)Manager Operation\n4) Admin Operation\n5)Assign Employee to Department\n6)Assign Manager to Department");
	    		String choice= JOptionPane.showInputDialog("Enter Choice: ", "Type here...1/2/3/4/5/6");
	    			switch(choice)
	    			{
	    			
	    			case "1":
	    				departmentOperation();// Department CRUD
	    			break;
	    			
	    			case "2":
	    				 employeeOperation(); //Employee CRUD
	    				break;
	    			case "3":
	    				managerOperation(); // Manager CRUD
	    				break;
	    				
	    			case "4":
	    				adminOperation(); //Admin CRUD
	    				break;
	    			case "5":
	    				DepartmentCRUD.assign();//to assign the Employee to Department
	    				break;
	    			case "6":
	    				DepartmentCRUD.assignMantoDept();// to assign  the Manager to  Department 
	    				break;
	    			case "7":
	    				mainMenu();// main Menu
	    				break;
	    				
	    			}
	    		
	    	
	    }while (true);
	    	
	
	    	}
	    	public static void departmentOperation()
	    	{
	    		
	    		System.out.println();
	    		System.out.println("A)Add Department\nB) Get Depatment\nC)Assign employee to department\nD)Update Department\nE)Assign Manager to department\nF)Main Menu");
	    		String choice= JOptionPane.showInputDialog("Enter Choice: ", "Type here...A/B/C/D/E/F");
    			switch(choice)
    			{
    			
    			case "A":
    				DepartmentCRUD.addDepartment();//  to save the Department details
    			break;
    			
    			case "B":
    				DepartmentCRUD.getDepartment();// to view the Department Details
    				break;
    			case "C":
    				DepartmentCRUD.assign();//to assign the Employee to Department
    				break;
    			
    			case "D":
    	    		DepartmentCRUD.updateDepartment();// to update the Department Details
    	    		break;
    	    		
    			case "E":
    				DepartmentCRUD.assignMantoDept();// to assign  the Manager to  Department 
    				break;
    				
    			case "F":
    				mainMenu(); //return main menu
    				break;
    				
    			
	    	}
    			
	         }
	    	
	    	public static void employeeOperation()
	    	{
	    		
	    		System.out.println();
	    		System.out.println("A)Add Employee\nB) Get Employee\nC)Update Employee\nD)Delete Employee\nE)Main Menu");
	    		String choice= JOptionPane.showInputDialog("Enter Choice: ", "Type here...A/B/C/D/E");
    			switch(choice)
    			{
    			case "A":
    				EmployeeCRUD.saveEmployee();// to save the Employee details
    				break;
    				
    			case "B":
    				EmployeeCRUD.getEmployee();//to view the Employee details
    				break;
    				
    			case "C":
    				EmployeeCRUD.updateEmployee();// to update the Employee details
    				break;
    				
    			case "D":
    				EmployeeCRUD.deleteEmployee();// to delete the Employee details
    			    break;
    			    
    			case "E":
    				
    				mainMenu(); // return main menu
    				break;
    			
    			}
    			
	    	   }
	    	public static void managerOperation()
	    	{
	    		System.out.println();
	    		System.out.println("A)Add Manager\nB) Get Manager Details\nC)Update Manager\nD)Delete Manager\nE) Assign EmptoManager\nF)Main Menu");
	    		String choice= JOptionPane.showInputDialog("Enter Choice: ", "Type here...A/B/C/D/E/F");
    			switch(choice)
    			{
    			case "A":
    				ManagerCRUD.saveManager(); //to save the manager details
    				break;
    				
    				
    			case"B":
    				ManagerCRUD.getManager();//to view the manager details
    			
    				break;
    				
    			case"C":
    				ManagerCRUD.updateManager();// to update the manager details
    				break;
    				
    				case "D":
    					ManagerCRUD.deleteManager();// to delete the manager details
    					break;
    				case "E":
    					ManagerCRUD.assign();//to assign the Employee to manager 
    					break;

    				case "F":
    					mainMenu(); //return main menu
    					break;
    			}
	    		
	    	}
	    	
	    	public static void adminOperation()
	    	{
	    		System.out.println();
	    		System.out.println("A)Add Admin\nB) Get Admin Details\nC)Update Admin Details\nD)Delete Admin Details\nE)Main Menu");
	    		String choice= JOptionPane.showInputDialog("Enter Choice: ", "Type here...A/B/C/D/E");
    			switch(choice)
    			{
    			case "A":
    				AdminCRUD.saveAdmin();//save admin details
    				break;
    				
    			case "B":
    				AdminCRUD.getAdmin();// to view the admin details
    				break;
    				
    				
    			case "C":
    				AdminCRUD.updateAdmin();// to update the admin datails
    				break;
    				
    				
    			case "D":
    				AdminCRUD.deleteAdminUsingId();// to delete the admin details
    				break;
    				
    			case "E":
					mainMenu(); //return main menu
					break;
    			
    			}
	    		
	    	}
//======================================Manager Log in part============================================================//   	
	    	public static void mainManager()
	    	{
	    		ManagerService managerservice=new ManagerServiceImpl();
	    		System.out.println("====================Manager Menu==========================");
	    	    System.out.println("A) Log in\nB) Exit");
	    	    String choice= JOptionPane.showInputDialog("Enter choice: ","Type here...A/B");
	    	    switch(choice)
	    	    {
	    	   
	    	    	
	    	    	
	    	    case "A":
	    	    	boolean status=managerservice.login(JOptionPane.showInputDialog("Enter User_name: ", "Type here..."),JOptionPane.showInputDialog("Enter Password: ", "Type here..."));
	    	    	if(status==true)
	    	    	{
	    	    		afterloginManager();
	    	    	}
	    	    	break;
	    	    	
	    	    case "B":
	    	    	mainMenu();
	    	    	break;
	    	    	
	    	    }
	    	}
	    	    public static void afterloginManager()
	    	    {
	    	    	do {
	    	    		System.out.println();
	    	    		System.out.println("A) Show Manager Details\nB) Update Manager Details\nC)Assign Employee to Manager\nD)Return Main Menu");
	    	    		String choice= JOptionPane.showInputDialog("Enter Choice: ", "Type here...A/B/C");
	    	    			switch(choice)
	    	    			{
	    	    			case "A":
	    	    				ManagerCRUD.getManager();
	    	    				break;
	    	    				
	    	    			case "B":
	    	    				ManagerCRUD.updateManager();
	    	    				break;
	    	    			case "C":
	    	    				
	    	    			ManagerCRUD.assign();
	    	    			break;
	    	    			case "D":
	    	    				mainMenu();
	    	    				break;
	    	    			
	    	    			}
	    	    			
	    	}while(true);
	    	}
	}
	
