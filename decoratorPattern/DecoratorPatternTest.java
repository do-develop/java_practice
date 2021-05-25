package decoratorPattern;

public class DecoratorPatternTest {

	public static void main(String[] args) {
		//System.out.println("Create and Draw Simple Shape Objects");
		//Shape rectangle = new Rectangle();
		//Shape circle = new Circle();
		//rectangle.draw();
		//circle.draw();

		System.out.println("Draw red circle with blue dashed 2.0 thick line");
		Shape circle1 = new FillColorDecorator(new LineColorDecorator(new LineStyleDecorator(
	            new LineThicknessDecorator(new Circle(), 2.0d), LineStyle.DASH), Color.BLUE), Color.RED);
	    circle1.draw();
	    
	    System.out.print("\n");
	    System.out.println("Draw yellow rectangle with green line");
	    Shape rectangle1 = new FillColorDecorator(new LineColorDecorator(new Rectangle(), Color.GREEN),Color.YELLOW);
	    rectangle1.draw();
	    rectangle1.resize();
	    
	    //instead of nesting decorating functionalities it can be implemented separately
	    System.out.print("\n");
	    System.out.println("Draw red circle with dotted violet line");
	    Circle c = new Circle();
	    LineStyleDecorator lstyle = new LineStyleDecorator(c, LineStyle.DOT);
	    LineColorDecorator lcolor = new LineColorDecorator(lstyle, Color.VIOLET);
	    FillColorDecorator fcolor = new FillColorDecorator(lcolor, Color.RED);
	    Shape circleWithDecorator = fcolor;
	    circleWithDecorator.draw();
	    circleWithDecorator.resize();
	}

}
