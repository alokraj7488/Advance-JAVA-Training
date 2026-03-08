package onlineShopingCartTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import onlineShopingCart.CartService;

public class CartServiceTest {

	private CartService service;

	@BeforeEach
	void setUp() {
		service = new CartService();
	}

	@Test
	void testCalculateTotalPrice() {
		double total = service.calculateTotal(1500, 1500, 1500);
		assertEquals(4500, total);
	}

	@Test
	void testDiscountApplied() {
		double total = service.calculateTotal(2000, 2000, 1000);
		double discount = service.calculateDiscount(total);

		assertEquals(500, discount);
	}

	@Test
	void testNoDiscount() {
		double total = service.calculateTotal(1000, 1500, 2000);
		double discount = service.calculateDiscount(total);

		assertEquals(0, discount);
	}

	@Test
	void testFinalPayableAmount() {
		double total = service.calculateTotal(2000, 2000, 1000);
		double discount = service.calculateDiscount(total);
		double finalAmount = service.calculateFinalAmount(total, discount);

		assertEquals(4500, finalAmount);
	}
}
