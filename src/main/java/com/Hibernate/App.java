package com.Hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Hibernate.Models.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Employee employee1 = new Employee();
    	employee1.setId(103);
    	employee1.setName("Deep");
    	employee1.setSalary(500000);
    	
    	Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
    	ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
    	SessionFactory sessionFactory = cfg.buildSessionFactory(reg);
    	Session session = sessionFactory.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	session.save(employee1);
    	tx.commit();
    }
}
