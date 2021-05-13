package generics;

public class GenericClass <T extends Number, V extends Number> {

	T x;
	V y;
	
	GenericClass(T x, V y){
		this.x = x;
		this.y = y;
	}
	
	public V getValue() {
		return y;
	}
}
