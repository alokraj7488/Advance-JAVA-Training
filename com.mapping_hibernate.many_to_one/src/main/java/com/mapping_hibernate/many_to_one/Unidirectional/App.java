package com.mapping_hibernate.many_to_one.Unidirectional;

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
			Department department = new Department("B.Tech");
			em.persist(department);

			Student student1 = new Student("John", department);
			em.persist(student1);

			Student student2 = new Student("Charlie", department);
			em.persist(student2);

			Student student3 = new Student("Harry", department);
			em.persist(student3);

			// READ (FIND)
			Student foundStudent = em.find(Student.class, 2);

			System.out.println("Found Customer: " + foundStudent);

			// UPDATE
			if (foundStudent != null) {
				Department newDept = new Department("BCA");
				foundStudent.setDepartment(newDept);

				em.merge(foundStudent);

				System.out.println("Updated Student: " + foundStudent);
			}

			// DELETE
			Student studentToDelete = em.find(Student.class, 5);

			if (studentToDelete != null) {
				em.remove(studentToDelete);
				System.out.println("Deleted Student: " + studentToDelete);

			} else {
				System.out.println("Student not found");
			}

			em.getTransaction().commit();

			System.out.println("Students and Department saved Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
