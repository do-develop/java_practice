package decoratorPattern;

//decorator class is an abstract class to avoid any direct instantiation
//this acts a wrapper which does not add functionality into the Shape classes
public abstract class ShapeDecorator implements Shape {
	protected Shape decoratedShape;
	
	public ShapeDecorator(Shape decoratedShape) {
		super();
		this.decoratedShape = decoratedShape;
	}
}
