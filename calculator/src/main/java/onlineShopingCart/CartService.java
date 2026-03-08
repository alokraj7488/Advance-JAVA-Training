package onlineShopingCart;

public class CartService {

	public double calculateTotal(double item1, double item2, double item3) {
		return item1 + item2 + item3;
	}

	public double calculateDiscount(double total) {
		if (total >= 5000) {
			return total * 0.10;
		}
		return 0;
	}

	public double calculateFinalAmount(double total, double discount) {
		return total - discount;
	}
}
