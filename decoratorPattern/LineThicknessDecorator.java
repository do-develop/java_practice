package decoratorPattern;

public class LineThicknessDecorator extends ShapeDecorator {
	
	protected double thickness;

	public LineThicknessDecorator(Shape decoratedShape, double thickness) {
		super(decoratedShape);
		this.thickness = thickness;
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		System.out.println("Line thickness: " + thickness);
	}

	@Override
	public void resize() {
		decoratedShape.resize();
	}

}
