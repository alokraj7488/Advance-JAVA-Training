package com.email_management.com.email_management.system;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        // Create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

        // Create EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // CREATE (INSERT)
            Set<String> emails = new HashSet<>();
            
            User user1 = new User();
            user1.setUserId(1);
            user1.setUserName("John");
            emails.add("john123@gmail.com");
            emails.add("john@gmail.com");
            emails.add("john123@gmail.com");
            user1.setEmail(emails);
            em.persist(user1);

            User user2 = new User();
            user2.setUserId(2);
            user2.setUserName("Charlie");
            emails.add("charlie@gmail.com");
            emails.add("charlie97@gmail.com");
            user2.setEmail(emails);
            em.persist(user2);
            
            User user3 = new User();
            user3.setUserId(3);
            user3.setUserName("John Cena");
            emails.add("johnnn@gmail.com");
            emails.add("johncena123@gmail.com");
            emails.add("johncena45@gmail.com");
            user3.setEmail(emails);
            em.persist(user3);
                  
            em.getTransaction().commit();
            
            System.out.println("Users saved Successfully");
            
            // Fetch User
            User fetch = em.find(User.class, 3);
            System.out.println("User name: " + fetch.getUserName());
            System.out.println("User Emails: " + fetch.getEmail());

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
