package com.ems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ems.config.HibernateUtil;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;
import com.ems.serviceimpl.EmployeeServiceImpl;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeManagentSystemTest {
	EmployeeService emsService= new EmployeeServiceImpl();
	
	private static SessionFactory sessionFactory;
	private Session session;
  private 
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sessionFactory =HibernateUtil.getSessionFactory();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		if(sessionFactory!=null)
			sessionFactory.close();
		System.out.println("Session Factory Closed!!");
	}

	@BeforeEach
	void setUp() throws Exception {
		session=sessionFactory.openSession();
	}

	@AfterEach
	void tearDown() throws Exception {
		if(session!=null)
			session.close();
		System.out.println("Session Factory Closed!!");
	}

//	@Test
//	
//		@DisplayName("Testing Save Employee")
//		@Order(1)
//	void testSaveEmployee() {
//		
//		Transaction tx=session.beginTransaction();
//		Employee emp=Employee.builder().empName("Arindam").empAddress("Kolkata").salary(30000).contact("896701234").destination("Developer").
//		email("arinadam@outlook.com").DOJ(LocalDate.parse("2023-01-12")).build();
//		emsService.saveEmployee(emp);
//		tx.commit();
//		assertEquals("Arindam", emp.getEmpName());
//	}
//	
	@Test
	@DisplayName("Testing getting employee using ID")
	@Order(2)
	void testGetEmpById()
	{
		EmployeeDTO eDTO=emsService.getEmployeeUsingId(1);
		assertThat(eDTO.getEmpName()).isEqualTo("Sabdick Das");
		
		
	}

	@Test
	@Order(3)
	void testUpdateEmployee()
	{
		Employee emp= new Employee();
		emp.setEmpName("Arindam Das");
		emp.setEmpAddress("Midnapore");
		emp.setContact("9674412542");
		emp.setDestination("Java Developer");
		emp.setEmail("arindamdas12@gmail.com");
		emp.setDOJ(LocalDate.parse("2023-05-23"));
		emp.setUsername("arindam");
		emp.setPassword("Arin123");
		emp.setRole("Employee");
		
		EmployeeDTO eDTO = emsService.updateEmployee(3, emp);
		assertEquals("Arindam Das", eDTO.getEmpName());
		
		
		
	}
	@Test
	@Order(4)
	void testDeleteEmployee()
	{
		emsService.deleteEmployeeById(3);
		assertThrows(GlobalException.class, ()-> emsService.getEmployeeUsingId(3));
		
	}
}
