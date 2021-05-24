package bridgePattern;
//Bridge is a structural design pattern that divides business logic 
//or huge class into separate class hierarchies that can be developed 
//independently.
public abstract class Shape {

	// Composition - implementor
	protected Color color;
	
	public Shape(Color c) {
		this.color = c;
	}
	
	abstract public void applyColor();
}
