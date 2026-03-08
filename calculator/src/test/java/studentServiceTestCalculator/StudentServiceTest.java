package studentServiceTestCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import studentCalculator.Student;
import studentCalculator.StudentService;

public class StudentServiceTest {

	private StudentService service;
	private Student studentPass;
	private Student studentFail;

	@BeforeEach
	void setUp() {
		service = new StudentService();

		studentPass = new Student(1, "Supriya", 80, 80, 80);
		studentFail = new Student(2, "Rahul", 30, 30, 30);
	}

	
	@Test
	void testCalculateTotal() {
		int total = service.calculateTotal(studentPass);
		assertEquals(240, total);
	}

	
	@Test
	void testCalculateAverage() {
		double average = service.calculateAverage(studentPass);
		assertEquals(80.0, average);
	}

	
	@Test
	void testStudentPass() {
		boolean result = service.isPassed(studentPass);
		assertTrue(result);
	}

	
	@Test
	void testStudentFail() {
		boolean result = service.isPassed(studentFail);
		assertFalse(result);
	}
}
