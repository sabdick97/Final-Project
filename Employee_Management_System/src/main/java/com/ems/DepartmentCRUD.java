package com.ems;

import javax.swing.JOptionPane;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;
import com.ems.model.EmployeeDTO;
import com.ems.service.DepartmentService;
import com.ems.service.EmployeeService;
import com.ems.serviceimpl.DepartmentServiceImpl;
import com.ems.serviceimpl.EmployeeServiceImpl;

public class DepartmentCRUD {
	static DepartmentService deptService = new DepartmentServiceImpl() ;
		
		
	
		public static void saveDepartment()
		{
			Department dept = new Department();
		
			
			String DeptName = JOptionPane.showInputDialog("Enter DeptName:","Type here..");
			int totalEmp = Integer.parseInt(JOptionPane.showInputDialog("Enter TotalEmp : ", "Type here..."));
			String Location = JOptionPane.showInputDialog("Enter Location:","Type here..");
	
	
	dept.setDeptName(DeptName);
	dept.setTotalEmp(totalEmp);
	dept.setLocation(Location);
	
	deptService.saveDepartment(dept);
	System.out.println("Department details saved!!");
	
	}
		public static void getDepartment()throws GlobalException{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search Details: ", "Enter ID Here..."));
			DepartmentDTO dept1 = deptService.getDepartmentUsingID(id);
			System.out.println("\nDepartment id: " + dept1.getDeptId());
			System.out.println("Department Name: " + dept1.getDeptName());
			System.out.println("Total Employee: " + dept1.getTotalEmp());
			System.out.println("Department LOcation: " + dept1.getLocation());
		
	}
		public static void updateDepartment()throws GlobalException
		
		{
			Department dept2 = new Department();
			String DeptName = JOptionPane.showInputDialog("Enter DeptName:","Type here..");
			int totalEmp = Integer.parseInt(JOptionPane.showInputDialog("Enter TotalEmp : ", "Type here..."));
			String Location = JOptionPane.showInputDialog("Enter Location:","Type here..");
	
	      dept2.setDeptName(DeptName);
	      dept2.setTotalEmp(totalEmp);
	      dept2.setLocation(Location);
	      deptService.updateDepartment(Integer.parseInt(JOptionPane.showInputDialog("Enter ID to update : ", "Type Here...")), dept2);
			
			System.out.println("Department Details Updated!!");
			

		}
		
		
		public static void addDepartment()
		
 {
        Department dept = new Department();
		
			
			String DeptName = JOptionPane.showInputDialog("Enter DeptName:","Type here..");
			int totalEmp = Integer.parseInt(JOptionPane.showInputDialog("Enter TotalEmp : ", "Type here..."));
			String Location = JOptionPane.showInputDialog("Enter Location:","Type here..");
	
	
	dept.setDeptName(DeptName);
	dept.setTotalEmp(totalEmp);
	dept.setLocation(Location);
	
	deptService.saveDepartment(dept);
	System.out.println("Department details saved!!");	
	}
		
		
		public static void getDepartment2() throws GlobalException{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search Details: ", "Enter ID Here..."));
			DepartmentDTO dept = deptService.getDepartmentUsingID(id);
			
			System.out.println("Department Name: " + dept.getDeptName());
			System.out.println("Total Employee: " + dept.getTotalEmp());
			System.out.println("Department LOcation: " + dept.getLocation());
	}
		public static void assign()
		{
			int deptId=Integer.parseInt(JOptionPane.showInputDialog("Enter Dept. Id: ", "Type here..."));
			int empId=Integer.parseInt(JOptionPane.showInputDialog("Enter emp Id: ", "Type here..."));
			deptService.assignEmployeeToDept(empId, deptId);
			JOptionPane.showMessageDialog(null,"Employee has been assigned succesfully!!");
		}
    public static void assignMantoDept()
    {
    	int deptId=Integer.parseInt(JOptionPane.showInputDialog("Enter Dept. Id: ", "Type here..."));
		int manId=Integer.parseInt(JOptionPane.showInputDialog("Enter Manager Id: ", "Type here..."));
		deptService.assignManagerToDept(manId, deptId);
		JOptionPane.showMessageDialog(null,"Manager has been assigned succesfully!!");
    	
    }
}
	
	
	