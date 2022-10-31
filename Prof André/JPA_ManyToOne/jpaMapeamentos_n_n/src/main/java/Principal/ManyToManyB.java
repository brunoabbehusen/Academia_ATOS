package Principal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpaMapeamentos_n_n.Department;
import jpaMapeamentos_n_n.Employee;

public class ManyToManyB {

	public static void main(String[] args) 
	   {
	      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "jpaMapeamentos_n_n" );
	      EntityManager entitymanager = emfactory.createEntityManager( );
	      entitymanager.getTransaction( ).begin( );

	      
	      //Criando a entidade trabalhador
	      Employee employee1 = new Employee();
	      employee1.setEname("Satish");
	      employee1.setSalary(45000.0);
	      employee1.setDeg("Technical Writer");
	      employee1.setDepartmentSet(null);
	      
	      //Criando a entidade trabalhador
	      Employee employee2 = new Employee();
	      employee2.setEname("Andre");
	      employee2.setSalary(70000.0);
	      employee2.setDeg("Researcher");
	      employee2.setDepartmentSet(null);
	      
	      //Criando a entidade trabalhador
	      Employee employee3 = new Employee();
	      employee3.setEname("Ana");
	      employee3.setSalary(50000.0);
	      employee3.setDeg("Professor");
	      employee3.setDepartmentSet(null);
	      
	      //Armazenar trabalhador
	      entitymanager.persist(employee1);	    
	      entitymanager.persist(employee2);	
	      entitymanager.persist(employee3);	
	      
	      //Criando um grupo de empregados1
	      List<Employee> employeeSet1 = new ArrayList(); 
	      employeeSet1.add(employee1);
	      //employeeSet1.add(employee2);

	      //Criando um grupo de empregados2
	      List<Employee> employeeSet2 = new ArrayList();  
	      employeeSet2.add(employee2);
	      
	      //Criando um grupo de empregados3
	      List<Employee> employeeSet3 = new ArrayList(); 
	      employeeSet3.add(employee3);
	      
	      //Criando a entidade departamento
	      Department department = new Department("Desenvolvedor",employeeSet1);	
	      Department department2 = new Department("Informatica",employeeSet2);	
	      Department department3 = new Department("Contabilidade",employeeSet3);	
	      	      
	      //Armazenando departamento
	      entitymanager.persist(department); //salvar o departamento no bd
	      entitymanager.persist(department2); //salvar o departamento2 no bd
	      entitymanager.persist(department3); //salvar o departamento3 no bd
    	     
          entitymanager.getTransaction( ).commit( );
	      entitymanager.close( );
	      emfactory.close( );
	   }
}
