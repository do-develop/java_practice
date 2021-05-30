package flyweightPattern;

public enum LatteArt {

	HEART("Heart"),
	LEAF("Leaf"),
	CAT("Cat");
	
	private String name;
	
	LatteArt(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
