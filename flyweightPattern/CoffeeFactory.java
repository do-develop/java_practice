package flyweightPattern;

//source: https://dzone.com/articles/using-flyweight-design-pattern-in-java
import java.util.WeakHashMap;

public class CoffeeFactory {

	protected static WeakHashMap<CoffeeType, Coffee> coffeeMap 
	= new WeakHashMap<CoffeeType, Coffee>();
	
	public static Coffee makeCoffee(CoffeeType typeName, LatteArt latteArt) {
		Coffee coffee = coffeeMap.get(typeName);
		if(coffee == null) {
			coffee = new Coffee(typeName);
			coffeeMap.put(typeName, coffee);
		}
		
		System.out.printf("Making '%s' with Latte Art '%s'.\n", 
				coffee.getTypeName(), coffee.applyLatteArt(latteArt));
		
		return coffee;
	}
	
	public static int getNumberOfCoffee() {
		return coffeeMap.size();
	}
}
