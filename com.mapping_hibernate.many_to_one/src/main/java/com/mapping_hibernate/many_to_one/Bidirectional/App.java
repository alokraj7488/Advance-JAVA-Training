package com.mapping_hibernate.many_to_one.Bidirectional;

import java.util.ArrayList;
import java.util.List;

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
			List<Student> studentsList1 = new ArrayList<>();
			Department department1 = new Department("B.Tech");
	
			Student student1 = new Student("John", department1);

			Student student2 = new Student("Harry", department1);

			studentsList1.add(student1);
			studentsList1.add(student2);
			
			department1.setStudents(studentsList1);
			em.persist(department1);


			List<Student> studentsList2 = new ArrayList<>();
			Department department2 = new Department("BBA");
			Student student3 = new Student("Charlie", department2);
			Student student4 = new Student("Joe", department2);
			
			studentsList2.add(student3);
			studentsList2.add(student4);
			
			department2.setStudents(studentsList2);
			em.persist(department2);			

			
			List<Student> studentsList3 = new ArrayList<>();
			Department department3 = new Department("BCA");
			Student student5 = new Student("Chloe", department3);
			Student student6 = new Student("Jennifer", department3);
			
			studentsList3.add(student5);
			studentsList3.add(student6);
			
			department3.setStudents(studentsList3);
			em.persist(department3);

//			// READ (FIND)
//			Department foundDepartment = em.find(Department.class, 2);
//
//			System.out.println("Found Student: " + foundDepartment);
//
//			// UPDATE
//			if (foundDepartment != null) {
//				foundDepartment.setDeptName("BBA");;
//
//				em.merge(foundDepartment);
//
//				System.out.println("Updated Student: " + foundDepartment);
//			}
//
//			// DELETE
//			Student studentToDelete = em.find(Student.class, 5);
//
//			if (studentToDelete != null) {
//				em.remove(studentToDelete);
//				System.out.println("Deleted Student: " + studentToDelete);
//
//			} else {
//				System.out.println("Student not found");
//			}

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
