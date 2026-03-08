package com.library_book.inventory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LibraryBookJpaApp {
    public static void main(String[] args) {

        // Create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        // Create EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // CREATE (INSERT)
            Book newBook1 = new Book(1, "Can we be strangers again?", "Shrijeet Shandilya", "Romance", 499.90, "Available", 2022);
            em.persist(newBook1);

            Book newBook2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", 599.90, "Available", 2024);
            em.persist(newBook2);
            
            Book newBook3 = new Book(3, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 699.90, "Available", 2004);
            em.persist(newBook3);
            
            // READ (FIND)
            Book foundBook =
                    em.find(Book.class, 3);

            System.out.println("Found Book: " + foundBook);

            // UPDATE
            if (foundBook != null) {
            	foundBook.setTitle("New Title");
            	foundBook.setAuthorName("No One");

                em.merge(foundBook);

                System.out.println("Updated Customer: " + foundBook);
            }

            // DELETE
            Book bookToDelete =
                    em.find(Book.class, 12);

            if (bookToDelete != null) {
                em.remove(bookToDelete);
                System.out.println("Deleted Book: " + bookToDelete);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
