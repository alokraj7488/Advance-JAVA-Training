package com.calculatorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.calculator.Calculator;

public class CalculatorTest {
	Calculator calculator = new Calculator();

	@Test
	public void testTwoAndTwoGivesForur() {
		assertEquals(4, calculator.add(2, 2));

	}

	@Test
	public void testFiveAndFourGivesNine() {
		assertEquals(9, calculator.add(5, 4));

	}

	@Test
	@DisplayName("test sum of two negative numbers")
	void testSumOfNegativeNumber() {
		assertEquals(-5, calculator.sum(-2, -3), "sum of -2 and -3");
	}

	@RepeatedTest(3)
	@DisplayName("Test sum with repeted execution")
	void testSumRepeted() {
		assertEquals(10, calculator.sum(5, 5), "sum of 5 and 5 is 10");
	}

	@Nested
	@DisplayName("substreaction Tests")
	class SubtractionTests {
		@Test
		@DisplayName("Test substraction of two numbers")
		void testSubtraction() {
			assertEquals(9, calculator.subtract(5, -4), "subtraction of 5 and -4 is 1");
		}
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1,2,34,5,6})
	@DisplayName("Test multiplication of number by 2")
	void testMultiplicationByTwo(int number) {
		assertEquals(number * 2, calculator.multiply(number, 2),"Multiplication by 2");
	}
	
	@ParameterizedTest
	@CsvSource({"2,2,4","2,3,6","4,4,16"})
	void testMutliply(int x, int y, int expected) {
		assertEquals(expected, calculator.multiply(x, y));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/calculatedData.csv",numLinesToSkip = 1)
	@DisplayName("Test sum using csv file")
	void testSumUsingCsvFile(int a, int b, int exceptedSum) {
		assertEquals(exceptedSum, calculator.multiply(a, b));
	}
//	
//	@Test
//	@DisplayName("Test Devide by zero")
	
	
	
}
