package com.lnt.hr.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.hr.beans.Employees;
import com.lnt.hr.exceptions.EmpException;
/*
 * None of the code of the class to echo any message directly on console.
 * None of the code of the DAO class to throw SQL exception.  
 * 		Only custom exceptions are expected to come out.
 * If Connection Pool is being used, each method must procure connection and return back to pool
 * 		before execute of method ends.
 * One class will refer to another class mostly through interface.
 * 
 * Scopes in Spring IoC
 * 		1. The 'singleton'/'stateless': This object is created never more than once in a Spring Context.
 * 		2. The 'prototype'/'statefull': This object is created every time asked for.
 * 
 * There are four sub-annotations of @Component.
 * 		@Service: It is for declaring Service classes.
 * 		@Repository: It is for declaring DAO classes.
 * 		@Controller: It is for Spring MVC web application.
 * 		@RestController: It is for publishing services as REST services.
 * 
 * Transactional Propagation..,
 * 		1. Required(Default): Create and propagate the transaction to the DAO methods 
 * 				and each DB interaction participate in  same transaction.
 * 				If DB method does not receive a transaction, create a new one.
 * 		2. RequiresNew
 * 		3. Mandatory
 * 		4. Never
 * 		5. Supported
 * 		6. NotSupported
 * 		7. Nested (Spring Transaction)
 */
@Repository
@Scope("singleton")  // By default spring objects are singleton.
@Transactional(propagation=Propagation.REQUIRED)
public class EmpDaoImpl implements EmpDao {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Employees> getEmpList() throws EmpException {
		Query qry = manager.createNamedQuery("allEmps");
		return qry.getResultList();
	}

	@Override
	public Employees getEmpDetails(int empNo) throws EmpException {
		Employees emp = manager.find(Employees.class, empNo);
		return emp;
	}

	@Override
	public Employees insertNewEmployee(Employees emp) throws EmpException {
		//System.out.println(emp);
		manager.persist(emp);
		return emp;
	}
}
