package com.br;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpaMapeamentos3.Department;
import jpaMapeamentos3.Employee;

public class App {

	public static void main(String[] args) 
   {
      EntityManagerFactory emfactory = Persistence.
      createEntityManagerFactory( "jpamapeamentos_1_1" );
      EntityManager entitymanager = emfactory.
      createEntityManager( );
      entitymanager.getTransaction( ).begin( );

      //Create Department Entity
      Department department = new Department();
      department.setName("Development");

      //Store Department
      entitymanager.persist(department);

      //Create Employee Entity
      Employee employee = new Employee();
      employee.setEname("Bruno");
      employee.setSalary(6000.0);
      employee.setDeg("Developer");
      employee.setDepartment(department);

      //Store Employee
      entitymanager.persist(employee);

      entitymanager.getTransaction().commit();
      entitymanager.close();
      emfactory.close();
   }
}