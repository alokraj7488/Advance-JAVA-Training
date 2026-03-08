package com.mokitoMathServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import com.mokitoMathservice.Calculator;
import com.mokitoMathservice.MathService;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
	@Mock
	MathService mathService;
	@InjectMocks
	Calculator calculator;
	
	@Test
	void testAdd() {
		//Arrahnge - stub
		when(mathService.add(10,20)).thenReturn(30);
		//Assert
		assertEquals(30, calculator.add(10,20));
		//verify ineraction
		verify(mathService).add(10,20);
	}
	

}
