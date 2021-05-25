package decoratorPattern;

public class FillColorDecorator extends ShapeDecorator {

	protected Color color;
	
	public FillColorDecorator(Shape decoratedShape, Color color) {
		super(decoratedShape);
		this.color = color;
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		System.out.println("Fill Color: " + color);
	}

	//No changes in the functionality
	@Override
	public void resize() {
		decoratedShape.resize();
	}

}
