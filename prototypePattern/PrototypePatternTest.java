package prototypePattern;

/**
 * source: https://www.tutorialspoint.com/design_pattern/prototype_pattern.htm
 * 
 * */

/* This pattern involves implementing a prototype interface which
 * tells to create a clone of the current object. This pattern is 
 * used when creation of object directly is costly. For example, 
 * an object is to be created after a costly database operation. 
 * We can cache the object, returns its clone on next request and 
 * update the database as and when needed thus reducing
 * */

public class PrototypePatternTest {

	public static void main(String[] args) {
		ShapeCache.loadCache();
		
		Shape clonedShape1 = (Shape) ShapeCache.getShape("1");
		Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
		Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
		
		clonedShape1.draw();
		clonedShape2.draw();
		clonedShape3.draw();
	}

}
