package com.mapping_hibernate.one_to_one;

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
    	// Create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

        // Create EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // CREATE (INSERT)
            
            Account account1 = new Account("5864LC57", "Saving");
            Customer customer1 = new Customer("John", account1);
            account1.setCustomer(customer1);
            em.persist(customer1);

            Account account2 = new Account("9874LC46", "Current");
            Customer customer2 = new Customer("Charlie", account2);
            account2.setCustomer(customer2);
            em.persist(customer2);
            
            // READ (FIND)
            Customer foundCustomer = em.find(Customer.class, 1);

            System.out.println("Found Customer: " + foundCustomer);

            // UPDATE
            if (foundCustomer != null) {
            	Account account = new Account("9864LC78", "Current");
            	foundCustomer.setAccount(account);

                em.merge(foundCustomer);

                System.out.println("Updated Customer: " + foundCustomer);
            }

            // DELETE
            Customer customerToDelete = em.find(Customer.class, 2);

            if (customerToDelete != null ) {
                em.remove(customerToDelete);
                System.out.println("Deleted Customer: " + customerToDelete);

            }
            else {
            	System.out.println("Customer not found");
            }

            em.getTransaction().commit();
            
            System.out.println("Customer and Account saved Successfully");

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
