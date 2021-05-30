package flyweightPattern;
/*
 * The Flyweight pattern helps us avoiding having large number of 
 * objects and allow us to effectively used the created objects by 
 * reusing them as much as possible.
 * */

public class FlyweightPatternTest {

	public static void main(String[] args) {
		CoffeeShop shop = new CoffeeShop();
		
		shop.takeOrder(CoffeeType.LATTE, LatteArt.CAT, 1);
		shop.takeOrder(CoffeeType.AFFOGATO, LatteArt.HEART, 2);
		shop.takeOrder(CoffeeType.CAPPUCCINO, LatteArt.LEAF, 3);
		shop.takeOrder(CoffeeType.CAPPUCCINO, LatteArt.CAT, 7);
		shop.takeOrder(CoffeeType.LATTE, LatteArt.LEAF, 5);
		shop.takeOrder(CoffeeType.AFFOGATO, LatteArt.HEART, 2);
		shop.takeOrder(CoffeeType.ESPRESSO, LatteArt.HEART, 1);
		
		System.out.println("------------------------------------------------------");
		System.out.println("Number of Order objects: "+CoffeeShop.getNumberOfOrders());
		System.out.println("Number of Coffee objects: "+CoffeeFactory.getNumberOfCoffee());
	}
}
