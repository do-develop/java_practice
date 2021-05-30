package flyweightPattern;

public enum CoffeeType {

	CAPPUCCINO("Cappuccino"), 
	ESPRESSO("Espresso"), 
	AFFOGATO("Affogato"), 
	LATTE("Latte");
	
	private String name;
	
	CoffeeType(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
