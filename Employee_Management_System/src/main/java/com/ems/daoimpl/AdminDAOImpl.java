package com.ems.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.Admin_dao;
import com.ems.entity.Admin;

public class AdminDAOImpl implements Admin_dao {
//to Save the Admin Details
	@Override
	public void saveAdmin(Admin admin){
	try(Session session =HibernateUtil.getSession())
{
		
   session.beginTransaction();
   session.save(admin);
   session.getTransaction().commit();
   
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


	
//Log in Admin
	@Override
	public boolean login(String userName, String password) {
		try(Session session =HibernateUtil.getSession())
		{
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter Id: ","Type here.."));
			Admin admin =session.get(Admin.class, id);
			if(admin.getUsername().equals(userName)&& admin.getPassword().equals(password)&& admin.getRole().equalsIgnoreCase("admin"))
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


//Get the Admin details Using Id

	@Override
	public Admin getAdminUsingId(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			
			Admin admin =session.get(Admin.class, id);
			return admin;
		}
		catch(HibernateException e)
		{
			
			System.out.println(e.getMessage());
		}
			return null;
		
		
	}


// Update Admin Details Using Id

	@Override
	public Admin updateAdmin(int id, Admin admin) {
		try(Session session=HibernateUtil.getSession()){
			
			Admin adm=session.get(Admin.class,id);
			//updating existing details with the new one
			
			adm.setAdminName(admin.getAdminName());
			adm.setAdminEmail(admin.getAdminEmail());
			adm.setUsername(admin.getUsername());
			adm.setPassword(admin.getPassword());
			

			session.beginTransaction();
			session.saveOrUpdate(adm);
			session.getTransaction().commit();
			
			return adm;//returning employee entity
			
			
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



// Delete Admin details Using Id
	@Override
	public void deleteAdminUsingId(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			Admin admin=session.load(Admin.class,id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete?",
					"Are you sure?",JOptionPane.YES_NO_OPTION);
					
					if(input==0)
					{
						session.delete(admin);
						
						
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
	
		
		
	
	}
	
