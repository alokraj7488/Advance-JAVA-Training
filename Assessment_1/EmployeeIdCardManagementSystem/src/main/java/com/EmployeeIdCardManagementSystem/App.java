package com.EmployeeIdCardManagementSystem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            
            Employee employee = new Employee("John", "john@gmail.com");
            IDCard idcard = new IDCard(89755645L, "12-04-24", employee);
            employee.setIdcard(idcard);
            em.persist(idcard);

            em.getTransaction().commit();
            System.out.println("Employee and IDCard saved Successfully");
            
            Employee emp = em.find(Employee.class, employee.getId());
            
            System.out.println();
            System.out.println("Employee Details:");
            System.out.println("ID: " + emp.getId());
            System.out.println("Employee Name: " + emp.getName());
            System.out.println("Employee Email ID: " + emp.getEmail());
            
            System.out.println();
            System.out.println("IDCard Details:");
            System.out.println("ID: " + emp.getId());
            System.out.println("Card Number: " + emp.getIdcard().getCardNumber());
            System.out.println("Issue Date: " + emp.getIdcard().getIssueDate());
            
           IDCard reCard = em.find(IDCard.class, idcard.getId());
           
           System.out.println("\nRetrieved through ID Card: ");
           System.out.println("Employee Name: " + reCard.getEmployee().getName());

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
