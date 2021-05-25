package decoratorPattern;

public class LineStyleDecorator extends ShapeDecorator {

	protected LineStyle style;
	
	public LineStyleDecorator(Shape decoratedShape, LineStyle style) {
		super(decoratedShape);
		this.style = style;
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		System.out.println("Line Style: "+style);
	}

	//no change from the original Shape functionality
	@Override
	public void resize() {
		decoratedShape.resize();
	}

}
