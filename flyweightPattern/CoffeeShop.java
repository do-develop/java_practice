package flyweightPattern;

import java.util.ArrayList;

public class CoffeeShop {

	private static final ArrayList<Order> orders = new ArrayList<>();
	
	public void takeOrder(CoffeeType typeName, LatteArt latteArt, int tableNumber) {
		orders.add(Order.of(typeName, latteArt, tableNumber));
	}
	
	public static int getNumberOfOrders() {
		return orders.size();
	}
}
