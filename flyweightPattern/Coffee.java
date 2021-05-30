package flyweightPattern;

public class Coffee {

	protected final CoffeeType typeName; //intrinsic attribute
	
	protected Coffee(CoffeeType typeName) {
		super();
		this.typeName = typeName;
	}
	
	public CoffeeType getTypeName() {
		return typeName;
	}
	
	protected LatteArt applyLatteArt(LatteArt latteArt) {
		//latteArt is an extrinsic attribute
		//process it as method parameter, not as class members
		return latteArt;
	}
}
