package flyweightPattern;

public class Order {

	protected Coffee coffee;
	
	public Order(Coffee coffee) {
		super();
		this.coffee = coffee;
	}
	
	public static Order of(CoffeeType typeName, LatteArt latteArt, int tableNumber) {
		Coffee coffee = CoffeeFactory.makeCoffee(typeName, latteArt);
		System.out.printf("Serving to table '%d'.\n", tableNumber);
		System.out.println("------------------------------------------------------");
		return new Order(coffee);
	}
	
	public Coffee getCoffee() {
		return coffee;
	}
}
